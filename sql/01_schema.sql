create table rooms (
id bigserial primary key,
name varchar(255) not null
);

create table phones (
id bigserial primary key,
extension_number int8 not null unique,
room_id int8 not null,
operator_name varchar(255) not null
);