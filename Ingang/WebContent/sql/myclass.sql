--------------------------------------------------------
--  파일이 생성됨 - 월요일-12월-05-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table MYCLASS
--------------------------------------------------------

  CREATE TABLE "MYCLASS" 
   (	"MYCLASS_CODE" VARCHAR2(20 BYTE), 
	"MEMBER_ID" VARCHAR2(20 BYTE), 
	"CLASS_CODE" VARCHAR2(20 BYTE), 
	"SERVICE_START" DATE, 
	"SERVICE_END" DATE
   ) ;
REM INSERTING into MYCLASS
SET DEFINE OFF;
Insert into MYCLASS (MYCLASS_CODE,MEMBER_ID,CLASS_CODE,SERVICE_START,SERVICE_END) values ('mc1612050001','id002','cc1612050002',to_date('16/12/05','RR/MM/DD'),to_date('17/01/05','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index MYCLASS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "MYCLASS_PK" ON "MYCLASS" ("MYCLASS_CODE") 
  ;
--------------------------------------------------------
--  Constraints for Table MYCLASS
--------------------------------------------------------

  ALTER TABLE "MYCLASS" ADD CONSTRAINT "MYCLASS_PK" PRIMARY KEY ("MYCLASS_CODE") ENABLE;
  ALTER TABLE "MYCLASS" MODIFY ("SERVICE_END" NOT NULL ENABLE);
  ALTER TABLE "MYCLASS" MODIFY ("SERVICE_START" NOT NULL ENABLE);
  ALTER TABLE "MYCLASS" MODIFY ("CLASS_CODE" NOT NULL ENABLE);
  ALTER TABLE "MYCLASS" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "MYCLASS" MODIFY ("MYCLASS_CODE" NOT NULL ENABLE);
