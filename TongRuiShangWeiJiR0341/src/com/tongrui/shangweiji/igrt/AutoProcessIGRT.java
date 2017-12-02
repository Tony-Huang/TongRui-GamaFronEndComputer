/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.igrt;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class AutoProcessIGRT {
    private boolean Simulate_isMoveBedEnd = false;
    private int isAcceptDalt = Constant.RESULT_NULL;

    private final int IGRT_IDLE             = 00;
    private final int IGRT_LOAD_ANSWER      = 01;
    private final int WAIT_LOAD             = 02;
    private final int IGRT_LOAD_READY       = 10;
    private final int TAKE_PHOTO_ANSWER     = 11;
    private final int WAIT_RELOAD           = 12;
    private final int WAIT_DALT             = 13;
    private final int WAIT_DOCTOR_CONFIRM   = 20;
    private final int WAIT_BED              = 21;
    private final int BED_POSITION_IS_OK    = 22;
    private int processState = IGRT_IDLE;
    private SocketClient socketClient;
    
    private float bedX,bedY;
    
    private long markTime = 0;
    private int sentCircles = 0;
    
    public AutoProcessIGRT() {
        socketClient = new SocketClient("Input IGRT IP address here", 3000);
    }

    public void startIGRT() {
        boolean result = sendToIGRT(52);
        if (result == false) {
            socketClient = new SocketClient("Input IGRT IP address here", 3000);
        }
        
        markTime = System.currentTimeMillis();
        sentCircles++;
        processState = TAKE_PHOTO_ANSWER;
    }
    
    public void loadIGRT() {
        boolean result = sendToIGRT(56);
        if (result == false) {
            socketClient = new SocketClient("Input IGRT IP address here", 3000);
        }
        
        markTime = System.currentTimeMillis();
        sentCircles++;
        processState = IGRT_LOAD_ANSWER;
    }
    
    public boolean isReady() {
        return processState == IGRT_LOAD_READY;
    }
    
    public boolean isDaltOK() {
        return processState == WAIT_DOCTOR_CONFIRM;
    }
    
    public int updateProcess() {
        boolean result = false;
        int rs = Constant.RESULT_NULL;
        switch (processState) {
            case IGRT_IDLE:
                //Waiting, do nothing.
                break;
            case IGRT_LOAD_ANSWER:
                rs = answerStateValue();
                if(rs == 6) { 
                    processState = IGRT_LOAD_READY;
                    sentCircles = 0;
                } else if(rs == 12){
                    processState = WAIT_LOAD;
                    sentCircles = 0;
                } else //Waiting
                if (System.currentTimeMillis() - markTime > 1500) {
                    if (sentCircles < 3) {
                        loadIGRT();
                    } else {
                        JOptionPane.showMessageDialog(null, "请求IGRT预加载通信失败!");
                        processState = IGRT_LOAD_READY;
                        sentCircles = 0;
                    }    
                }
            case WAIT_LOAD:
                rs = answerStateValue();
                if(rs == 13) {
                    sendToIGRT(63);
                    processState = IGRT_LOAD_READY;
                } else if(rs == 1){
                    sendToIGRT(51);
                    JOptionPane.showMessageDialog(null, "IGRT预加载出错,请检查IGRT!");
                    processState = IGRT_LOAD_READY;
                } else if(rs != 0){
                    JOptionPane.showMessageDialog(null, "IGRT回送预加载结果状态字错误!");
                    processState = IGRT_LOAD_READY;
                }
                //else, keep this state
                break;
            case IGRT_LOAD_READY:
                //Waiting, do nothing.
                break;
            case TAKE_PHOTO_ANSWER:
                rs = answerStateValue();
                if(rs == 2) { 
                    processState = WAIT_DALT;
                    sentCircles = 0;
                } else if(rs == 12){
                    processState = WAIT_RELOAD;
                    sentCircles = 0;
                } else if(rs != 0){
                    JOptionPane.showMessageDialog(null, "IGRT回复拍片请求状态字错误!");
                    processState = IGRT_LOAD_READY;
                } 
                //else，waiting
                if (System.currentTimeMillis() - markTime > 1500) {
                    if (sentCircles < 3) {
                        startIGRT();
                    } else {
                        JOptionPane.showMessageDialog(null, "请求IGRT启动通信出错!");
                        processState = IGRT_LOAD_READY;
                        sentCircles = 0;
                    }
                }
                break;
            case WAIT_RELOAD:
                rs = answerStateValue();
                if(rs == 13) {
                    sendToIGRT(63);
                    processState = WAIT_DALT;
                } else if(rs == 1){
                    sendToIGRT(51);
                    JOptionPane.showMessageDialog(null, "IGRT载出错,请检查IGRT!");
                    processState = IGRT_LOAD_READY;
                } else if(rs != 0){
                    JOptionPane.showMessageDialog(null, "IGRT回送加载结果状态字错误!");
                    processState = IGRT_LOAD_READY;
                }
                //else, keep this state
                break;
            case WAIT_DALT:
                rs = answerStateValue();
                if (rs == 3) {
                    result = sendToIGRT(53);
                    isAcceptDalt = Constant.RESULT_NULL;
                    processState = WAIT_DOCTOR_CONFIRM;
                } else if(rs == 1){
                    sendToIGRT(51);
                    JOptionPane.showMessageDialog(null, "IGRT计算Dalt出错,请检查IGRT!");
                    processState = IGRT_LOAD_READY;
                } else if (rs != 0) { //State value is wrong
                    JOptionPane.showMessageDialog(null, "IGRT回送状态字错误!");
                    processState = IGRT_LOAD_READY;
                }
                //else, wait
                break;
            case WAIT_DOCTOR_CONFIRM:
                if (ControllerSvcImpl.DEBUG_Linked_Trio == 0) { //Haven't trio
                    if (isAcceptDalt == Constant.RESULT_YES) { //OK, the dalt is accepted
                        processState = BED_POSITION_IS_OK;
                    } else if (isAcceptDalt == Constant.RESULT_NO) {
                        System.out.println("controllSvc.sendCommand(Constant.MOVE_BED_DALT)");
                        processState = WAIT_BED;
                        this.Simulate_isMoveBedEnd = false;
                    }
                } else {
                    if (isAcceptDalt == Constant.RESULT_YES) { //OK, the dalt is accepted
                        processState = BED_POSITION_IS_OK;
                    } else if (isAcceptDalt == Constant.RESULT_NO) {
                        if (checkDaltOk()) {
                            ctrlSvcImplObj.sendCommand(Constant.MOVE_BED_DALT);
                            processState = WAIT_BED;
                            this.Simulate_isMoveBedEnd = false;
                        }
                    }
                    //else, wait
                }
                break;
            case WAIT_BED:
                result = endOfMoveBed();
                if(result == true) { //moving bed is end
                    processState = IGRT_LOAD_READY;
                }
                break;
            case BED_POSITION_IS_OK:
                //Do nothing;
                break;
        }
        System.out.println("Current step is " + processState);
        return processState;
    }
    
    private boolean sendToIGRT(int cmd) {
        socketClient.setSendStatus(cmd);
        return socketClient.sendData();
    }
    
    private int answerStateValue() {
        int result = 0; //0:have not received new data
        if (socketClient.isAnswered()) {
            if (socketClient.isVerified()) {
                result = socketClient.getReceivedStatus();
                bedX = socketClient.getReceivedBedX();
                bedY = socketClient.getReceivedBedY();
            } else {
                result = -1; //data is wrong
            }
            socketClient.clearAnswered();
        }
        return result;
    }

    private boolean endOfMoveBed() {
        if(ControllerSvcImpl.DEBUG_Linked_Trio == 0) {
            return Simulate_isMoveBedEnd;
        } else {
            //wys.TBD
            return false;
        }
    }

    private boolean checkDaltOk() {
        boolean result = true;
        
        //wys.TBD
        //if(dalt is out of range) {
            //reset the normal axile data to 0
            //sendToIGRT(55);
            //resutl = false;
        //}
        
        return result;
    }
    
    public void setSimulate_isMoveBedEnd(boolean Simulate_isMoveBedEnd) {
        this.Simulate_isMoveBedEnd = Simulate_isMoveBedEnd;
    }

    public void setIsAcceptDalt(int isAcceptDalt) {
        this.isAcceptDalt = isAcceptDalt;
    }

    public float getBedX() {
        return bedX;
    }

    public float getBedY() {
        return bedY;
    }
    
    private static ControllerSvcImpl ctrlSvcImplObj = ControllerSvcImpl.getInstance();
}
