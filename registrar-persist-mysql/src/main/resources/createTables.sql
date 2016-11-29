create table productTable (
	id integer primary key,
	--category enum('FOOD','FURNITURE','NARCOTICS','INDUSTRIAL_EQUIPMENT'),
	category varchar(50),
	name varchar(50),
	--manufacturer enum('APPLE','BRAZZERS','UMBRELLACORP'),
	manufacturer varchar(50),
	sizex integer,
	sizey integer,
	sizez integer,
	weight float,
	restriction integer
);

create table customerTable (
	id integer primary key,
	name varchar(50),
	country varchar(50),
	city varchar(50),
	street varchar(50),
	num integer
);

create table positionsTable (
	id integer primary key,
	productId integer,
	place varchar(10),
	foreign key (productId) references productTable(id) on delete cascade
);

create table boxTable (
	id integer primary key,
	product integer,
	count integer,
	boxSize enum('SMALL','MEDIUM','LARGE'),
	foreign key (product) references productTable(id) on delete cascade
);

create table orderTable (
	id integer primary key,
	orderId integer,
	product integer,
	customer integer,
	count integer,
	foreign key (product) references productTable(id) on delete cascade,
	foreign key (customer) references customerTable(id) on delete cascade
);

create table cargoTable (
	id integer primary key,
	source integer,
	destination integer, 
	foreign key (source) references customerTable(id) on delete cascade,
	foreign key (destination) references customerTable(id) on delete cascade
);

create table cargo_boxTable (
	id integer primary key,
	cargoId integer,
	boxId integer,
	foreign key (cargoId) references cargoTable(id) on delete cascade,
	foreign key (boxId) references boxTable(id) on delete cascade
);