/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.comm;

/**
 *
 * @author Administrator
 */
public interface Constant {
    //----------for UI layer--------------
    public final static int MANUL_AXILES_STOP   = 1;
    public final static int MANUL_CHANGE_UNIT_k = 2;
    public final static int MANUL_X11_LEFT      = 3;
    public final static int MANUL_X11_RIGHT     = 4;
    public final static int MANUL_X11_ZERO      = 5;
    public final static int MANUL_X11_POINT     = 6;
    public final static int MANUL_Y11_UP        = 7;
    public final static int MANUL_Y11_DOWN      = 8;
    public final static int MANUL_Y11_ZERO      = 9;
    public final static int MANUL_Y11_POINT     = 10;
    public final static int MANUL_Z11_IN        = 11;
    public final static int MANUL_Z11_OUT       = 12;
    public final static int MANUL_Z11_ZERO      = 13;
    public final static int MANUL_Z11_POINT     = 14;
    public final static int MANUL_X12_LEFT      = 15;
    public final static int MANUL_X12_RIGHT     = 16;
    public final static int MANUL_X12_ZERO      = 17;
    public final static int MANUL_X12_POINT     = 18;
    public final static int MANUL_X2_IN         = 19;
    public final static int MANUL_X2_OUT        = 20;
    public final static int MANUL_X2_ZERO       = 21;
    public final static int MANUL_X2_POINT      = 22;
    public final static int MANUL_Y2_UP         = 23;
    public final static int MANUL_Y2_DOWN       = 24;
    public final static int MANUL_Y2_ZERO       = 25;
    public final static int MANUL_Y2_POINT      = 26;
    public final static int MANUL_SCREW_NEXT    = 27;
    
    public final static int MANUL_T2_ROTATE     = 50;
    public final static int MANUL_T2_ZERO       = 51;
    public final static int MANUL_T2_POINT      = 52;
    public final static int MANUL_Z2_ROTATE     = 53;
    public final static int MANUL_Z2_ZERO       = 54;
    public final static int MANUL_Z2_POINT      = 55;
    public final static int MANUL_T2Z2_ROTATE   = 56;
    
    public final static int REFERENCE_DEVICE_BACK   = 100;
    public final static int REFERENCE_RADIATE_START = 101;
    
    public final static int PARA_UP_BED_POS        = 150;
    public final static int PARA_DOWN_BED_POS      = 151;
    public final static int PARA_CHANGE_FOCUS_POS  = 152;
    public final static int PARA_REF_POINT_POS     = 153;
    public final static int PARA_REF_POINT_ADJ     = 154; //wys.To be removed
    public final static int PARA_RADIO_COMPENSATE  = 155; //开源补偿
    public final static int PARA_ZERO_BIAS          = 156;
    public final static int PARA_MANUL_SPEED       = 157;
    public final static int PARA_AUTO_SPEED        = 158;
    public final static int PARA_COMPENSATE_X2     = 159;
    public final static int PARA_COMPENSATE_X2i    = 160;
    public final static int PARA_COMPENSATE_X11    = 161;
    public final static int PARA_COMPENSATE_X11i   = 162;
    public final static int PARA_COMPENSATE_Y11    = 163;
    public final static int PARA_COMPENSATE_Y11i   = 164;
    public final static int PARA_CHANGE_SOURCE_POS1 = 165;
        
    public final static int CURE_AUTO_SUSPEND      = 200;
    public final static int CURE_AUTO_CHECK        = 201;
    
    //For IGRT process
    public final static int MOVE_BED_DALT          = 250;
    
