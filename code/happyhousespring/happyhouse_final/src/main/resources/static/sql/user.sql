CREATE TABLE IF NOT EXISTS `happyhouse`.`user` (
  `id` VARCHAR(16) NOT NULL,
  `pass` VARCHAR(20) NOT NULL,
  `name` VARCHAR(16) NOT NULL,
  `email` VARCHAR(45) NULL,
  `address` VARCHAR(100) NULL,
  `gender` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `joindate` TIMESTAMP NULL DEFAULT current_timestamp,
  PRIMARY KEY (`id`));
  
  insert into user values
				('ssafy', 1234, '김싸피', 'ssafy@ssafy.com', '대전', '여', '010-1234-5678', cast('2021-05-07' as date)),
                ('jossafy', 1234, '조싸피', 'jossafy@ssafy.com', '서울','남', '010-1234-1234', cast('2021-05-06' as date));
 
 commit;