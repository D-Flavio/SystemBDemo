DROP DATABASE IF EXISTS systembdatabase;
CREATE DATABASE systembdatabase;
USE systembdatabase;


CREATE TABLE `systembdatabase`.`survalues` (
                                               `Id` INT NOT NULL,
                                               `ChdrNum` CHAR(8) NOT NULL,
                                               `SurValue` DECIMAL(15,2) NOT NULL,
                                               `Company` CHAR(1) NOT NULL,
                                               `Currency` CHAR(3) NULL,
                                               `ValidDate` CHAR(10) NULL,
                                               PRIMARY KEY (`Id`));

CREATE TABLE `systembdatabase`.`policy` (
                                            `id` INT NOT NULL,
                                            `chdrnum` CHAR(8) NOT NULL,
                                            `cownnum` CHAR(8) NOT NULL,
                                            `ownername` NVARCHAR(50) NULL,
                                            `lifcnum` CHAR(8) NULL,
                                            `lifcname` NVARCHAR(50) NULL,
                                            `aracde` CHAR(3) NULL,
                                            `agntnum` CHAR(5) NULL,
                                            `mailaddress` NVARCHAR(50) NULL,
                                            PRIMARY KEY (`id`));

CREATE TABLE `systembdatabase`.`outpay_header` (
                                                   `id` INT NOT NULL,
                                                   `clntnum` CHAR(8) NOT NULL,
                                                   `chdrnum` CHAR(8) NOT NULL,
                                                   `lettertype` CHAR(12) NOT NULL,
                                                   `printdate` DATETIME NOT NULL,
                                                   `dataid` CHAR(6) NULL,
                                                   `clntname` NVARCHAR(80) NULL,
                                                   `clntaddress` NVARCHAR(80) NULL,
                                                   `regdate` DATETIME NULL,
                                                   `benpercent` DECIMAL(6,2) NULL,
                                                   `role1` CHAR(2) NULL,
                                                   `role2` CHAR(2) NULL,
                                                   `cownnum` CHAR(8) NULL,
                                                   `cownname` NVARCHAR(80) NULL,
                                                   `notice01` NVARCHAR(80) NULL,
                                                   `notice02` NVARCHAR(80) NULL,
                                                   `notice03` NVARCHAR(80) NULL,
                                                   `notice04` NVARCHAR(80) NULL,
                                                   `notice05` NVARCHAR(80) NULL,
                                                   `notice06` NVARCHAR(80) NULL,
                                                   `claim_id` CHAR(9) NULL,
                                                   `tp2processdate` DATETIME NULL,
                                                   PRIMARY KEY (`id`));