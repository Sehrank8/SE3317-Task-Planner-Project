create table tasks (
id INT AUTO_INCREMENT PRIMARY KEY,
task_name varchar(24) NOT NULL,
description varchar(150),
category varchar(24),
deadline DATE
);