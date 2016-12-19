--------------------------------------------------------
--  ������ ������ - ������-12��-05-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table BASKET
--------------------------------------------------------

  CREATE TABLE "BASKET" 
   (	"BASKET_CODE" VARCHAR2(20 BYTE), 
	"MEMBER_ID" VARCHAR2(20 BYTE), 
	"CLASS_CODE" VARCHAR2(20 BYTE), 
	"BASKET_RD" DATE, 
	"BASKET_STATE" VARCHAR2(20 BYTE)
   ) ;
REM INSERTING into BASKET
SET DEFINE OFF;
Insert into BASKET (BASKET_CODE,MEMBER_ID,CLASS_CODE,BASKET_RD,BASKET_STATE) values ('bc1612050001','id001','cc1612050001',to_date('16/12/05','RR/MM/DD'),'�̰���');
--------------------------------------------------------
--  Constraints for Table BASKET
--------------------------------------------------------

  ALTER TABLE "BASKET" MODIFY ("BASKET_STATE" NOT NULL ENABLE);
  ALTER TABLE "BASKET" MODIFY ("BASKET_RD" NOT NULL ENABLE);
  ALTER TABLE "BASKET" MODIFY ("CLASS_CODE" NOT NULL ENABLE);
  ALTER TABLE "BASKET" MODIFY ("MEMBER_ID" NOT NULL ENABLE);
  ALTER TABLE "BASKET" MODIFY ("BASKET_CODE" NOT NULL ENABLE);
