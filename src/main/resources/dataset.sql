INSERT INTO `security`.`user` (`id`, `age`, `email`, `name`, `password`) VALUES ('1', '10', 'admin@mail.ru', 'admin', '$2a$10$6qQkE9BKBQmlCfvUW99sA.q6r5DyLSU5yiW.PZedmuetDevi6Sv1u');
INSERT INTO `security`.`user` (`id`, `age`, `email`, `name`, `password`) VALUES ('2', '20', 'user@mail.ru', 'user', '$2a$10$XJhFiLE6eFZYBlo/JdX80eZeYyh/CLWOLfeAJUt62oRhwizmfsS52');
INSERT INTO `security`.`users_role` (`user_id`, `role_id`) VALUES ('1', '1');
INSERT INTO `security`.`users_role` (`user_id`, `role_id`) VALUES ('2', '2');