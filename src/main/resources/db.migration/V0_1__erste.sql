-- ----------------------------------------------------------------------------
-- MySQL Workbench Migration
-- Migrated Schemata: flyway
-- Source Schemata: erste
-- Created: Thu Sep  5 17:50:29 2019
-- Workbench Version: 8.0.17
-- ----------------------------------------------------------------------------

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------------------------------------------------------
-- Schema flyway
-- ----------------------------------------------------------------------------
DROP SCHEMA IF EXISTS `flyway` ;
CREATE SCHEMA IF NOT EXISTS `flyway` ;

-- ----------------------------------------------------------------------------
-- Table flyway.contact_details
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `flyway`.`contact_details` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `contact_info` VARCHAR(255) NULL DEFAULT NULL,
  `contact_type` INT(11) NOT NULL,
  `credit_card_card_number` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKld2l46anhbg3nwvwvlofg0a5i` (`credit_card_card_number` ASC) VISIBLE,
  CONSTRAINT `FKld2l46anhbg3nwvwvlofg0a5i`
    FOREIGN KEY (`credit_card_card_number`)
    REFERENCES `flyway`.`credit_card` (`card_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- ----------------------------------------------------------------------------
-- Table flyway.credit_card
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `flyway`.`credit_card` (
  `card_number` VARCHAR(255) NOT NULL,
  `card_type` INT(11) NOT NULL,
  `disabled` BIT(1) NULL DEFAULT NULL,
  `hash_code` VARCHAR(255) NULL DEFAULT NULL,
  `owner` VARCHAR(255) NULL DEFAULT NULL,
  `expiration_date` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`card_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;
SET FOREIGN_KEY_CHECKS = 1;
