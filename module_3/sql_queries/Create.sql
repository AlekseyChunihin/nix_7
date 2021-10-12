CREATE DATABASE personal_finances
CREATE TABLE users
(
id integer IDENTITY(1,1) NOT NULL PRIMARY KEY,
[name] varchar(255) NOT NULL,
telephone_number varchar(15) NOT NULL
);

CREATE TABLE accounts
(
id integer IDENTITY(1,1) NOT NULL PRIMARY KEY,
balance integer NOT NULL,
[user_id] integer NOT NULL
);

CREATE TABLE operations
(
id integer IDENTITY(1,1) NOT NULL PRIMARY KEY,
[time] datetime NOT NULL,
[sum] integer NOT NULL,
category_id integer NOT NULL,
account_id integer NOT NULL
);

CREATE TABLE categories
(
id integer IDENTITY(1,1) NOT NULL PRIMARY KEY,
[name] varchar(255) NOT NULL,
category_type bit NOT NULL,
);