    //----------------for ControllerSvcImpl-------------
    public final static short ADDR_ADJUST_MODEL    = 524;
    public final static short ADDR_ADJUST_STOP     = 711;
    public final static short ADDR_CHANGE_SOURCE_CMD  = 157;
    public final static short ADDR_CHANGE_SOURCE_POS1 = 601;
    public final static short ADDR_CHANGE_SOURCE_IDX  = 602;
    public final static short ADDR_T2Z2_ASYN_SYN   = 525;
    public final static short ADDR_BACK2_ZERO      = 513;
    public final static short ADDR_REF_START       = 156;
    public final static short ADDR_REF_RAD_PERIOD  = 509;
    public final static short ADDR_UP_BED_POS_Y2   = 500;
    public final static short ADDR_UP_BED_POS_Y11  = 501;
    public final static short ADDR_UP_BED_POS_Z11  = 502;
    public final static short ADDR_UP_BED_POS_X2   = 503;
    public final static short MOVING_STATE_X11     = 603;
    public final static short MOVING_STATE_Y11     = 604;
    public final static short MOVING_STATE_Z11     = 605;
    public final static short MOVING_STATE_X12     = 606;
    public final static short MOVING_STATE_X2      = 607;
    public final static short MOVING_STATE_Y2      = 608;
    public final static short MOVING_STATE_Z2      = 609;
    public final static short MOVING_STATE_T2      = 610;
    public final static short ADDR_DOWN_BED_POS_Y2 = 611;
    public final static short ADDR_DOWN_BED_POS_Y11= 612;
    public final static short ADDR_DOWN_BED_POS_Z11= 613;
    public final static short ADDR_DOWN_BED_POS_X2 = 614;
    public final static short ADDR_CHANGE_FOCUS_Y2 = 615;
    public final static short ADDR_CHANGE_FOCUS_Y11= 616;
    public final static short ADDR_CHANGE_FOCUS_Z11= 617;
    public final static short ADDR_CHANGE_FOCUS_X2 = 618;
    public final static short ADDR_REF_POINT_Y11  = 506;
    public final static short ADDR_REF_POINT_Z11  = 507;
    public final static short ADDR_REF_POINT_X2   = 508;
    public final static short ADDR_ZERO_BIAS_X11   = 141;
    public final static short ADDR_ZERO_BIAS_Y11   = 142;
    public final static short ADDR_ZERO_BIAS_Z11   = 143;
    public final static short ADDR_ZERO_BIAS_X12   = 144;
    public final static short ADDR_ZERO_BIAS_X2    = 145;
    public final static short ADDR_ZERO_BIAS_Y2    = 146;
    public final static short ADDR_ZERO_BIAS_Z2    = 147;
    public final static short ADDR_ZERO_BIAS_T2    = 148;
    
    public final static short ADDR_AUTO_SPEED_X11 = 551;
    public final static short ADDR_AUTO_SPEED_Y11 = 552;
    public final static short ADDR_AUTO_SPEED_Z11 = 553;
    public final static short ADDR_AUTO_SPEED_X12 = 554;
    public final static short ADDR_AUTO_SPEED_X2  = 554;
    public final static short ADDR_AUTO_SPEED_Y2  = 556;
    public final static short ADDR_AUTO_SPEED_Z2  = 557;
    public final static short ADDR_AUTO_SPEED_T2  = 558;
    public final static short ADDR_MANUL_SPEED_X11= 561;
    public final static short ADDR_MANUL_SPEED_Y11= 562;
    public final static short ADDR_MANUL_SPEED_Z11= 563;
    public final static short ADDR_MANUL_SPEED_X12= 564;
    public final static short ADDR_MANUL_SPEED_X2 = 564;
    public final static short ADDR_MANUL_SPEED_Y2 = 566;
    public final static short ADDR_MANUL_SPEED_Z2 = 567;
    public final static short ADDR_MANUL_SPEED_T2 = 568;
    public final static short ADDR_T2Z2_SYN        = 525;
    public final static short ADDR_MANUL_POINT_X11 = 526;
    public final static short ADDR_MANUL_POINT_Y11 = 527;
    public final static short ADDR_MANUL_POINT_Z11 = 528;
    public final static short ADDR_MANUL_POINT_X12 = 529;
    public final static short ADDR_MANUL_POINT_X2  = 530;
    public final static short ADDR_MANUL_POINT_Y2  = 531;
    public final static short ADDR_MANUL_POINT_Z2  = 532;
    public final static short ADDR_MANUL_POINT_T2  = 533;
    public final static short ADDR_CURE_AUTO_ACTION = 122;
    public final static short ADDR_AUTO_CHECK     = 101;
    public final static short ADDR_POS_X11        = 800;
    public final static short ADDR_POS_Y11        = 801;
    public final static short ADDR_POS_Z11        = 802;
    public final static short ADDR_POS_X12        = 803;
    public final static short ADDR_POS_X2         = 804;
    public final static short ADDR_POS_Y2         = 806;
    public final static short ADDR_POS_Z2         = 807;
    public final static short ADDR_POS_T2         = 808;
    public final static short ADDR_DIFFERENCE_Y11 = 811;
    public final static short ADDR_TIMER1         = 130;
    public final static short ADDR_TIMER2         = 131;
    public final static short ADDR_FOCUS_POS_X11  = 515;
    public final static short ADDR_FOCUS_POS_Y11  = 516;
    public final static short ADDR_FOCUS_POS_X2   = 519;
    public final static short ADDR_CURE_START_END = 122;
    public final static short ADDR_COLL_NUMBER    = 520;
    public final static short ADDR_RADIO_PERIOD   = 521;
    public final static short ADDR_RADIO_COMPENSATE = 522;
    public final static short ADDR_CURE_COLL_POS  = 523;
    public final static short ADDR_MOVING_STATE   = 100;
    public final static short ADDR_IO_VR102       = 102;
    public final static short ADDR_IO_VR103       = 103;
    public final static short ADDR_IO_VR104       = 104;
    public final static short ADDR_IO_VR105       = 105;
    public final static short ADDR_IO_VR106       = 106;
    public final static short ADDR_IO_VR107       = 107;
    public final static short ADDR_IO_VR108       = 108;
    public final static short ADDR_IO_VR109       = 109;
    public final static short ADDR_SERVO_VR110    = 110;
    public final static short ADDR_SERVO_VR111    = 111;
    public final static short ADDR_SERVO_VR112    = 112;
    public final static short ADDR_SERVO_VR113    = 113;
    public final static short ADDR_SERVO_VR114    = 114;
    public final static short ADDR_SERVO_VR115    = 115;
    public final static short ADDR_SERVO_VR116    = 116;
    public final static short ADDR_SERVO_VR117    = 117;
    public final static short ADDR_IO_VR120       = 120;
    public final static short ADDR_IO_VR158       = 158;
    public final static short ADDR_IO_VR159       = 159;
    public final static short ADDR_IO_VR160       = 160;
    
