CREATE TABLE [Location]
(
id integer NOT NULL PRIMARY KEY,
[name]  text NOT NULL
);

CREATE TABLE [Route]
(
id integer NOT NULL PRIMARY KEY,
from_id  integer,
to_id  integer,
cost  integer
);

CREATE TABLE Problem
(
id integer NOT NULL PRIMARY KEY,
from_id  integer,
to_id  integer
);

CREATE TABLE Solution
(
problem_id integer NOT NULL PRIMARY KEY,
cost  integer
);