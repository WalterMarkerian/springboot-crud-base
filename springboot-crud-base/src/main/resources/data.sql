/*
INSERT INTO `workshop`.`customers` (`id`, `name`, `surname`, `phone`, `email`, `gender`, `comment`) VALUES 
('1', 'John', 'Doe', '123456789', 'john.doe@example.com', '1', 'Regular customer with good communication'),
('2', 'Alice', 'Smith', '987654321', 'alice.smith@example.com', '2', 'Enthusiastic rider, always looking for new accessories'),
('3', 'Bob', 'Johnson', '555888999', 'bob.johnson@example.com', '1', 'First-time motorcycle owner, needs guidance on maintenance'),
('4', 'Eva', 'Williams', '777333111', 'eva.williams@example.com', '2', 'Interested in bike customization and tuning'),
('5', 'Mike', 'Brown', '111222333', 'mike.brown@example.com', '1', 'Prefers classic motorcycles and vintage restoration projects');


INSERT INTO `workshop`.`motorcycles` (`id`, `domain`, `brand`, `kilometers`, `chassis`, `motor_number`, `model`, `cylinder`, `year`, `comment`, `customer_id`) VALUES 
('1', 'ABC123', 'Honda', '15000', 'JH2RC4467FK123456', '123ABC', 'CBR600RR', '600', '2018', 'Excellent condition', '1'),
('2', 'XYZ789', 'Yamaha', '20000', 'JYARJ16E0FA000789', '456XYZ', 'YZF-R6', '600', '2016', 'Regular maintenance history', '2'),
('3', 'LMN456', 'Suzuki', '8000', 'JS1GN7FA9M2100123', '789LMN', 'GSX-R750', '750', '2020', 'Low mileage, like new', '3'),
('4', 'PQR987', 'Kawasaki', '30000', 'JKBZXNC15EA000456', '987PQR', 'Ninja 1000', '1000', '2015', 'Minor scratches on fairings', '4'),
('5', 'JKL321', 'Ducati', '12000', 'ZDM14BPW000123456', '321JKL', 'Panigale V4', '1100', '2019', 'Upgraded exhaust system', '5'),
('6', 'GHI789', 'Harley-Davidson', '25000', '1HD1BXV13DB012345', '789GHI', 'Sportster 1200', '1200', '2017', 'Custom paint job', '1');
*/
ALTER TABLE `workshop`.`customers` 
CHANGE COLUMN `surname` `surname` VARCHAR(255) NOT NULL AFTER `name`,
CHANGE COLUMN `email` `email` VARCHAR(255) NOT NULL AFTER `phone`,
CHANGE COLUMN `gender` `gender` TINYINT NOT NULL AFTER `email`,
CHANGE COLUMN `comment` `comment` VARCHAR(255) NOT NULL AFTER `gender`;





ALTER TABLE `workshop`.`motorcycles` 
CHANGE COLUMN `domain` `domain` VARCHAR(255) NOT NULL AFTER `id`,
CHANGE COLUMN `kilometers` `kilometers` VARCHAR(255) NOT NULL AFTER `brand`,
CHANGE COLUMN `motor_number` `motor_number` VARCHAR(255) NOT NULL AFTER `chassis`,
CHANGE COLUMN `model` `model` VARCHAR(255) NULL DEFAULT NULL AFTER `motor_number`,
CHANGE COLUMN `comment` `comment` VARCHAR(255) NULL DEFAULT NULL AFTER `year`,
CHANGE COLUMN `customer_id` `customer_id` BIGINT NULL DEFAULT NULL AFTER `comment`;

