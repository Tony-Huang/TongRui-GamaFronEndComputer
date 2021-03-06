USE [ShangWeiJi]
GO
/****** 对象:  Table [dbo].[CAT_TREATMENT_PlanFocus]    脚本日期: 08/28/2012 10:18:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CAT_TREATMENT_PlanFocus](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FractionID] [int] NULL,
	[FocusNumber] [int] NULL,
	[FocusStartTime] [datetime] NULL,
	[FocusEndTime] [datetime] NULL,
	[PlanX] [real] NULL,
	[PlanY] [real] NULL,
	[PlanZ] [real] NULL,
	[CouchX] [real] NULL,
	[CouchY] [real] NULL,
	[CouchZ] [real] NULL,
	[CollType] [int] NULL,
	[PlanCurePeriod] [datetime] NULL,
	[CurePeriod] [datetime] NULL,
 CONSTRAINT [PK_CAT_TREATMENT_PlanFocus] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
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