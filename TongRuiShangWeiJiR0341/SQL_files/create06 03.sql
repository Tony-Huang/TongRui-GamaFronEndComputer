/* 1.创建数据库PoolBD */
/* 2.增用户UpperComputer */
/* 3.建表 */
/* 4.外键关联 */

USE [master]
GO
/****** 对象:  Database [PoolBD]    脚本日期: 07/16/2012 21:12:56 ******/
IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = N'PoolBD')
BEGIN
CREATE DATABASE [PoolBD] ON  PRIMARY 
( NAME = N'PoolBD', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\PoolBD.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PoolBD_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\PoolBD_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
END

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
GO
/*GRANT CONNECT TO [UpperComputer] by wys*/
/****** 对象:  Login [UpperComputer]    脚本日期: 07/16/2012 21:12:59 ******/
/* For security reasons the login is created disabled and with a random password. */
/****** 对象:  Login [UpperComputer]    脚本日期: 07/16/2012 21:12:59 ******/
IF NOT EXISTS (SELECT * FROM sys.server_principals WHERE name = N'UpperComputer')
CREATE LOGIN [UpperComputer] WITH PASSWORD=N'UpperComputer', DEFAULT_DATABASE=[PoolBD], DEFAULT_LANGUAGE=[简体中文], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
EXEC sys.sp_addsrvrolemember @loginame = N'UpperComputer', @rolename = N'dbcreator'
GO
ALTER LOGIN [UpperComputer] DISABLE
GO
USE [PoolBD]
GO
/****** 对象:  User [UpperComputer]    脚本日期: 07/16/2012 21:12:59 ******/
GO
IF NOT EXISTS (SELECT * FROM sys.database_principals WHERE name = N'UpperComputer')
CREATE USER [UpperComputer] FOR LOGIN [UpperComputer] WITH DEFAULT_SCHEMA=[dbo]
GO

/****** 对象:  Table [dbo].[CAT_TREATMENT_PatientCase]    脚本日期: 07/16/2012 21:12:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PatientCase]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CAT_TREATMENT_PatientCase](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[PatientID] [nvarchar](100) NOT NULL,
	[Sex] [bit] NULL,
	[Age] [int] NULL,
	[Height] [int] NULL,
	[Weight] [int] NULL,
	[BirthDay] [datetime] NULL,
	[Address] [nvarchar](200) NULL,
	[Phone] [nvarchar](50) NULL,
	[Notes] [nvarchar](max) NULL,
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
END
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_FractionState]    脚本日期: 07/16/2012 21:12:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_FractionState]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CAT_TREATMENT_FractionState](
	[ID] [int] NOT NULL,
	[StateName] [nvarchar](50) NULL,
	[Description] [nvarchar](200) NULL,
	[isUpdateByServer] [bit] NOT NULL,
 CONSTRAINT [PK_CAT_TREATMENT_FractionState] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanState]    脚本日期: 07/16/2012 21:12:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanState]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CAT_TREATMENT_PlanState](
	[ID] [int] NOT NULL,
	[StateName] [nvarchar](50) NOT NULL,
	[Description] [nvarchar](200) NULL,
	[isUpdateByServer] [bit] NOT NULL,
 CONSTRAINT [PK_CAT_TREATMENT_PlanState] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO

/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanFraction]    脚本日期: 07/16/2012 21:12:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFraction]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CAT_TREATMENT_PlanFraction](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[PatientCaseID] [int] NULL,
	[PlanID] [int] NULL,
	[FractionNomber] [int] NULL,
	[DueDate] [datetime] NULL,
	[State] [int] NULL,
	[IsAppended] [bit] NULL,
	[AppendDoctorName] [nvarchar](50) NULL,
	[PerformerName] [nvarchar](50) NULL,
	[Notes] [nvarchar](max) NULL,
	[IsIGRTFlag] [bit] NULL,
	[IGRTdx] [real] NULL,
	[IGRTdy] [real] NULL,
	[IGRTdz] [real] NULL,
	[photoNumber] [int] NULL,
	[ImagePath] [nvarchar](100) NULL,
	[Register] [nvarchar](100) NULL,
	[isUpdateByServer] [bit] NOT NULL,
	[isUpdateByUpper] [nchar](10) NULL,
 CONSTRAINT [PK_CAT_TREATMENT_PlanFraction] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO

/****** 对象:  Table [dbo].[CAT_TREATMENT_Plan]    脚本日期: 07/16/2012 21:12:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_Plan]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CAT_TREATMENT_Plan](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CourseNumber] [int] NULL,
	[PatientCaseID] [int] NULL,
	[PlanName] [nvarchar](50) NULL,
	[Diaglose] [nvarchar](200) NULL,
	[TreatmentPart] [nvarchar](100) NULL,
	[FocusCount] [int] NULL,
	[fractionCount] [int] NULL,
	[Dose] [real] NULL,
	[Referper] [real] NULL,
	[DoctorName] [nvarchar](50) NULL,
	[PlanDate] [datetime] NULL,
	[PlanLockDate] [datetime] NULL,
	[SerialNumber] [int] NULL,
	[ApprovalDoctorName] [nvarchar](50) NULL,
	[ApprovalDate] [datetime] NULL,
	[State] [int] NULL,
	[isUpdateByServer] [bit] NOT NULL,
	[isUpdateByUpper] [bit] NULL,
 CONSTRAINT [PK_CAT_TREATMENT_Plan] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]/*,
 CONSTRAINT [UniqueSerialNumber] UNIQUE NONCLUSTERED 
(
	[SerialNumber] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY] */
) ON [PRIMARY]
END
GO

