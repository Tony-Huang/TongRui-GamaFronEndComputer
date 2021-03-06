/* 基本种子数据 */
/* 作者：王永社,  Date: 2012-8-10,  RNo. =  */

USE [ShangWeiJi]
GO
/* CAT_ACC_Role and User */
--因为有外键关联，所以要先执行第一条语句
DELETE FROM ShangWeiJi.dbo.CAT_ACC_User
DELETE FROM ShangWeiJi.dbo.CAT_ACC_Role
GO
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_ACC_User',reseed,0)
GO
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_Role] (ID,RoleName,Description) VALUES (1,'Engineer','Full Right')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_Role] (ID,RoleName,Description) VALUES (2,'Manager', 'Manage Right')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_Role] (ID,RoleName,Description) VALUES (3,'Operator','Cure Right')
GO
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('AW','AW',1,'True')
GO

/* CAT_SYSTEM_LogLevel*/
DELETE FROM ShangWeiJi.dbo.CAT_SYSTEM_Log
DELETE FROM ShangWeiJi.dbo.CAT_SYSTEM_LogLevel
GO
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_SYSTEM_Log',reseed,0)
go
insert into [ShangWeiJi].[dbo].[CAT_SYSTEM_LogLevel] (ID,Name,Description) values (1,'Event','Common Recorder')
insert into [ShangWeiJi].[dbo].[CAT_SYSTEM_LogLevel] (ID,Name,Description) values (2,'ErrorAndWarning','Error Recorder')
go

/* CAT_DEVICEPARAM_Type */
DELETE FROM ShangWeiJi.dbo.CAT_DEVICEPARAM_ValueHistory
DELETE FROM ShangWeiJi.dbo.CAT_DEVICEPARAM_Value
DELETE FROM ShangWeiJi.dbo.CAT_DEVICEPARAM_Type
go
dbcc checkident ('ShangWeiJi.dbo.CAT_DEVICEPARAM_Value',reseed,0)
dbcc checkident ('ShangWeiJi.dbo.CAT_DEVICEPARAM_ValueHistory',reseed,0)
go
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (1,'up_bed_position')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (2,'down_bed_position')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (3,'alter_focus_position')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (4,'reference_position')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (5,'reference_adjust')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (6,'radiate_compensate')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (7,'zero_position')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (8,'manu_speed')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (9,'auto_speed')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (10,'screw_compensate')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (11,'renewal_source')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (12,'source_compensate')
insert into [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Type] (ID,Name) values (13,'axiles_range')
go

/* CAT_DEVICEPARAM_Value */
DELETE FROM ShangWeiJi.dbo.CAT_DEVICEPARAM_ValueHistory
DELETE FROM ShangWeiJi.dbo.CAT_DEVICEPARAM_Value
go
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_DEVICEPARAM_Value',reseed,0)
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_DEVICEPARAM_ValueHistory',reseed,0)
go
                                                                                                                      /* up_bed_position */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (1,'Y11',-11,-59,59,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (1,'Z11',-225,-250,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (1,'X2',   0,-1025,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (1,'Y2',  90,0,95,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                     /* down_bed_position */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (2,'Y11',-11,-59,59,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (2,'Z11',-225,-250,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (2,'X2',   0,-1025,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (2,'Y2',  90,0,95,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                  /* alter_focus_position */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (3,'Y11',-11,-59,59,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (3,'Z11',-120,-250,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (3,'X2',   0,-1025,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (3,'Y2',  90,0,95,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                    /* reference_position */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (4,'Y11',0,-59,59,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (4,'Z11',0,-250,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (4,'X2', 0,-1025,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                      /* reference_adjust */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (5,'Y11',0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (5,'Z11',0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (5,'X2', 0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                    /* radiate_compensate */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (6,'1#',0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (6,'2#',0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (6,'3#',0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (6,'4#',0,-5,5,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                         /* zero_position */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'X11',0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'Y11',0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'Z11',0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'X12',0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'X2', 0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'Y2', 0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'Z2', 0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (7,'T2', 0,-30,30,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                            /* manu_speed */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'X11',20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'Y11',20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'Z11',20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'X12',20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'X2', 20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'Y2', 20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'Z2', 20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (8,'T2', 20,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                            /* auto_speed */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'X11',30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'Y11',30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'Z11',30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'X12',30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'X2', 30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'Y2', 30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'Z2', 30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (9,'T2', 30,10,50,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                                      /* source_compensate */
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Value,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (12,'T2Z2',3,0,10,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')

                                                                                                             /* axiles_range (TouDao)*/
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (13,'X11',-59,59,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (13,'Y11',-59,59,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (13,'Z11',-250,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (13,'X12',-40,40,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (13,'X2' ,-1025,0,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
INSERT INTO [ShangWeiJi].[dbo].[CAT_DEVICEPARAM_Value] (ParamType,Name,Lowlimit,Uplimit,Used,CreatedOn,CreatedBy,ModifiedOn,ModifiedBy)  VALUES  (13,'Y2' ,0,95,'True','2012-5-1 14:01','出厂值','2012-5-1 14:01','出厂值')
go

/* CAT_TREATMENT_ State and CollType */
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_PlanFocus
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_CollType
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_PlanFraction
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_FractionState
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_Plan
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_PlanState
DELETE FROM ShangWeiJi.dbo.CAT_TREATMENT_PatientCase
go
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_TREATMENT_PatientCase',reseed,0)
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_TREATMENT_Plan',reseed,0)
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_TREATMENT_PlanFraction',reseed,0)
DBCC CHECKIDENT ('ShangWeiJi.dbo.CAT_TREATMENT_PlanFocus',reseed,0)
go

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanState] (ID,StateName, Description)  VALUES  (1,'CONFIRMED',		'CONFIRMED')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanState] (ID,StateName, Description)  VALUES  (2,'ONTREAT',		    'ONTREAT')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanState] (ID,StateName, Description)  VALUES  (3,'TREATFINISHED',	'TREATFINISHED')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanState] (ID,StateName, Description)  VALUES  (4,'TREATCHANGED',	'TREATCHANGED')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanState] (ID,StateName, Description)  VALUES  (5,'计划已通过模拟',	'Description2')

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_FractionState] (ID,StateName, Description)  VALUES  (1,'UNCARRIED',   'UNCARRIED')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_FractionState] (ID,StateName, Description)  VALUES  (2,'SUCCESS',		'SUCCESS')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_FractionState] (ID,StateName, Description)  VALUES  (3,'ABORT',		'ABORT')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_FractionState] (ID,StateName, Description)  VALUES  (4,'ABORT',		'ABORT')

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_CollType] (ID,Size, Outfactor)  VALUES  (1,10, 0.1)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_CollType] (ID,Size, Outfactor)  VALUES  (2,20, 0.2)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_CollType] (ID,Size, Outfactor)  VALUES  (3,30, 0.3)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_CollType] (ID,Size, Outfactor)  VALUES  (4,40, 0.4)
