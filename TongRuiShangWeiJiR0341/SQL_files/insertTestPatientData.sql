/*作者：王永社,  Date: 2012-9-20,  RNo. = 36 */

INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('Eng1','111111',1,'True')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('Eng2','111111',1,'True')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('Man1','111111',2,'True')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('Man2','111111',2,'True')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('Ope1','111111',3,'True')
INSERT INTO [ShangWeiJi].[dbo].[CAT_ACC_User] (UserName,Password,Role,Active) VALUES ('Ope2','111111',3,'True')
GO

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PatientCase] 
  (Name,       PatientID, Sex,    Age, Height, Weight, BirthDay,  Address, Phone,   Notes)  VALUES  
  ('LiLizhen1','111111', 'false', 50,  168,    65,    '1960-5-1', '西安XX', '12345', 'This is note')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PatientCase] 
  (Name,       PatientID, Sex,    Age, Height, Weight, BirthDay,  Address, Phone,   Notes)  VALUES  
  ('LiLizhen1','111112', 'false', 49,  168,    65,    '1961-5-1', '西安XX', '12345', 'This is note')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PatientCase] 
  (Name,       PatientID, Sex,    Age, Height, Weight, BirthDay,  Address, Phone,   Notes)  VALUES  
  ('LiLizhen1','111113', 'false', 48,  168,    65,    '1962-5-1', '西安XX', '12345', 'This is note')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PatientCase] 
  (Name,       PatientID, Sex,    Age, Height, Weight, BirthDay,  Address, Phone,   Notes)  VALUES  
  ('LiLizhen1','111114', 'false', 47,  168,    65,    '1963-5-1', '西安XX', '12345', 'This is note')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PatientCase] 
  (Name,       PatientID, Sex,    Age, Height, Weight, BirthDay,  Address, Phone,   Notes)  VALUES  
  ('LiLizhen1','111115', 'false', 46,  168,    65,    '1964-5-1', '西安XX', '12345', 'This is note')
go
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_Plan]
  (CourseNumber,PatientCaseID,PlanName,Diaglose, TreatmentPart,FocusCount,fractionCount,Dose,Referper,DoctorName,PlanDate, SerialNumber,State)  VALUES
  (1,			 1,			  'p_name','diagnose','head',			4,	    2,			3000,	2500, 'Hu',		 '2012-5-1',222221,     5)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_Plan]
  (CourseNumber,PatientCaseID,PlanName,Diaglose, TreatmentPart,FocusCount,fractionCount,Dose,Referper,DoctorName,PlanDate, SerialNumber,State)  VALUES
  (1,			 2,			  'p_name','diagnose','head',			4,	    2,			3000,	2500, 'Hu',		 '2012-5-2',222222,     4)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_Plan]
  (CourseNumber,PatientCaseID,PlanName,Diaglose, TreatmentPart,FocusCount,fractionCount,Dose,Referper,DoctorName,PlanDate, SerialNumber,State)  VALUES
  (1,			 3,			  'p_name','diagnose','head',			4,	    2,			3000,	2500, 'Hu',		 '2012-5-3',222223,     3)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_Plan]
  (CourseNumber,PatientCaseID,PlanName,Diaglose, TreatmentPart,FocusCount,fractionCount,Dose,Referper,DoctorName,PlanDate, SerialNumber,State)  VALUES
  (1,			 4,			  'p_name','diagnose','head',			4,	    2,			3000,	2500, 'Hu',		 '2012-5-4',222224,     2)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_Plan]
  (CourseNumber,PatientCaseID,PlanName,Diaglose, TreatmentPart,FocusCount,fractionCount,Dose,Referper,DoctorName,PlanDate, SerialNumber,State)  VALUES
  (1,			 5,			  'p_name','diagnose','head',			4,	    2,			3000,	2500, 'Hu',		 '2012-5-5',222225,     1)