    public final static short ADDR_BUTTON_MOVE    = 123;
    public final static short ADDR_TO_ZERO        = 513;
    public final static short ADDR_TO_POINT       = 524;
    
    public final static int BIT_AXILE_POSITIVE_X11 = 0x0001; 
    public final static int BIT_AXILE_POSITIVE_Y11 = 0x0002; 
    public final static int BIT_AXILE_POSITIVE_Z11 = 0x0004; 
    public final static int BIT_AXILE_POSITIVE_X12 = 0x0008; 
    public final static int BIT_AXILE_POSITIVE_X2  = 0x0010; 
    public final static int BIT_AXILE_POSITIVE_Y2  = 0x0020; 
    public final static int BIT_AXILE_POSITIVE_Z2  = 0x0040; 
    public final static int BIT_AXILE_POSITIVE_T2  = 0x0080; 
    public final static int BIT_AXILE_NEGATIVE_X11 = 0x0100; 
    public final static int BIT_AXILE_NEGATIVE_Y11 = 0x0200; 
    public final static int BIT_AXILE_NEGATIVE_Z11 = 0x0400; 
    public final static int BIT_AXILE_NEGATIVE_X12 = 0x0800; 
    public final static int BIT_AXILE_NEGATIVE_X2  = 0x1000; 
    public final static int BIT_AXILE_NEGATIVE_Y2  = 0x2000; 
    public final static int BIT_AXILE_NEGATIVE_Z2  = 0x4000; 
    public final static int BIT_AXILE_NEGATIVE_T2  = 0x8000; 
    
