-- role
insert into roles(role) values ('user');
insert into roles(role) values ('adv_user');
insert into roles(role) values ('admin');

-- rule
insert into rules(rule) values ('read');
insert into rules(rule) values ('write');
insert into rules(rule) values ('delete');

-- state
insert into states(state) values ('pending');
insert into states(state) values ('in process');
insert into states(state) values ('resolved');

-- category
insert into categories(category) values ('regular');
insert into categories(category) values ('important');
insert into categories(category) values ('very important');

/*
если я правильно понимаю вышеуказанные таблицы заполняются до начала работы
(по заданию - начальные данные)
остальные таблицы заполняются в процессе работы
 */