go
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (1,				1,		1,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (2,				2,		1,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (3,				3,		1,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (4,				4,		1,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (5,				5,		1,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (1,				1,		2,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (2,				2,		2,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (3,				3,		2,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (4,				4,		2,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFraction]
  (PatientCaseID,PlanID,FractionNomber,DueDate,IsAppended,AppendDoctorName,PerformerName,Notes,State,IsIGRTFlag)  VALUES
  (5,				5,		2,		   '2012-5-8','false', 'no name',		'zhou',      'note2',1,   'false')
go
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (1,         1,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',10.1,  20.1, 30.1, 10.2,  20.2,  30.2,  1,       400,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (1,         2,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',20.1,  20.1, 30.1, 10.2,  20.2,  30.2,  2,       401,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (1,         3,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',30.1,  20.1, 30.1, 10.2,  20.2,  30.2,  3,       402,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (1,         4,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',40.1,  20.1, 30.1, 10.2,  20.2,  30.2,  1,       403,				60)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (2,         1,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',10.1,  20.1, 30.1, 10.2,  22.2,  30.2,  1,       400,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (2,         2,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',20.1,  20.1, 30.1, 10.2,  22.2,  30.2,  1,       401,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (2,         3,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',30.1,  20.1, 30.1, 10.2,  22.2,  30.2,  1,       402,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (2,         4,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',40.1,  20.1, 30.1, 10.2,  22.2,  30.2,  1,       403,				60)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (3,         1,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',10.1,  20.1, 30.1, 10.2,  23.2,  30.2,  1,       400,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (3,         2,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',20.1,  20.1, 30.1, 10.2,  23.2,  30.2,  1,       401,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (3,         3,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',30.1,  20.1, 30.1, 10.2,  23.2,  30.2,  1,       402,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (3,         4,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',40.1,  20.1, 30.1, 10.2,  23.2,  30.2,  1,       403,				60)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (4,         1,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',10.1,  20.1, 30.1, 10.2,  24.2,  30.2,  1,       400,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (4,         2,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',20.1,  20.1, 30.1, 10.2,  24.2,  30.2,  1,       401,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (4,         3,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',30.1,  20.1, 30.1, 10.2,  24.2,  30.2,  1,       402,				60)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,     FocusEndTime,       PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (4,         4,           1,     '2012-5-8 13:59:30','2012-5-8 14:00:30',40.1,  20.1, 30.1, 10.2,  24.2,  30.2,  1,       403,				60)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (5,         1,           1,     null,          null,        10.1,  20.1, 30.1, 10.2,  25.2,  30.2,  1,       400,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (5,         2,           1,     null,          null,        20.1,  20.1, 30.1, 10.2,  25.2,  30.2,  1,       401,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (5,         3,           1,     null,          null,        30.1,  20.1, 30.1, 10.2,  25.2,  30.2,  1,       402,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (5,         4,           1,     null,          null,        40.1,  20.1, 30.1, 10.2,  25.2,  30.2,  1,       403,				null)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (6,         1,           1,     null,          null,        10.1,  20.1, 30.1, 10.2,  26.2,  30.2,  1,       400,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (6,         2,           1,     null,          null,        20.1,  20.1, 30.1, 10.2,  26.2,  30.2,  1,       401,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (6,         3,           1,     null,          null,        30.1,  20.1, 30.1, 10.2,  26.2,  30.2,  1,       402,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (6,         4,           1,     null,          null,        40.1,  20.1, 30.1, 10.2,  26.2,  30.2,  1,       403,				null)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (7,         1,           1,     null,          null,        10.1,  20.1, 30.1, 10.2,  27.2,  30.2,  1,       400,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (7,         2,           1,     null,          null,        20.1,  20.1, 30.1, 10.2,  27.2,  30.2,  1,       401,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (7,         3,           1,     null,          null,        30.1,  20.1, 30.1, 10.2,  27.2,  30.2,  1,       402,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (7,         4,           1,     null,          null,        40.1,  20.1, 30.1, 10.2,  27.2,  30.2,  1,       403,				null)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (8,         1,           1,     null,          null,        10.1,  20.1, 30.1, 10.2,  28.2,  30.2,  1,       400,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (8,         2,           1,     null,          null,        20.1,  20.1, 30.1, 10.2,  28.2,  30.2,  1,       401,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (8,         3,           1,     null,          null,        30.1,  20.1, 30.1, 10.2,  28.2,  30.2,  1,       402,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (8,         4,           1,     null,          null,        40.1,  20.1, 30.1, 10.2,  28.2,  30.2,  1,       403,				null)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (9,         1,           1,     null,          null,        10.1,  20.1, 30.1, 10.2,  29.2,  30.2,  1,       400,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (9,         2,           1,     null,          null,        20.1,  20.1, 30.1, 10.2,  29.2,  30.2,  1,       401,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (9,         3,           1,     null,          null,        30.1,  20.1, 30.1, 10.2,  29.2,  30.2,  1,       402,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (9,         4,           1,     null,          null,        40.1,  20.1, 30.1, 10.2,  29.2,  30.2,  1,       403,				null)

INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (10,        1,           1,     null,          null,        10.1,  20.1, 30.1, 10.2,  20.2,  31.2,  1,       400,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (10,        2,           1,     null,          null,        20.1,  20.1, 30.1, 10.2,  20.2,  31.2,  1,       401,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (10,        3,           1,     null,          null,        30.1,  20.1, 30.1, 10.2,  20.2,  31.2,  1,       402,				null)
INSERT INTO [ShangWeiJi].[dbo].[CAT_TREATMENT_PlanFocus]
  (FractionID,FocusNumber,enabled,FocusStartTime,FocusEndTime,PlanX,PlanY,PlanZ,CouchX,CouchY,CouchZ,CollType,PlanCurePeriod,CurePeriod)  VALUES
  (10,        4,           1,     null,          null,        40.1,  20.1, 30.1, 10.2,  20.2,  31.2,  1,       403,				null)
