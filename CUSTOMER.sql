/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : ORACLE.SCOTT
Source Server Version : 110200
Source Host           : localhost:1521
Source Schema         : SCOTT

Target Server Type    : ORACLE
Target Server Version : 110200
File Encoding         : 65001

Date: 2016-11-05 11:14:42
*/


-- ----------------------------
-- Table structure for CUSTOMER
-- ----------------------------
DROP TABLE "SCOTT"."CUSTOMER";
CREATE TABLE "SCOTT"."CUSTOMER" (
"ID" NUMBER NOT NULL ,
"NAME" VARCHAR2(20 BYTE) NULL ,
"GENDER" VARCHAR2(10 BYTE) NULL ,
"BIRTHDAY" DATE NULL ,
"CELLPHONE" VARCHAR2(20 BYTE) NULL ,
"EMAIL" VARCHAR2(40 BYTE) NULL ,
"PREFERENCE" VARCHAR2(100 BYTE) NULL ,
"TYPE" VARCHAR2(40 BYTE) NULL ,
"DESCRIPTION" VARCHAR2(255 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Indexes structure for table CUSTOMER
-- ----------------------------

-- ----------------------------
-- Checks structure for table CUSTOMER
-- ----------------------------
ALTER TABLE "SCOTT"."CUSTOMER" ADD CHECK ("ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CUSTOMER
-- ----------------------------
ALTER TABLE "SCOTT"."CUSTOMER" ADD PRIMARY KEY ("ID");
