create database customer_manager;
CREATE TABLE `customer_manager`.`new_table` (
  `id_customer` INT NOT NULL,
  `name_customer` VARCHAR(45) NULL,
  `age` INT NULL,
  `address` VARCHAR(45) NULL,
  PRIMARY KEY (`id_customer`),
  UNIQUE INDEX `id_customer_UNIQUE` (`id_customer` ASC) VISIBLE);
  SELECT * FROM customer_manager.customer;
  insert into customer values
  (7,'Jonh Cena',21,'London'), 
  (2,'Hala Din',32,'London'),
  (3,'Ex Keep',44,'London'),
  (4,'Wat Ton',41,'London'),
  (5,'Tom Cruise',14,'London');
