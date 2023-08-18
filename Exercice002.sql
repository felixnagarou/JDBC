create table if not exists client (
	clientId serial primary key,
	first_name varchar(255),
	last_name varchar(255)	
);

create table if not exists account (
	accountId serial primary key,
	solde float not null,
	clientId int references client(clientId)	
);

create table if not exists operation (
	operationId serial primary key,
	amount float not null, 
	status boolean not null,
	accountId int references account(accountId)
);








--alter table account add constraint fk_operation foreign key (operationId) references operation(operationId) ;
--select * from operation;


