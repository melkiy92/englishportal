CREATE TABLE `englishportal`.`users` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`email` VARCHAR(45) NOT NULL,
`password` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

INSERT INTO `englishportal`.`users` (`email`, `password`) VALUES ('abc@mail.ru', '12345')
INSERT INTO `englishportal`.`users` (`email`, `password`) VALUES ('cba@mail.ru', '54321')

CREATE TABLE `englishportal`.`roles` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

CREATE TABLE `englishportal`.`users_roles` (
`user_id` BIGINT(20) NOT NULL,
`role_id` BIGINT(20) NOT NULL,
INDEX `fk_users_idx` (`user_id` ASC) VISIBLE,
INDEX `fk_roles_idx` (`role_id` ASC) VISIBLE,
CONSTRAINT `fk_users`
FOREIGN KEY (`user_id`)
REFERENCES `englishportal`.`users` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION,
CONSTRAINT `fk_roles`
FOREIGN KEY (`role_id`)
REFERENCES `englishportal`.`roles` (`id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION);


INSERT INTO `englishportal`.`roles` (`name`) VALUES ('USER');
INSERT INTO `englishportal`.`roles` (`name`) VALUES ('MANAGER');
INSERT INTO `englishportal`.`roles` (`name`) VALUES ('ADMIN');

INSERT INTO `englishportal`.`users_roles` (`user_id`, `role_id`) VALUES ('1', '1');

CREATE TABLE `englishportal`.`en_words` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`meaning` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `meaning_UNIQUE` (`meaning` ASC) VISIBLE);

CREATE TABLE `englishportal`.`ru_words` (
`id` BIGINT(20) NOT NULL AUTO_INCREMENT,
`meaning` VARCHAR(45) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE INDEX `meaning_UNIQUE` (`meaning` ASC) VISIBLE);

CREATE TABLE `englishportal`.`cards` (
                                         `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                         `en_word_id` BIGINT(20) NOT NULL,
                                         `ru_word_id` BIGINT(20) NOT NULL,
                                         `rating` BIGINT(20) NULL,
                                         PRIMARY KEY (`id`),
                                         INDEX `fk__idx` (`en_word_id` ASC) VISIBLE,
                                         INDEX `fk_ru_word_idx` (`ru_word_id` ASC) VISIBLE,
                                         CONSTRAINT `fk_en_word`
                                             FOREIGN KEY (`en_word_id`)
                                                 REFERENCES `englishportal`.`en_words` (`id`)
                                                 ON DELETE NO ACTION
                                                 ON UPDATE NO ACTION,
                                         CONSTRAINT `fk_ru_word`
                                             FOREIGN KEY (`ru_word_id`)
                                                 REFERENCES `englishportal`.`ru_words` (`id`)
                                                 ON DELETE NO ACTION
                                                 ON UPDATE NO ACTION);


INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('hello');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('привет');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`) VALUES ('1', '1', '1');