-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema our_company
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema our_company
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `our_company` DEFAULT CHARACTER SET utf8mb4 ;
USE `our_company` ;

-- -----------------------------------------------------
-- Table `our_company`.`Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `our_company`.`Users` (
  `user_ID` INT NOT NULL,
  `first_name` VARCHAR(100) NOT NULL,
  `last_name` VARCHAR(100) NOT NULL,
  `email_ID` VARCHAR(100) NOT NULL,
  `password` VARCHAR(100) NOT NULL,
  `last_login_date` DATE NOT NULL,
  `access` INT NOT NULL,
  PRIMARY KEY (`user_ID`),
  UNIQUE INDEX `EMAIL_ID_UNIQUE` (`email_ID` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `our_company`.`Order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `our_company`.`Orders` (
  `order_ID` INT NOT NULL,
  `user_ID` INT NOT NULL,
  `product_ID` INT NOT NULL,
  `order_date` DATE NOT NULL,
  `amount_ordered` INT NOT NULL,
  `total_cost` DOUBLE NOT NULL,
  `order_replenish_boolean` CHAR(1) NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`order_ID`),
  INDEX `userID_fk1_idx` (`user_ID` ASC) VISIBLE,
  CONSTRAINT `userID_fk1`
    FOREIGN KEY (`user_ID`)
    REFERENCES `our_company`.`Users` (`user_ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
CONSTRAINT `product_fk2`
    FOREIGN KEY (`product_ID`)
    REFERENCES `our_company`.`Product` (`product_ID`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `our_company`.`Product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `our_company`.`Product` (
  `product_ID` INT NOT NULL,
  `description` VARCHAR(500) NULL,
  `Price` DOUBLE NOT NULL,
  `product_name` VARCHAR(100) NOT NULL,
  `in_stock` INT NOT NULL,
  `max_stock` INT NOT NULL,
  `min_stock` INT NOT NULL,
  `category` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`product_ID`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `our_company`.`USERS` (`user_ID`, `first_name`, `last_name`, `email_ID`, `password`, `last_login_date`, `access`) VALUES ('1', 'Huey', 'Isbel', 'hi@gmail.com', 'abc', '2021-10-01', '2');
INSERT INTO `our_company`.`USERS` (`user_ID`, `first_name`, `last_name`, `email_ID`, `password`, `last_login_date`, `access`) VALUES ('2', 'Angel', 'Wynonna', 'aw@gmail.com', 'def', '2022-04-06', '1');
INSERT INTO `our_company`.`USERS` (`user_ID`, `first_name`, `last_name`, `email_ID`, `password`, `last_login_date`, `access`) VALUES ('3', 'Isaac', 'Lauryn', 'il@gmail.com', 'ghi', '2022-03-24', '2');

INSERT INTO `our_company`.`PRODUCT` (`product_ID`, `description`, `Price`, `product_name`, `in_stock`, `max_stock`, `min_stock`, `category`) VALUES ('0001', 'a beach ball', '15.00', 'beach ball', '100', '500', '0', 'sports');
INSERT INTO `our_company`.`PRODUCT` (`product_ID`, `description`, `Price`, `product_name`, `in_stock`, `max_stock`, `min_stock`, `category`) VALUES ('0002', 'a pair of shorts', '20.00', 'shorts', '100', '400', '0', 'clothing');
INSERT INTO `our_company`.`PRODUCT` (`product_ID`, `description`, `Price`, `product_name`, `in_stock`, `max_stock`, `min_stock`, `category`) VALUES ('0003', 'a pair of shoes', '30.00', 'shoes', '100', '300', '0', 'clothing');
INSERT INTO `our_company`.`PRODUCT` (`product_ID`, `description`, `Price`, `product_name`, `in_stock`, `max_stock`, `min_stock`, `category`) VALUES ('0004', 'a summer hat', '15.00', 'hat', '100', '300', '0', 'accessory');

INSERT INTO `our_company`.`ORDERS` (`order_ID`, `user_ID`, `product_ID`, `order_date`, `amount_ordered`, `total_cost`, `order_replenish_boolean`, `location`) VALUES ('1', '1', '4', '2021-08-21', '2', '30.00', '1', 'CA');
INSERT INTO `our_company`.`ORDERS` (`order_ID`, `user_ID`, `product_ID`, `order_date`, `amount_ordered`, `total_cost`, `order_replenish_boolean`, `location`) VALUES ('2', '2', '3', '2021-08-21', '3', '90.00', '0', 'TX');
INSERT INTO `our_company`.`ORDERS` (`order_ID`, `user_ID`, `product_ID`, `order_date`, `amount_ordered`, `total_cost`, `order_replenish_boolean`, `location`) VALUES ('3', '3', '2', '2021-08-21', '5', '100.00', '0', 'CO');