/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanFocus]    脚本日期: 07/16/2012 21:12:59 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFocus]') AND type in (N'U'))
BEGIN
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
END
GO

/****** 对象:  Table [dbo].[CAT_TREATMENT_CollType]    脚本日期: 08/28/2012 09:53:56 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_CollType]') AND type in (N'U'))
BEGIN
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
END
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_FractionState]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFraction]'))
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_FractionState] FOREIGN KEY([State])
REFERENCES [dbo].[CAT_TREATMENT_FractionState] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_FractionState]
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_PatientCase]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFraction]'))
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_PatientCase] FOREIGN KEY([PatientCaseID])
REFERENCES [dbo].[CAT_TREATMENT_PatientCase] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_PatientCase]
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_Plan]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFraction]'))
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_Plan] FOREIGN KEY([PlanID])
REFERENCES [dbo].[CAT_TREATMENT_Plan] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFraction] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFraction_CAT_TREATMENT_Plan]
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PatientCase]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_Plan]'))
ALTER TABLE [dbo].[CAT_TREATMENT_Plan]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PatientCase] FOREIGN KEY([PatientCaseID])
REFERENCES [dbo].[CAT_TREATMENT_PatientCase] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_Plan] CHECK CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PatientCase]
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PlanState]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_Plan]'))
ALTER TABLE [dbo].[CAT_TREATMENT_Plan]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PlanState] FOREIGN KEY([State])
REFERENCES [dbo].[CAT_TREATMENT_PlanState] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_Plan] CHECK CONSTRAINT [FK_CAT_TREATMENT_Plan_CAT_TREATMENT_PlanState]
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_CollType]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFocus]'))
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_CollType] FOREIGN KEY([CollType])
REFERENCES [dbo].[CAT_TREATMENT_CollType] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_CollType]
GO

IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_PlanFraction]') AND parent_object_id = OBJECT_ID(N'[dbo].[CAT_TREATMENT_PlanFocus]'))
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus]  WITH CHECK ADD  CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_PlanFraction] FOREIGN KEY([FractionID])
REFERENCES [dbo].[CAT_TREATMENT_PlanFraction] ([ID])
GO
ALTER TABLE [dbo].[CAT_TREATMENT_PlanFocus] CHECK CONSTRAINT [FK_CAT_TREATMENT_PlanFocus_CAT_TREATMENT_PlanFraction]