    //For VR102
    public final static int BIT_EMG_STOP            = 0x0001;
    public final static int BIT_PLC_CLOSE_SOURCE    = 0x0002;
    public final static int BIT_MANUAL_PHOTO_START  = 0x0004;
    public final static int BIT_CURE_ENABLE         = 0x0008;
    public final static int BIT_PHOTO_ENABLE        = 0x0010;
    public final static int BIT_CURE_START          = 0x0020;
    public final static int BIT_CURE_STOP           = 0x0040;
    public final static int BIT_SAFE_LOCKS          = 0x0080;
    public final static int BIT_Z2_ZERO             = 0x0100;
    public final static int BIT_Z2_SHIELD           = 0x0200;
    public final static int BIT_COLL_1              = 0x0400;
    public final static int BIT_COLL_2              = 0x0800;
    public final static int BIT_COLL_3              = 0x1000;
    public final static int BIT_COLL_4              = 0x2000;
    public final static int BIT_T2_ZERO             = 0x4000;
    public final static int BIT_T2_SHIELD           = 0x8000;
    //For VR103
    public final static int BIT_Y2_LIMIT_UP         = 0x0001;
    public final static int BIT_Y2_LIMIT_DOWN       = 0x0002;
    public final static int BIT_Y11_ZERO            = 0x0004;
    public final static int BIT_Y11_LIMIT_UP        = 0x0008;
    public final static int BIT_Y11_LIMIT_DOWN      = 0x0010;
    public final static int BIT_Z11_ZERO            = 0x0020;
    public final static int BIT_Z11_LIMIT_OUT       = 0x0040;
    public final static int BIT_Z11_LIMIT_IN        = 0x0080;
    public final static int BIT_X2_LIMIT_OUT        = 0x0100;
    public final static int BIT_X2_LIMIT_IN         = 0x0200;
    public final static int BIT_X11_ZERO            = 0x0400;
    public final static int BIT_X11_LIMIT_LEFT      = 0x0800;
    public final static int BIT_X11_LIMIT_RIGHT     = 0x1000;
    public final static int BIT_X12_ZERO            = 0x2000;
    public final static int BIT_X12_LIMIT_LEFT      = 0x4000;
    public final static int BIT_X12_LIMIT_RIGHT     = 0x8000;
    //For VR104
    public final static int BIT_X2_ZERO             = 0x0001;
    public final static int BIT_Y2_ZERO             = 0x0002;
    public final static int BIT_SERVO_ERROR         = 0x0004;
//    public final static int BIT_ = 0x0008;
//    public final static int BIT_ = 0x0010;
//    public final static int BIT_ = 0x0020;
//    public final static int BIT_ = 0x0040;
//    public final static int BIT_ = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    
    //For VR105 Trio-output
    public final static int BIT_PLC_TIMER_START     = 0x0001;
    public final static int BIT_CURE_READY          = 0x0002;
    public final static int BIT_CURE_STATE          = 0x0004; //wys?.name is TBD
    public final static int BIT_TRIO_ERROR          = 0x0008;
    public final static int BIT_BEAM_OUT            = 0x0010;
    public final static int BIT_BEAM_CLOSE          = 0x0020;
    public final static int BIT_BEAM_ALTERING       = 0x0040;
    public final static int BIT_PHOTO_INDICATE      = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    
    //For VR106 Trio-output
    public final static int BIT_OVERALL_ERR         = 0x0001; //wys?.name TBD
    public final static int BIT_LIGHT_1             = 0x0002;
    public final static int BIT_LIGHT_2             = 0x0004;
    public final static int BIT_LIGHT_3             = 0x0008;
//    public final static int BIT_ = 0x0010;
//    public final static int BIT_ = 0x0020;
//    public final static int BIT_ = 0x0040;
//    public final static int BIT_ = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR107
    public final static int BIT_OPEN_SOURCE_TIMER_START = 0x0001;
    public final static int BIT_BUSY_Z              = 0x0002;
    public final static int BIT_BUSY_T              = 0x0004;
//    public final static int BIT_ = 0x0008;
//    public final static int BIT_ = 0x0010;
//    public final static int BIT_ = 0x0020;
//    public final static int BIT_ = 0x0040;
//    public final static int BIT_ = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR108
    public final static int BIT_ERR_1             = 0x0001;
    public final static int BIT_ERR_2             = 0x0002;
    public final static int BIT_ERR_3             = 0x0004;
    public final static int BIT_ERR_4             = 0x0008;
    public final static int BIT_ERR_5             = 0x0010;
    public final static int BIT_ERR_6             = 0x0020;
    public final static int BIT_ERR_7             = 0x0040;
    public final static int BIT_ERR_8             = 0x0080;
    public final static int BIT_FQ_1                = 0x0100;
    public final static int BIT_FQ_2                = 0x0200;
    public final static int BIT_FQ_3                = 0x0400;
    public final static int BIT_FQ_4                = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR109
    public final static int BIT_ROOM_GAGE_OPEN      = 0x0001;
//    public final static int BIT_ = 0x0002;
//    public final static int BIT_ = 0x0004;
//    public final static int BIT_ = 0x0008;
//    public final static int BIT_ = 0x0010;
//    public final static int BIT_ = 0x0020;
    public final static int BIT_BUSY_T_             = 0x0040;
    public final static int BIT_BUSY_Z_             = 0x0080;
    public final static int BIT_FQ_5                = 0x0100;
    public final static int BIT_FQ_6                = 0x0200;
    public final static int BIT_FQ_7                = 0x0400;
    public final static int BIT_FQ_8                = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR158
    public final static int BIT_IN_START_Z          = 0x0001;
    public final static int BIT_IN_ABORT_Z          = 0x0002;
    public final static int BIT_IN_START_T          = 0x0004;
    public final static int BIT_IN_ABORT_T          = 0x0008;
//    public final static int BIT_ = 0x0010;
//    public final static int BIT_ = 0x0020;
//    public final static int BIT_ = 0x0040;
//    public final static int BIT_ = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR159
    public final static int BIT_RST_1               = 0x0001;
    public final static int BIT_RST_2               = 0x0002;
    public final static int BIT_RST_3               = 0x0004;
    public final static int BIT_RST_4               = 0x0008;
    public final static int BIT_RST_5               = 0x0010;
    public final static int BIT_RST_6               = 0x0020;
    public final static int BIT_RST_7               = 0x0040;
    public final static int BIT_RST_8               = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR160
    public final static int BIT_SAFE_LOCKS_OUT      = 0x0001;
    public final static int BIT_PLC_CLOSE_SOURCE_OUT = 0x0002;
    public final static int BIT_POWER_OFF_PERMIT    = 0x0004;
    public final static int BIT_BRAKE_POWER_ON      = 0x0008;
    public final static int BIT_SERVO_ERROR_OUT     = 0x0010;
    public final static int BIT_PLC_DO_CLOSE_SOURCE = 0x0020;
    public final static int BIT_TRIO_POWER_DELAY    = 0x0040;
//    public final static int BIT_ = 0x0080;
//    public final static int BIT_ = 0x0100;
//    public final static int BIT_ = 0x0200;
//    public final static int BIT_ = 0x0400;
//    public final static int BIT_ = 0x0800;
//    public final static int BIT_ = 0x1000;
//    public final static int BIT_ = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
    //For VR120
    public final static int BIT_SIMULATE_SELECTED   = 0x0001;
    public final static int BIT_SIMULATE_START      = 0x0002;
    public final static int BIT_X11_MOVE_LEFT       = 0x0004;
    public final static int BIT_X11_MOVE_RIGHT      = 0x0008;
    public final static int BIT_Y11_MOVE_UP         = 0x0010;
    public final static int BIT_Y11_MOVE_DOWN       = 0x0020;
    public final static int BIT_Z11_MOVE_IN         = 0x0040;
    public final static int BIT_Z11_MOVE_OUT        = 0x0080;
    public final static int BIT_X2_MOVE_OUT         = 0x0100;
    public final static int BIT_X2_MOVE_IN          = 0x0200;
    public final static int BIT_X12_MOVE_LEFT       = 0x0400;
    public final static int BIT_X12_MOVE_RIGHT      = 0x0800;
    public final static int BIT_Y2_OPEN             = 0x1000;
    public final static int BIT_Y2_CLOSE            = 0x2000;
//    public final static int BIT_ = 0x4000;
//    public final static int BIT_ = 0x8000;
            
