alter table phones
add constraint phones_room_id_fkey
foreign key (room_id)
references rooms(id)
on delete cascade;
