CREATE TABLE IF NOT EXISTS `happyhouse`.`interestregion` (
	`id` VARCHAR(16) NOT NULL,
	`gu` VARCHAR(45) NOT NULL,
	PRIMARY KEY (`id`, `gu`),
	CONSTRAINT `happyhouse_userid_FK`
    FOREIGN KEY (`id`)
    REFERENCES `happyhouse`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
 
 commit;