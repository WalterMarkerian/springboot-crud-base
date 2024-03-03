ALTER TABLE `workshop`.`customers` 
CHANGE COLUMN `name` `name` VARCHAR(255) NOT NULL AFTER `customer_id`,
CHANGE COLUMN `surname` `surname` VARCHAR(255) NOT NULL AFTER `name`,
CHANGE COLUMN `gender` `gender` TINYINT NOT NULL AFTER `dni`,
CHANGE COLUMN `phone` `phone` VARCHAR(255) NOT NULL AFTER `gender`,
CHANGE COLUMN `comment` `comment` VARCHAR(255) NULL DEFAULT NULL AFTER `email`;


ALTER TABLE `workshop`.`motorcycles` 
CHANGE COLUMN `domain` `domain` VARCHAR(255) NOT NULL AFTER `motorcycle_id`,
CHANGE COLUMN `model` `model` VARCHAR(255) NOT NULL AFTER `brand`,
CHANGE COLUMN `cylinder` `cylinder` VARCHAR(255) NOT NULL AFTER `model`,
CHANGE COLUMN `year` `year` VARCHAR(255) NOT NULL AFTER `cylinder`,
CHANGE COLUMN `motor_number` `motor_number` VARCHAR(255) NOT NULL AFTER `chassis`,
CHANGE COLUMN `kilometers` `kilometers` VARCHAR(255) NOT NULL AFTER `motor_number`;
