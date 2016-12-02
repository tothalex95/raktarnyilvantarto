use registrar;

insert into addressTable values(1, "HU", "Miskolc", "sarok", 1);
insert into addressTable values(2, "HU", "Eger", "templom", 2);
insert into addressTable values(3, "HU", "Bivalybasznád", "basznám", 3);

insert into productTable values(1,"FOOD","vaj","APPLE", 5,5,5,25,0);
insert into productTable values(2,"FURNITURE","kanapé","BRAZZERS", 50,50,200,250,1);
insert into productTable values(3,"NARCOTICS","viagra","BRAZZERS", 1,1,1,4,0);
insert into productTable values(4,"INDUSTRIAL_EQUIPMENT","lézerFolyosóAmiFelszeleteliACsajtAFilmben","UMBRELLACORP", 500,500,500,2500,5);

insert into customerTable values(1, "Jani", 1);
insert into customerTable values(2, "Feri", 2);
insert into customerTable values(3, "Pityu", 3);

insert into positionsTable values(1, 4, "passz1");
insert into positionsTable values(2, 3, "passz2");
insert into positionsTable values(3, 2, "passz3");
insert into positionsTable values(4, 1, "passz4");

insert into boxTable values(1, 1, 45, "SMALL");
insert into boxTable values(2, 3, 5, "MEDIUM");
insert into boxTable values(3, 2, 4, "MEDIUM");
insert into boxTable values(4, 4, 405, "LARGE");

insert into orderTable values(1, 1, 1, 1, 12);
insert into orderTable values(2, 2, 2, 2, 102);
insert into orderTable values(3, 3, 3, 3, 120);

insert into cargoTable values(1, 1, 2);
insert into cargoTable values(2, 2, 3);
insert into cargoTable values(3, 3, 1);

insert into cargo_boxTable values(1, 1, 1);
insert into cargo_boxTable values(2, 2, 2);
insert into cargo_boxTable values(3, 3, 3);