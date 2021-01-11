-- ПРИМЕЧАНИЕ СНАЧАЛА ТАБЛИЦЫ БЕЗ СВЯЗЕЙ

-- Роли
create table roles (
                     id serial primary key,
                     role varchar(255)
);

-- Права ролей
create table rules (
                     id serial primary key,
                     rule varchar(255)
);

-- Состояние заявки
create table states (
                      id serial primary key,
                      state varchar(255)
);

-- Категории заявки
create table categories (
                          id serial primary key,
                          category varchar(255)
);

-- Пользователи
-- user - role = many-to-one
create table users (
                     id serial primary key,
                     name varchar(255),
                     role_id int references roles(id)
);

-- role - rules = many-to-many
create table roles_rules (
                           id serial primary key,
                           role_id int references roles(id),
                           rule_id int references rules(id)
);

-- Заявки
-- item - user = many-to-one
-- item - category = many-to-one
-- item - state = many-to-one
create table items (
                     id serial primary key,
                     item varchar(255),
                     user_id int references users(id),
                     category_id int references categories(id),
                     state_id int references states(id)
);

-- Комментарии заявок
-- item - comments = one-to-many
create table comments (
                        id serial primary key,
                        comment varchar(1000),
                        item_id int references items(id)
);

-- Приложенные файлы
-- item - attachs = one-to-many
create table attachs (
                       id serial primary key,
                       attach_name varchar(255),
                       item_id int references items(id)
);