delete from STUDENT;
delete from USER;
delete from ROLE;

insert into ROLE(ROLE_NAME, CREATED_DATE, CREATED_BY) values('ROLE_ADMIN', NOW(), 'bdabbigodla');
insert into ROLE(ROLE_NAME, CREATED_DATE, CREATED_BY) values('ROLE_USER', NOW(), 'bdabbigodla');
insert into ROLE(ROLE_NAME, CREATED_DATE, CREATED_BY) values('ROLE_GUEST', NOW(), 'bdabbigodla');

insert into STUDENT(FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, DATE_OF_BIRTH, DATE_OF_JOINING, CREATED_DATE, CREATED_BY) values('Bhaskar', null, 'Dabbigodla', 'bdabbigodla@renaud-infotech.com', '1973-11-11', '2013-11-14', NOW(), 'bdabbigodla');
insert into USER(USER_NAME, PASSWORD, IS_ENABLED, STUDENT_ID, ROLE_ID, CREATED_DATE, CREATED_BY) values('bdabbigodla','$2a$10$l4MJ0r7hyJRhcYv/39/ouOO.XEOfKYjKA4XVWlUIjta.zCIQqaZGG', true, '1', '1', NOW(), 'bdabbigodla');

insert into STUDENT(FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, DATE_OF_BIRTH, DATE_OF_JOINING, CREATED_DATE, CREATED_BY) values('Admin', null, 'Admin', 'admin@renaud-infotech.com', '1960-09-09', '2014-01-01', NOW(), 'bdabbigodla');
insert into USER(USER_NAME, PASSWORD, IS_ENABLED, STUDENT_ID, ROLE_ID, CREATED_DATE, CREATED_BY) values('admin','$2a$10$uD3UnjlUzCV9G1S.Lh.Ase.5CiwT4farIFI4nYE2.us8BsIxF7HOi', true, '2', '1', NOW(), 'bdabbigodla');

insert into STUDENT(FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, DATE_OF_BIRTH, DATE_OF_JOINING, CREATED_DATE, CREATED_BY) values('Sachin', null, 'Tendulkar', 'stendulkar@renaud-infotech.com', '1973-04-24', '2014-01-01', NOW(), 'bdabbigodla');
insert into USER(USER_NAME, PASSWORD, IS_ENABLED, STUDENT_ID, ROLE_ID, CREATED_DATE, CREATED_BY) values('stendulkar','$2a$10$al8XhgAG901raubx7S9DtuHJcppZx5JOLSDE3R65aXNAy95H.uK4q', true, '3', '2', NOW(), 'bdabbigodla');

insert into STUDENT(FIRST_NAME, MIDDLE_NAME, LAST_NAME, EMAIL, DATE_OF_BIRTH, DATE_OF_JOINING, CREATED_DATE, CREATED_BY) values('Rahul', null, 'Dravid', 'rdravid@renaud-infotech.com', '1972-12-01', '2014-01-01', NOW(), 'bdabbigodla');
insert into USER(USER_NAME, PASSWORD, IS_ENABLED, STUDENT_ID, ROLE_ID, CREATED_DATE, CREATED_BY) values('rdravid','$2a$10$dCwsrt8i.ZhD9AfBu6hu6OLa8VFiQkoS68Z2rSxnf8ezbYBdFdHBG', true, '4', '3', NOW(), 'bdabbigodla');
