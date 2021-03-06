USE [master]
GO
/****** 对象:  Database [PoolBD]    脚本日期: 03/08/2013 09:52:23 ******/
CREATE DATABASE [PoolBD] ON  PRIMARY 
( NAME = N'PoolBD', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\PoolBD.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PoolBD_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\PoolBD_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 COLLATE Chinese_PRC_CI_AS
GO
EXEC dbo.sp_dbcmptlevel @dbname=N'PoolBD', @new_cmptlevel=90
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PoolBD].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PoolBD] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PoolBD] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PoolBD] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PoolBD] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PoolBD] SET ARITHABORT OFF 
GO
ALTER DATABASE [PoolBD] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PoolBD] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [PoolBD] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PoolBD] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PoolBD] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PoolBD] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PoolBD] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PoolBD] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PoolBD] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PoolBD] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PoolBD] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PoolBD] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PoolBD] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PoolBD] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PoolBD] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PoolBD] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PoolBD] SET  READ_WRITE 
GO
ALTER DATABASE [PoolBD] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PoolBD] SET  MULTI_USER 
GO
ALTER DATABASE [PoolBD] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PoolBD] SET DB_CHAINING OFF 

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_PatientCase]    脚本日期: 03/08/2013 09:57:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_PatientCase](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) PoolBDNULL,
	[PatientID] [nvarchar](100) PoolBDNOT NULL,
	[Sex] [bit] NULL,
	[Age] [int] NULL,
	[Height] [int] NULL,
	[Weight] [int] NULL,
	[BirthDay] [datetime] NULL,
	[Address] [nvarchar](200) PoolBDNULL,
	[Phone] [nvarchar](50) PoolBDNULL,
	[Notes] [nvarchar](max) PoolBDNULL,
	[isUpdateByServer] [bit] NOT NULL,
 CONSTRAINT [PK_CAT_TREATMENT_PatientCase] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UniquePatientId] UNIQUE NONCLUSTERED 
(
	[PatientID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_FractionState]    脚本日期: 03/08/2013 09:57:23 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_FractionState](
	[ID] [int] NOT NULL,
	[StateName] [nvarchar](50) PoolBDNULL,
	[Description] [nvarchar](200) PoolBDNULL,
	[isUpdateByServer] [bit] NOT NULL,
 CONSTRAINT [PK_CAT_TREATMENT_FractionState] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanState]    脚本日期: 03/08/2013 09:57:44 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_PlanState](
	[ID] [int] NOT NULL,
	[StateName] [nvarchar](50) PoolBDNOT NULL,
	[Description] [nvarchar](200) PoolBDNULL,
	[isUpdateByServer] [bit] NOT NULL,
 CONSTRAINT [PK_CAT_TREATMENT_PlanState] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanFraction]    脚本日期: 03/08/2013 09:58:49 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_PlanFraction](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[PatientCaseID] [int] NULL,
	[PlanID] [int] NULL,
	[FractionNomber] [int] NULL,
	[DueDate] [datetime] NULL,
	[State] [int] NULL,
	[IsAppended] [bit] NULL,
	[AppendDoctorName] [nvarchar](50) PoolBDNULL,
	[PerformerName] [nvarchar](50) PoolBDNULL,
	[Notes] [nvarchar](max) PoolBDNULL,
	[IsIGRTFlag] [bit] NULL,
	[IGRTdx] [real] NULL,
	[IGRTdy] [real] NULL,
	[IGRTdz] [real] NULL,
	[photoNumber] [int] NULL,
	[ImagePath] [nvarchar](100) PoolBDNULL,
	[Register] [nvarchar](100) PoolBDNULL,
	[isUpdateByServer] [bit] NOT NULL,
	[isUpdateByUpper] [nchar](10) PoolBDNULL,
 CONSTRAINT [PK_CAT_TREATMENT_PlanFraction] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_Plan]    脚本日期: 03/08/2013 10:00:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_Plan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CourseNumber] [int] NULL,
	[PatientCaseID] [int] NULL,
	[PlanName] [nvarchar](50) PoolBDNULL,
	[Diaglose] [nvarchar](200) PoolBDNULL,
	[TreatmentPart] [nvarchar](100) PoolBDNULL,
	[FocusCount] [int] NULL,
	[fractionCount] [int] NULL,
	[Dose] [real] NULL,
	[Referper] [real] NULL,
	[DoctorName] [nvarchar](50) PoolBDNULL,
	[PlanDate] [datetime] NULL,
	[PlanLockDate] [datetime] NULL,
	[SerialNumber] [int] NULL,
	[ApprovalDoctorName] [nvarchar](50) PoolBDNULL,
	[ApprovalDate] [datetime] NULL,
	[State] [int] NULL,
	[isUpdateByServer] [bit] NOT NULL,
	[isUpdateByUpper] [bit] NULL,
 CONSTRAINT [PK_CAT_TREATMENT_Plan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanFocus]    脚本日期: 03/08/2013 10:01:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_PlanFocus](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FractionID] [int] NULL,
	[FocusNumber] [int] NULL,
	[enabled] [tinyint] NULL,
	[FocusStartTime] [datetime] NULL,
	[FocusEndTime] [datetime] NULL,
	[PlanX] [real] NULL,
	[PlanY] [real] NULL,
	[PlanZ] [real] NULL,
	[CouchX] [real] NULL,
	[CouchY] [real] NULL,
	[CouchZ] [real] NULL,
	[CollType] [int] NULL,
	[PlanCurePeriod] [real] NULL,
	[CurePeriod] [real] NULL,
	[isUpdateByServer] [bit] NOT NULL,
	[isUpdateByUpper] [bit] NULL,
 CONSTRAINT [PK_CAT_TREATMENT_PlanFocus] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

USE [PoolBD]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_CollType]    脚本日期: 03/08/2013 10:02:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_CollType](
	[ID] [int] NOT NULL,
	[Size] [float] NULL,
	[Outfactor] [float] NULL,
	[isUpdateByServer] [bit] NOT NULL,
 CONSTRAINT [PK_CAT_TREATMENT_CollType] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UniqueSize] UNIQUE NONCLUSTERED 
(
	[Size] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]


GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_CollType] FOREIGN KEY([CollType])
REFERENCES [dbo].[CAT_TREATMENT_CollType] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_CollType]
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_PlanFraction] FOREIGN KEY([FractionID])
REFERENCES [dbo].[CAT_TREATMENT_PlanFraction] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_PlanFraction]


GO
ALTER TABLE [dbo].[CAT_TREATMENT_Plan]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PatientCase] FOREIGN KEY([PatientCaseID])
REFERENCES [dbo].[CAT_TREATMENT_PatientCase] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_Plan] CHECK CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PatientCase]
GO
ALTER TABLE [dbo].[CAT_TREATMENT_Plan]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PlanState] FOREIGN KEY([State])
REFERENCES [dbo].[CAT_TREATMENT_PlanState] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_Plan] CHECK CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PlanState]

GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_FractionState] FOREIGN KEY([State])
REFERENCES [dbo].[CAT_TREATMENT_FractionState] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_FractionState]
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_PatientCase] FOREIGN KEY([PatientCaseID])
REFERENCES [dbo].[CAT_TREATMENT_PatientCase] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_PatientCase]
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_Plan] FOREIGN KEY([PlanID])
REFERENCES [dbo].[CAT_TREATMENT_Plan] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_Plan]