    public final static short ADDR_WYS_TBD         = 809;
    public final static int   VALUE_WYS_TBD        = 0;
    
    public final static short TABLE_COMPENSATE_X2  = 1000;
    public final static short TABLE_COMPENSATE_X2i = 840;
    public final static short TABLE_COMPENSATE_X11 = 2000;
    public final static short TABLE_COMPENSATE_X11i= 845;
    public final static short TABLE_COMPENSATE_Y11 = 2500;
    public final static short TABLE_COMPENSATE_Y11i= 848;
    
    public final static int RESULT_INVALID         = 0;
    public final static int RESULT_NO              = 0;
    public final static int RESULT_YES             = 1;
    public final static int RESULT_NULL            = 2;
    public final static int AUTO_CHECK_REQUEST     = 1;
    public final static int AUTO_CHECK_ING         = 22;
    public final static int AUTO_CHECK_ERROR       = 44;
    
    public static String SERVER_ADDS="192.168.0.250";
    public static int SERVER_PORT=502;
    public static String OFF_CODE = "0000";
    public static String OFF_TEXT = "EXIT";
    public static enum MODE {INPUT,QUEUE};//终端命令行模式,队列模式
    public static int QUEUE_SIZE=10;
    
    public static String APP_NAME="TRIOPC.TrioPCCtrl.1";
    public static String APP_HOSTADDR =  "HostAddress";
    public static int APP_PORTPYTE =  2; //wys.change name to APP_PORTTYPE
    public static int APP_PORTMODE =  0;
    public static String APP_METHOD_OPEN =  "Open";
    public static String APP_METHOD_ISOPEN = "IsOpen";
    public static String APP_METHOD_GETVR =  "GetVR";
    public static String APP_METHOD_SETVR =  "SetVR";
    public static String APP_METHOD_GETTABLE =  "GetTable";
    public static String APP_METHOD_SETTABLE =  "SetTable";
    
    
    //换源
    public static String CAT_DEVICEPARAM_TYPE_SOURCE_NAME="renewal_source";
    public static String CAT_DEVICEPARAM_TYPE_SOURCE_OFFSET="source_compensate";
    
    public static boolean DEBUG_this_is_TouDao = false;
}
