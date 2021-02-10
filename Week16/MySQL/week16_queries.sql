insert into users(user_id, username, password, first_name, last_name)values(2,'john@doe.com', 'John123','John','Doe');
insert into users(user_id, username, password, first_name, last_name)values(3,'elon@musk.com', 'elon123','Elon','Musk');
insert into users(user_id, username, password, first_name, last_name)values(4,'jane@doe.com', 'jan12232','Jane','Doe');

select * from transactions;

insert into transactions(transaction_id, transaction_date, amount, type)
values(1,'2020-02-08',10.99,'D'); -- 10.99 is truncated as 11 since decimal(2) implies decimal(2,0) which means total number digits is 2 and no scale so no decimal

alter table transactions
change amount amount decimal(6,2);

insert into transactions(transaction_id, transaction_date, amount, type)
values(2,'2020-02-07',100.99,'D');


insert into transactions(transaction_id, transaction_date, amount, type)
values(3,'2020-02-08',1000.00,'C');


select * from transactions;

alter table transactions
add column user_id int;

alter table transactions
add constraint user_id_fk foreign key (user_id) references users(user_id);

alter table transactions 
drop foreign key transactions_ibfk_1;

update transactions 
set user_id = 2
where transaction_id= 3;
