-- ----------------------------------------------------------------------------
-- Schema erste
-- ----------------------------------------------------------------------------

-- ----------------------------------------------------------------------------
-- Table erste.contact_details
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `erste`.`contact_details` (
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `contact_info` VARCHAR(255) NULL DEFAULT NULL,
    `contact_type` INT(11) NOT NULL,
    `credit_card` VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY (`id`));

-- ----------------------------------------------------------------------------
-- Table erste.credit_card
-- ----------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS `erste`.`credit_card` (
    `card_number` VARCHAR(255) NOT NULL,
    `card_type` INT(11) NOT NULL,
    `disabled` BIT(1) NULL DEFAULT NULL,
    `hash_code` VARCHAR(255) NULL DEFAULT NULL,
    `owner` VARCHAR(255) NULL DEFAULT NULL,
    `expiration_date` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`card_number`));
