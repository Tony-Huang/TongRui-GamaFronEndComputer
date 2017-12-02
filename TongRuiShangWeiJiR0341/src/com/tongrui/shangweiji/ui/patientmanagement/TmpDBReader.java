/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.biz.PatientService;
import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.server.TmpLocator;
import com.tongrui.shangweiji.biz.server.TmpPatientService;
import com.tongrui.shangweiji.data.CatTreatmentFractionState;
import com.tongrui.shangweiji.data.CatTreatmentPatientCase;
import com.tongrui.shangweiji.data.CatTreatmentPlan;
import com.tongrui.shangweiji.data.CatTreatmentPlanFocus;
import com.tongrui.shangweiji.data.CatTreatmentPlanFraction;
import com.tongrui.shangweiji.data.CatTreatmentPlanState;
import com.tongrui.shangweiji.data.server.TmpTreatmentPatientCase;
import com.tongrui.shangweiji.data.server.TmpTreatmentPlan;
import com.tongrui.shangweiji.data.server.TmpTreatmentPlanFocus;
import com.tongrui.shangweiji.data.server.TmpTreatmentPlanFraction;
import com.tongrui.shangweiji.ui.MainWindow;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class TmpDBReader {
    private TmpTreatmentPatientCase tmpCase = null;
    private TmpTreatmentPlan tmpPlan = null;
    private TmpTreatmentPlanFraction tmpFraction = null;
    private TmpTreatmentPlanFocus tmpFocus= null;
    
    private static TmpDBReader instanceTmpDB = new TmpDBReader();
    private boolean isAgeOutRange = false;
    private boolean isAxilesOutRange = false;
    private boolean isExceptionDB = false;
    
    private CatTreatmentPatientCase catCase = null;
    private CatTreatmentPlan catPlan = null;
    private CatTreatmentPlanFraction catFraction = null;
    private CatTreatmentPlanFocus catFocus= null;
    
    private boolean planExisted;
    private boolean fracExisted;
    private boolean focusExisted;
    private boolean hasNewData;
    
    private static final int PLAN_STATE_APPROVED = 1;
    private static final int FRACTION_STATE_NOT_EXECUTED =1;

    public static TmpDBReader getInstanceTmpDB() {
        return instanceTmpDB;
    }

    public boolean isIsAgeOutRange() {
        return isAgeOutRange;
    }

    public boolean isIsAxilesOutRange() {
        return isAxilesOutRange;
    }

    public boolean isIsExceptionDB() {
        return isExceptionDB;
    }

    public void setIsExceptionDB(boolean isExceptionDB) {
        this.isExceptionDB = isExceptionDB;
    }
    
    public void dataTransfer() throws Throwable {
        List<TmpTreatmentPatientCase> listTmpCase = tmpDBSvc.findByIsUpdateByServer((byte)1);

        if (listTmpCase == null || listTmpCase.size() <= 0) {
            return ; //No new date
        }
        
        this.hasNewData = false;
        this.tmpCase = listTmpCase.get(0); //Process only one patient case in this transfer.
        System.out.println("PatientID is: " + this.tmpCase.getPatientId());
        processPatient();
        
        Set<TmpTreatmentPlan> setTmpPlan = this.tmpCase.getTmpTreatmentPlans();
        Iterator<TmpTreatmentPlan> it = setTmpPlan.iterator();
        while(it.hasNext()) {
            tmpPlan = it.next();
            processPlan();
            
            Iterator<TmpTreatmentPlanFraction> itFrac = this.tmpPlan.getTmpTreatmentPlanFractions().iterator();
            while(itFrac.hasNext()) {
                tmpFraction = itFrac.next();
                processFraction();
                
                Iterator<TmpTreatmentPlanFocus> itFoc = this.tmpFraction.getTmpTreatmentPlanFocuses().iterator();
                while(itFoc.hasNext()) {
                    tmpFocus = itFoc.next();
                    processFocus();
                }
            }
        }
        
        if(this.hasNewData) {
            ps.saveOrUpdate(this.catCase);
            
            tmpCase.setIsUpdateByServer((byte)0);
            tmpDBSvc.update(tmpCase);
        }
        return;
    }
  
     private void processPatient() throws Throwable{
        CatTreatmentPatientCase dbPatient = null;
        String patientID = this.tmpCase.getPatientId();
        
        try {
            dbPatient = ps.findByPatientID(patientID);
        } catch (Throwable e) {
            throw e;
        }
         
        if (dbPatient != null) {
            System.out.println("---existed  patient for :"+patientID);
            this.catCase = dbPatient;
        }
        else{
            System.out.println("---new  patient for :" + patientID);
            setCaseValues();
        }
    }
     
     private void processPlan(){
        CatTreatmentPlan dbPlan = null;
         
         Iterator<CatTreatmentPlan> it = this.catCase.getCatTreatmentPlans().iterator();
         while (it.hasNext()) {
             dbPlan = it.next();
             if (dbPlan.getCourseNumber() == this.tmpPlan.getCourseNumber()) {
                 this.catPlan = dbPlan;
                 this.planExisted = true;
                 System.out.println("---existed  plan coursebumber for :" + dbPlan.getCourseNumber());
                 break;
             }
         }
         
         if (!this.planExisted) {
             System.out.println("---new plan coursebumber for :" + tmpPlan.getCourseNumber());
             setPlanValues();
         }
    }
     
    private void processFraction() {
        CatTreatmentPlanFraction dbFraction = null;
        
        Iterator<CatTreatmentPlanFraction> it = this.catPlan.getCatTreatmentPlanFractions().iterator();
         while (it.hasNext()) {
             dbFraction = it.next();
             if (dbFraction.getFractionNomber() == this.tmpFraction.getFractionNomber()) {
                 this.catFraction = dbFraction;
                 this.fracExisted = true;
                 System.out.println("--- fraction exist!!!");
                 break;
             }
         }
         if(!this.fracExisted) {
             System.out.println("---new fraction for :" + tmpFraction.getFractionNomber());
             setFractionValues();
         }
    }
    
    private void processFocus() {
        CatTreatmentPlanFocus dbFocus = null;
        Iterator<CatTreatmentPlanFocus> it = this.catFraction.getCatTreatmentPlanFocuses().iterator();
        this.focusExisted = false;
        while(it.hasNext()) {
            dbFocus = it.next();
            if(dbFocus.getFocusNumber() == this.tmpFocus.getFocusNumber()) {
                this.catFocus = dbFocus;
                this.focusExisted = true;
                System.out.println("--- Focus exist!!!");
                break;
            }
        }
        if(!this.focusExisted) {
            System.out.println("---new focus for :" + tmpFocus.getFocusNumber());
            if(setFocusValues()) {
                this.hasNewData = true;
            } else {
                this.hasNewData = false;
            }
        }
    }
  
    private void setCaseValues() {
        this.catCase = new CatTreatmentPatientCase();
        Set<CatTreatmentPlan> plans = new HashSet<CatTreatmentPlan>();
        this.catCase.setCatTreatmentPlans(plans);
        this.catCase.setAge     (this.tmpCase.getAge());
        this.catCase.setBirthDay(this.tmpCase.getBirthDay());
        this.catCase.setHeight  (this.tmpCase.getHeight());
        this.catCase.setName    (this.tmpCase.getName());
        this.catCase.setPatientId(this.tmpCase.getPatientId());
        this.catCase.setSex     (this.tmpCase.getSex());
        this.catCase.setWeight  (this.tmpCase.getWeight());
    }

    private void setPlanValues() {
        this.catPlan = new CatTreatmentPlan();
        
        this.catCase.getCatTreatmentPlans().add(this.catPlan);
        Set<CatTreatmentPlanFraction> fracs = new HashSet<CatTreatmentPlanFraction>();
        this.catPlan.setCatTreatmentPlanFractions(fracs);
        
        this.catPlan.setCatTreatmentPatientCase(this.catCase);
        this.catPlan.setCourseNumber           (this.tmpPlan.getCourseNumber());
        this.catPlan.setPlanName               (this.tmpPlan.getPlanName());
        this.catPlan.setDiaglose               (this.tmpPlan.getDiaglose());
        this.catPlan.setTreatmentPart          (this.tmpPlan.getTreatmentPart());
        this.catPlan.setFocusCount             (this.tmpPlan.getFocusCount());
        this.catPlan.setFractionCount          (this.tmpPlan.getFractionCount());
        this.catPlan.setDose                   (this.tmpPlan.getDose());
        this.catPlan.setReferper               (this.tmpPlan.getReferper());
        this.catPlan.setDoctorName             (this.tmpPlan.getDoctorName());
        this.catPlan.setPlanDate               (this.tmpPlan.getPlanDate());
        this.catPlan.setPlanLockDate           (this.tmpPlan.getPlanLockDate());
        this.catPlan.setSerialNumber           (this.tmpPlan.getSerialNumber());
        this.catPlan.setApprovalDoctorName     (this.tmpPlan.getApprovalDoctorName());
        this.catPlan.setApprovalDate           (this.tmpPlan.getApprovalDate());
        
        CatTreatmentPlanState approvedstate = new CatTreatmentPlanState();
        approvedstate.setId(PLAN_STATE_APPROVED);
        this.catPlan.setCatTreatmentPlanState(approvedstate);
    }
    
    private void setFractionValues() {
        this.catFraction = new CatTreatmentPlanFraction();
        
        this.catPlan.getCatTreatmentPlanFractions().add(this.catFraction);
        Set<CatTreatmentPlanFocus> focuses = new HashSet<CatTreatmentPlanFocus>();
        this.catFraction.setCatTreatmentPlanFocuses(focuses);
        
        this.catFraction.setCatTreatmentPatientCase(this.catCase);
        this.catFraction.setCatTreatmentPlan(this.catPlan);
        this.catFraction.setFractionNomber(this.tmpFraction.getFractionNomber());
        this.catFraction.setDueDate(this.tmpFraction.getDueDate());
        this.catFraction.setIsAppended(this.tmpFraction.getIsAppended());
        this.catFraction.setAppendDoctorName(this.tmpFraction.getAppendDoctorName());
        this.catFraction.setIsIgrtflag(this.tmpFraction.getIsIgrtflag());
        this.catFraction.setPhotoNumber(this.tmpFraction.getPhotoNumber());
        this.catFraction.setImagePath(this.tmpFraction.getImagePath());
        this.catFraction.setRegister(this.tmpFraction.getRegister());
        
        CatTreatmentFractionState fracstate = new CatTreatmentFractionState();
        fracstate.setId(FRACTION_STATE_NOT_EXECUTED);
        this.catFraction.setCatTreatmentFractionState(fracstate);
    }
    
    private boolean setFocusValues(){
        this.catFocus = new CatTreatmentPlanFocus();
        
        this.catFraction.getCatTreatmentPlanFocuses().add(this.catFocus);
        
        this.catFocus.setCatTreatmentPlanFraction(this.catFraction);
        this.catFocus.setFocusNumber(this.tmpFocus.getFocusNumber());
        this.catFocus.setEnabled(this.tmpFocus.getEnabled());
        
        MainWindow mainWin = MainWindow.getInstance();
        float x11f = this.tmpFocus.getPlanX();
        float y11f = this.tmpFocus.getPlanY();
        float x2f = this.tmpFocus.getPlanZ();
        if (x11f < mainWin.getLowLimitX11() || x11f > mainWin.getUpLimitX11()) { //wys.Maybe should change a method
            isAxilesOutRange = true;
            return false;
        }
        if (y11f < mainWin.getLowLimitY11() || y11f > mainWin.getUpLimitY11()) {
            isAxilesOutRange = true;
            return false;
        }
        if (x2f < mainWin.getLowLimitX2() || x2f > mainWin.getUpLimitX2()) {
            isAxilesOutRange = true;
            return false;
        }

        this.catFocus.setPlanX(x11f);
        this.catFocus.setPlanY(y11f);
        this.catFocus.setPlanZ(x2f);
        this.catFocus.setCouchX(this.tmpFocus.getCouchX());
        this.catFocus.setCouchY(this.tmpFocus.getCouchY());
        this.catFocus.setCouchZ(this.tmpFocus.getCouchZ());
        this.catFocus.setPlanCurePeriod(this.tmpFocus.getPlanCurePeriod());
        
        return true;
    }
    
    private  static  TmpPatientService tmpDBSvc = TmpLocator.getTmpDBService();
    private PatientService ps = ServiceLocator.getPatientService();
}
