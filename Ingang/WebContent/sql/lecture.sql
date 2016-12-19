--------------------------------------------------------
--  ������ ������ - ������-12��-05-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table LECTURE
--------------------------------------------------------

  CREATE TABLE "LECTURE" 
   (	"LECTURE_CODE" VARCHAR2(20 BYTE), 
	"CLASS_CODE" VARCHAR2(20 BYTE), 
	"LECTURE_NAME" VARCHAR2(50 BYTE), 
	"LECTURE_DETAIL" VARCHAR2(50 BYTE), 
	"LECTURE_FILE" VARCHAR2(50 BYTE), 
	"LECTURE_DATE" DATE
   ) ;
REM INSERTING into LECTURE
SET DEFINE OFF;
Insert into LECTURE (LECTURE_CODE,CLASS_CODE,LECTURE_NAME,LECTURE_DETAIL,LECTURE_FILE,LECTURE_DATE) values ('lc1612050001','cl1612050001','1��.���� �����ΰ�','���� �����ΰ�','whoAmI.avi',to_date('16/12/05','RR/MM/DD'));
Insert into LECTURE (LECTURE_CODE,CLASS_CODE,LECTURE_NAME,LECTURE_DETAIL,LECTURE_FILE,LECTURE_DATE) values ('lc1612050002','cl1612050001','2��.������ �����ΰ�','�״� �����ΰ�','WhoAreYou.avi',to_date('16/12/05','RR/MM/DD'));
Insert into LECTURE (LECTURE_CODE,CLASS_CODE,LECTURE_NAME,LECTURE_DETAIL,LECTURE_FILE,LECTURE_DATE) values ('lc1612050003','cl1612050002','1��.��ǻ��������','��ǻ�ʹ� �����ΰ�','WhatIsCom.avi',to_date('16/12/05','RR/MM/DD'));
Insert into LECTURE (LECTURE_CODE,CLASS_CODE,LECTURE_NAME,LECTURE_DETAIL,LECTURE_FILE,LECTURE_DATE) values ('lc1612050004','cl1612050002','2��.java�� ����','�ڹٴ� �����ΰ�','WhatIsJava.avi',to_date('16/12/05','RR/MM/DD'));
--------------------------------------------------------
--  DDL for Index LECTURE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "LECTURE_PK" ON "LECTURE" ("LECTURE_CODE") 
  ;
--------------------------------------------------------
--  Constraints for Table LECTURE
--------------------------------------------------------

  ALTER TABLE "LECTURE" MODIFY ("LECTURE_DATE" NOT NULL ENABLE);
  ALTER TABLE "LECTURE" ADD CONSTRAINT "LECTURE_PK" PRIMARY KEY ("LECTURE_CODE") ENABLE;
  ALTER TABLE "LECTURE" MODIFY ("LECTURE_FILE" NOT NULL ENABLE);
  ALTER TABLE "LECTURE" MODIFY ("LECTURE_DETAIL" NOT NULL ENABLE);
  ALTER TABLE "LECTURE" MODIFY ("LECTURE_NAME" NOT NULL ENABLE);
  ALTER TABLE "LECTURE" MODIFY ("CLASS_CODE" NOT NULL ENABLE);
  ALTER TABLE "LECTURE" MODIFY ("LECTURE_CODE" NOT NULL ENABLE);
