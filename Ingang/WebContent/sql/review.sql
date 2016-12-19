--------------------------------------------------------
--  파일이 생성됨 - 월요일-12월-05-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table REVIEW
--------------------------------------------------------

  CREATE TABLE "REVIEW" 
   (	"REVIEW_CODE" VARCHAR2(20 BYTE), 
	"MEMBER_ID" VARCHAR2(20 BYTE), 
	"CLASS_CODE" VARCHAR2(20 BYTE), 
	"REVIEW_GRADE" NUMBER(*,0), 
	"REVIEW_RD" DATE
   ) ;
REM INSERTING into REVIEW
SET DEFINE OFF;
Insert into REVIEW (REVIEW_CODE,MEMBER_ID,CLASS_CODE,REVIEW_GRADE,REVIEW_RD) values ('rc1612050001','id002','cc1612050002',4,to_date('16/12/05','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index REVIEW_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "REVIEW_PK" ON "REVIEW" ("REVIEW_CODE") 
  ;
--------------------------------------------------------
--  Constraints for Table REVIEW
--------------------------------------------------------

  ALTER TABLE "REVIEW" ADD CONSTRAINT "REVIEW_PK" PRIMARY KEY ("REVIEW_CODE") ENABLE;
  ALTER TABLE "REVIEW" MODIFY ("REVIEW_RD" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("REVIEW_GRADE" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("CLASS_CODE" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "REVIEW" MODIFY ("REVIEW_CODE" NOT NULL ENABLE);
