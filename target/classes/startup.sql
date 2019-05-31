-- MySql
CREATE SCHEMA `waes`;
CREATE TABLE `waes`.`waesdiff` (
  `id` INT(11) NOT NULL auto_increment,
  `left` VARCHAR(200) NULL,
  `right` VARCHAR(200) NULL,
  PRIMARY KEY (`id`));

INSERT INTO waes.waesdiff values(1, null, null);
INSERT INTO waes.waesdiff values(2, '{"name":"Jaime","age":"36"}', '{"name":"Barbara","age":"30"}');
