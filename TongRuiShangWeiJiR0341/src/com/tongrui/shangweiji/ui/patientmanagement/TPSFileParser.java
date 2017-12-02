/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.biz.PatientService;
import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.data.*;
import com.tongrui.shangweiji.ui.MainWindow;
import common.DateUtil;
import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class TPSFileParser {
    private static final String PATIENT_START = "[Plan Parameter]";
    private static final String PLAN_START = "Patient_Diagnosis";
    
    private static final String FRACTION_START1 = "Fraction_Number";
    private static final String FRACTION_START2 = "Photo_Number";
    private static final String FOCUS_START = "Focus_index"; 
    
    private static TPSFileParser instanceTPS = new TPSFileParser();
     
    private static final int PLAN_STATE_APPROVED = 1;
    private static final int FRACTION_STATE_NOT_EXECUTED =1;
    
    private boolean isAgeOutRange = false;
    private boolean isAxilesOutRange = false;

    public static TPSFileParser getInstanceTPS() {
        return instanceTPS;
    }

    public boolean isIsAgeOutRange() {
        return isAgeOutRange;
    }

    public boolean isIsAxilesOutRange() {
        return isAxilesOutRange;
    }
    
    private CatTreatmentPatientCase patient =null;

    public CatTreatmentPatientCase getPatient() {
        return patient;
    }
    private CatTreatmentPlan plan =null;
    private CatTreatmentPlanFraction defaultFrac =null;
    private CatTreatmentPlanFocus defaultFocus =null;
    private boolean planExisted;
    private boolean fracExisted;
    private boolean focusExisted;
    
    
    private PatientService ps = ServiceLocator.getPatientService();
    
    //private List<String> lines;
    
    
    public boolean parse(List<String> lines) throws Throwable {
        int state = -1 ;
        MainWindow mainWin = MainWindow.getInstance();
          
       for(int i = 0; i<lines.size(); i++){
         String line = lines.get(i);
         
         if(line.isEmpty()) {
             continue;
         }
         
         if(line.indexOf(PATIENT_START)>-1){
           state = 0;
           patient =new CatTreatmentPatientCase();
           
           continue;
         }
         else if (line.indexOf(PLAN_START)>-1){
             state =1;
         }
         else if( line.indexOf(FRACTION_START1)>-1 || line.indexOf(FRACTION_START2)>-1){
             state =2; //wys.TBD FRACTION_START2 can be removed
         }
         else if(line.indexOf(FOCUS_START) >-1 ){
            state = 3 ;
            defaultFocus = new CatTreatmentPlanFocus();
            String focusNumber = this.getValueByName(line, "[Focus_index");
            focusNumber = focusNumber.substring(0, focusNumber.length()-1); //Remove the last ']'
            if(focusNumber!=null) defaultFocus.setFocusNumber(Integer.valueOf(focusNumber));
            defaultFocus.setCatTreatmentPlanFraction(defaultFrac);
            
            this.initFocus(focusNumber); //this.initFocus(defaultFrac, focusNumber);
          
           continue;
         }
        
        switch (state)  {
                //create patient
                case 0:
                    String patientName = getValueByName(line,"Patient_Name");
                    String patientID = this.getValueByName(line,"Patient_ID");
                    String patientBirthday = this.getValueByName(line,"Patient_BirthDate");
                    String patientGender = this.getValueByName(line,"Patient_Gender");
                    if( patientName!=null) {
                       // String normName= new String("GBK",patientName);
                        System.out.println("name="+patientName);
                        patient.setName(patientName);
                    }
                    if(patientID != null) {
                        try {
                            this.initPatient(patientID);
                        } catch (Throwable ex) {
                            Logger.getLogger(TPSFileParser.class.getName()).log(Level.SEVERE, null, ex);
                            throw ex;
                        }
                    }
                    if(patientBirthday!=null) {
                      Date birthDay=  DateUtil.getDate(patientBirthday);
                      patient.setBirthDay(birthDay);
                      Date now = new Date();
                      int age =now.getYear()-birthDay.getYear();
                      if(age < 0 || age > 150) {
                          isAgeOutRange = true;
                          return false;
                      }
                      isAgeOutRange = false;
                      patient.setAge(age);
                        
                    }
                    if(patientGender!=null){
                     int sex = patientGender.equalsIgnoreCase("Male")? 1:0;
                     patient.setSex((byte)sex);
                    }
                    break;
                    
                //create plan     
                case 1:
                    if(plan==null){ 
                        plan = new  CatTreatmentPlan();
                        CatTreatmentPlanState approvedstate = new CatTreatmentPlanState();
                        approvedstate.setId(PLAN_STATE_APPROVED);
                        plan.setCatTreatmentPlanState(approvedstate);
                    }
                    String diagnose = getValueByName(line,"Patient_Diagnosis");
                    //String treatmentPart = "Head";  //备用
                    String doctor = getValueByName(line,"Doctor");
                    String approvalDoctor = getValueByName(line,"Planner");
                    String planDate = getValueByName(line,"Plan_Date");
                    String planLockDate = getValueByName(line,"Plan_Date_Outputed"); 
                    String approvalDate = planLockDate;
                    String focusCount = getValueByName(line,"Focus_Number"); 
                 
                    
                    if(diagnose!=null) plan.setDiaglose(diagnose); 
                    if(doctor!=null) plan.setDoctorName(doctor);
                    if(approvalDoctor!=null) {
                        plan.setApprovalDoctorName(approvalDoctor);
                        plan.setTreatmentPart("Head");    //wys.对头刀,总是头部
                    }
                    if(planDate!=null){
                        plan.setPlanDate(DateUtil.getDate(planDate));
                        initPlan(planDate); //wys.TBRemoved
                    }
                    if(planLockDate!=null) plan.setPlanLockDate(DateUtil.getDate(planLockDate));
                    if(approvalDate!=null) plan.setApprovalDate(DateUtil.getDate(approvalDate));
                    if(focusCount!=null) plan.setFocusCount(Integer.valueOf(focusCount));
                    
//wys.TBCompleted                    getPlanName();
//                    if(planName != null && !planName.isEmpty()) {
//                        plan.setPlanName("wys?,No name in TPS file");
//                        initPlan(planName); //This function has not completed
//                    }
                    
                    
                    
                    break;
                   
                    //ceate fraction 
                case 2:
                   if(defaultFrac==null) {
                       defaultFrac = new CatTreatmentPlanFraction();
                       defaultFrac.setFractionNomber(Integer.valueOf("1")); //wys!.default because there is no this value in TPS file.
                       //FRACTION_STATE_NOT_EXECUTED
                       CatTreatmentFractionState fracstate = new CatTreatmentFractionState();
                       fracstate.setId(FRACTION_STATE_NOT_EXECUTED);
                       defaultFrac.setCatTreatmentFractionState(fracstate);
                       defaultFrac.setCatTreatmentPatientCase(patient);
                       defaultFrac.setCatTreatmentPlan(plan);
                       
                       }
                   String fracNumber = this.getValueByName(line, "Fraction_Number");
                   if(fracNumber!=null) plan.setFractionCount(Integer.valueOf(fracNumber));//wys!.目前显示时这个值是统计出来的
                   String currentFracNumber =  this.getValueByName(line, "Current_Fraction"); 
                   if(currentFracNumber!=null){
                     defaultFrac.setFractionNomber(Integer.valueOf(currentFracNumber));
                     this.initFraction(currentFracNumber);
                   }
                   String photoNumber = this.getValueByName(line, "Photo_Number"); 
                   if(photoNumber!=null) { //wys."photoNumber"是后解析的,所以这个条件在循环中只成立一次.
                      defaultFrac.setPhotoNumber(Integer.valueOf(photoNumber));
                      if(defaultFrac.getFractionNomber()!=null) //wys.这条语句只被执行一次
                         this.initFraction(defaultFrac.getFractionNomber().toString()); //wys.这两条语句应该可以取掉,前已执行过了.13-4-12
                   }
                   
                    break;
                    
               //create focus...     
                case 3 :
                    if(this.defaultFocus ==null){
                     defaultFocus = new CatTreatmentPlanFocus();
                     defaultFocus.setCatTreatmentPlanFraction(defaultFrac);
                    }
                 String enable = this.getValueByName(line, "Enable");
                 String x11 =this.getValueByName(line, "Focus_X"); //Focus_X
                 String y11 =this.getValueByName(line, "Focus_Y");
                 String x2 = this.getValueByName(line, "Focus_Z");
                 String collatorNum= this.getValueByName(line, "Focus_Collimator");
                 String time =this.getValueByName(line, "Time");
                 
                 float x11f = Float.valueOf(x11);
                 float y11f = Float.valueOf(y11);
                 float x2f = Float.valueOf(x2);
                 if(x11f < mainWin.getLowLimitX11() || x11f > mainWin.getUpLimitX11()) { //wys.Maybe should change a method
                     isAxilesOutRange = true;
                     return false;
                 }if(y11f < mainWin.getLowLimitY11() || y11f > mainWin.getUpLimitY11()) {
                     isAxilesOutRange = true;
                     return false;
                 }if(x2f < mainWin.getLowLimitX2() || x2f > mainWin.getUpLimitX2()) {
                     isAxilesOutRange = true;
                     return false;
                 }
                 
                 isAxilesOutRange = false;
                 if(enable!=null) this.defaultFocus.setEnabled(Short.valueOf(enable));
                 if(x11!=null) this.defaultFocus.setPlanX(x11f);
                 if(y11!=null) this.defaultFocus.setPlanY(x11f);
                 if(x2!=null) this.defaultFocus.setPlanZ(x11f);
                 if(collatorNum!=null) this.defaultFocus.setCollType(Integer.valueOf(collatorNum));
                 if(time!=null) this.defaultFocus.setPlanCurePeriod(Float.valueOf(time));
                 break;
                    
                
                default:
                    break;
         
           }
        }
        return true;
    }
    
    /**
     * 
     * @param patientID 
     */
    private void initPatient(String patientID) throws Throwable{
        this.patient.setPatientId(patientID);
        
        CatTreatmentPatientCase existedPatient = null;
        try {
            existedPatient = ps.findByPatientID(patientID);
        } catch (Throwable e) {
            throw e;
        }
         
        if (existedPatient != null) {
           System.out.println("---existed  patient for :"+patientID);
            this.patient = existedPatient;
        }
        else{
            Set<CatTreatmentPlan> plans = new HashSet<CatTreatmentPlan>();
            this.patient.setCatTreatmentPlans(plans);
            System.out.println("---new  patient for :" + patientID);
        }
        
    }
    /**
     * 
     * @param patient. CatTreatmentPatientCase patient
     * @param planDate   
     */
    private void initPlan(String planDate){
     Set<CatTreatmentPlan>  plans = patient.getCatTreatmentPlans();
     Iterator<CatTreatmentPlan> it = plans.iterator();
     while(it.hasNext()){
      CatTreatmentPlan dbplan =   it.next();
      Date date= dbplan.getPlanDate();
      String dbdateStr=  DateUtil.getDateString(date);
      if(dbdateStr.equalsIgnoreCase(planDate)){
          this.plan =dbplan;
          this.planExisted =true;
          System.out.println("---existed  pan for :"+planDate);
          //planexist =true;
          break;
       }
      }
     
     if(!this.planExisted){
          Set<CatTreatmentPlanFraction> fracs = new HashSet<CatTreatmentPlanFraction>();
          this.plan.setCatTreatmentPlanFractions(fracs);
          plan.setCatTreatmentPatientCase(patient);
           System.out.println("---new  pan for :"+planDate);
          //add to patient's child
         plans.add(plan);
     }
     
    }
    
    /**
     * 
     * @param plan CatTreatmentPlan plan,
     * @param fracNumber 
     */
    private void initFraction(String fracNumber){
     //if(!this.planExisted) return;
     Set<CatTreatmentPlanFraction>  fracs = plan.getCatTreatmentPlanFractions();
     Iterator<CatTreatmentPlanFraction> it = fracs.iterator();
     while(it.hasNext()){
       CatTreatmentPlanFraction dbfrac = it.next();
       Integer dbfracnum =dbfrac.getFractionNomber();
        if(dbfracnum.toString().equals(fracNumber)){
         this.defaultFrac = dbfrac;
         this.fracExisted =true;
         
          System.out.println("--- fraction exist!!!");
          break;
        }
      }
     
     if(!this.fracExisted){
      Set<CatTreatmentPlanFocus>  focuses= new HashSet<CatTreatmentPlanFocus>();
      this.defaultFrac.setCatTreatmentPlanFocuses(focuses);
      
      System.out.println("--- new fraction!!!,add frac to plan:"+this.plan);
      //add to plan's child
       fracs.add(defaultFrac);
     }
     
    }
    
   /**
    * 
    * @param frac  CatTreatmentPlanFraction frac,
    * @param focusNumber 
    */
  private void initFocus( String focusNumber ){
     Set<CatTreatmentPlanFocus> focuses = this.defaultFrac.getCatTreatmentPlanFocuses();
     Iterator<CatTreatmentPlanFocus> it = focuses.iterator();
     while(it.hasNext()){
       CatTreatmentPlanFocus dbfocus =  it.next();
       Integer dbFocusNum =  dbfocus.getFocusNumber();
       if(dbFocusNum.toString().equals(focusNumber)){
         this.focusExisted =true;
         this.defaultFocus = dbfocus;
           System.out.println("--- existed focus!!!");
         break;
       }
     }
     
     if(!this.focusExisted){
         this.defaultFocus.setCatTreatmentPlanFraction(defaultFrac);
           System.out.println("--- new focus!!!,add focus to frac:"+this.defaultFrac);
       //add to frac's child
         focuses.add(defaultFocus);
     }
  }  
    
    
      String getValue(String line){
         String result = null;
         int idx =line.indexOf("=");
         if(!line.endsWith("="))
          result =  line.substring(idx+1);
         return result;
        }
      
       String getName(String line){
         String result = null;
         int idx =line.indexOf("=");
         
         if(idx >= 1)
          result =  line.substring(0,idx);
         
         return result;
        }
       
//       String getValueByName(String name){
//         for(String line:this.lines){
//           if( getName(line).equalsIgnoreCase(name) ){
//            return getValue(line);
//           }
//         }
//         return null;
//       }
       
       String getValueByName(String line,String name){
           //System.out.println(" line :"+line +" search name:"+name);
         String nameInLine = this.getName(line);
         if(nameInLine!=null&&nameInLine.equalsIgnoreCase(name)){
          return this.getValue(line);
         }
         else return null;
       }

       public static void main(String[] args)  throws Exception{
       TPSFileParser p = TPSFileParser.getInstanceTPS();
     // String name= p.getName("Patient_Name=HeadSphere");
     // String value = p.getValue("Patient_Name=HeadSphere");
    //  System.out.println(name+"-"+value);
      
         TPSFileReader tf = new TPSFileReader();
         CalcCRC crc = new CalcCRC();
         String filePath = "D:/TPS/09001@HeadSphere@0900110.out";
         File f = new File(filePath);
         List<String> content = tf.readFile(f);
         System.out.println(content);
         System.out.println("total lines =" + content.size());

         if (crc.isCrcCorrect(content)) {
            try {
                if(p.parse(content)) {
                    p.ps.saveOrUpdate(p.patient);
                }
            } catch (Throwable ex) {
                Logger.getLogger(TPSFileParser.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "本地数据库访问出错!");
            }
         } else {
             JOptionPane.showMessageDialog(null, "CRC of TPS file is wrong!");
         }
    }
}
