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

CREATE TABLE `englishportal`.`images` (
                                          `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
                                          `name` VARCHAR(45) NOT NULL,
                                          `original_filename` VARCHAR(45) NOT NULL,
                                          `content_type` VARCHAR(45) NOT NULL,
                                          `size` BIGINT(20) NOT NULL,
                                          `bytes` LONGBLOB NOT NULL,
                                          PRIMARY KEY (`id`));

ALTER TABLE `englishportal`.`cards`
    ADD COLUMN `image_id` BIGINT(20) NULL AFTER `rating`,
    ADD INDEX `fk_images_idx` (`image_id` ASC) VISIBLE;
;
ALTER TABLE `englishportal`.`cards`
    ADD CONSTRAINT `fk_images`
        FOREIGN KEY (`image_id`)
            REFERENCES `englishportal`.`images` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

UPDATE `englishportal`.`cards` SET `image_id` = '1' WHERE (`id` = '1');

//for game

ALTER TABLE `englishportal`.`users`
    ADD COLUMN `name` VARCHAR(45) NOT NULL AFTER `password`,
    ADD UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE;
;
UPDATE `englishportal`.`users` SET `name` = 'Anna' WHERE (`id` = '1');


UPDATE `englishportal`.`en_words` SET `meaning` = 'monkey' WHERE (`id` = '1');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('buisquit');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('cookie');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('charger');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('date');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('dustpan');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('mop');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('octopus');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('radish');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('shade');
INSERT INTO `englishportal`.`en_words` (`meaning`) VALUES ('sunglasses');


UPDATE `englishportal`.`ru_words` SET `meaning` = 'обезьяна' WHERE (`id` = '1');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('печенье');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('зарядное устройство');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('финик');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('дата');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('свидание');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('совок');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('швабра');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('осьминог');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('редиска');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('тень');
INSERT INTO `englishportal`.`ru_words` (`meaning`) VALUES ('солнцезащитные очки');

INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('13', '2', '2', '6');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('14', '2', '2', '6');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('15', '3', '3', '7');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('16', '4', '4', '8');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('16', '5', '1', '9');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('16', '6', '2', '10');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('17', '7', '4', '11');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('18', '8', '4', '12');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('19', '9', '3', '13');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('20', '10', '2', '14');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('21', '11', '2', '15');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('21', '12', '4', '16');
INSERT INTO `englishportal`.`cards` (`en_word_id`, `ru_word_id`, `rating`, `image_id`) VALUES ('22', '12', '3', '16');

