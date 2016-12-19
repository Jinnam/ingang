--------------------------------------------------------
--  파일이 생성됨 - 월요일-12월-05-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PACKAGE
--------------------------------------------------------

  CREATE TABLE "PACKAGE" 
   (	"PACKAGE_CODE" VARCHAR2(20 BYTE), 
	"CLASS_SET" VARCHAR2(20 BYTE), 
	"CLASS_ONE" VARCHAR2(20 BYTE)
   ) ;
REM INSERTING into PACKAGE
SET DEFINE OFF;
Insert into PACKAGE (PACKAGE_CODE,CLASS_SET,CLASS_ONE) values ('pc1612050001','cp1612050001','cc1612050001');
Insert into PACKAGE (PACKAGE_CODE,CLASS_SET,CLASS_ONE) values ('pc1612050002','cp1612050001','cc1612050002');
--------------------------------------------------------
--  DDL for Index PACKAGE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PACKAGE_PK" ON "PACKAGE" ("PACKAGE_CODE") 
  ;
--------------------------------------------------------
--  Constraints for Table PACKAGE
--------------------------------------------------------

  ALTER TABLE "PACKAGE" ADD CONSTRAINT "PACKAGE_PK" PRIMARY KEY ("PACKAGE_CODE") ENABLE;
  ALTER TABLE "PACKAGE" MODIFY ("CLASS_ONE" NOT NULL ENABLE);
  ALTER TABLE "PACKAGE" MODIFY ("CLASS_SET" NOT NULL ENABLE);
  ALTER TABLE "PACKAGE" MODIFY ("PACKAGE_CODE" NOT NULL ENABLE);
