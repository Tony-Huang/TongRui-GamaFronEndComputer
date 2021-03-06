USE [ShangWeiJi]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_CollType]    脚本日期: 08/28/2012 12:06:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_CollType](
	[ID] [int] NOT NULL,
	[Size] [float] NULL,
	[Outfactor] [float] NULL,
 CONSTRAINT [PK_CAT_TREATMENT_CollType] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UniqueSize] UNIQUE NONCLUSTERED 
(
	[Size] ASC
)WITH (PAD_INDEX  = OFF, IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
