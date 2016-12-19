--------------------------------------------------------
--  ������ ������ - ������-12��-05-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table INSTRUCTOR
--------------------------------------------------------

  CREATE TABLE "INSTRUCTOR" 
   (	"INSTRUCTOR_CODE" VARCHAR2(20 BYTE), 
	"INSTRUCTOR_NAME" VARCHAR2(20 BYTE), 
	"INSTRUCTOR_DETAIL" VARCHAR2(300 BYTE), 
	"INSTRUCTOR_IMAGE" VARCHAR2(50 BYTE)
   ) ;
REM INSERTING into INSTRUCTOR
SET DEFINE OFF;
Insert into INSTRUCTOR (INSTRUCTOR_CODE,INSTRUCTOR_NAME,INSTRUCTOR_DETAIL,INSTRUCTOR_IMAGE) values ('ic1612050001','������','�ѱ�����Ʈ����������',null);
Insert into INSTRUCTOR (INSTRUCTOR_CODE,INSTRUCTOR_NAME,INSTRUCTOR_DETAIL,INSTRUCTOR_IMAGE) values ('ic1612050002','�ڼ�ȯ','�ѱ�����Ʈ����������',null);
--------------------------------------------------------
--  DDL for Index INSTRUCTOR_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "INSTRUCTOR_PK" ON "INSTRUCTOR" ("INSTRUCTOR_CODE") 
  ;
--------------------------------------------------------
--  Constraints for Table INSTRUCTOR
--------------------------------------------------------

  ALTER TABLE "INSTRUCTOR" ADD CONSTRAINT "INSTRUCTOR_PK" PRIMARY KEY ("INSTRUCTOR_CODE") ENABLE;
  ALTER TABLE "INSTRUCTOR" MODIFY ("INSTRUCTOR_DETAIL" NOT NULL ENABLE);
  ALTER TABLE "INSTRUCTOR" MODIFY ("INSTRUCTOR_NAME" NOT NULL ENABLE);
  ALTER TABLE "INSTRUCTOR" MODIFY ("INSTRUCTOR_CODE" NOT NULL ENABLE);
