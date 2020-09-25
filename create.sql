create sequence hibernate_sequence start with 1 increment by 1
create table availibility (id bigint not null, from timestamp, to timestamp, car_id bigint, primary key (id))
create table car (id bigint not null, car_number_plate varchar(255), car_type integer, primary key (id))
alter table availibility add constraint FK7lf68v4l87va7pe412dsx03in foreign key (car_id) references car
create sequence hibernate_sequence start with 1 increment by 1
create table availibility (id bigint not null, from timestamp, to timestamp, car_id bigint, primary key (id))
create table car (id bigint not null, car_number_plate varchar(255), car_type integer, primary key (id))
alter table availibility add constraint FK7lf68v4l87va7pe412dsx03in foreign key (car_id) references car
