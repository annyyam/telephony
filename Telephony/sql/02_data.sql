insert into rooms (id,name) values 
(1, 'Главный зал'),
(2, 'Офис');

insert into phones (id, extension_number, room_id, operator_name ) values 
(1, 300, 1, 'Маша'),
(2, 301, 1, 'Саша'),
(3, 302, 2, 'Наташа');

select setval('rooms_id_seq', (select max(id) from rooms));
select setval('phones_id_seq', (select max(id) from phones));