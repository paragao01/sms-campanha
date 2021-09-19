create table tb_manual_blacklist (	
	id bigint(10) primary key not null AUTO_INCREMENT,
	manual varchar(20),
	blackList_id bigint(10)
)engine=INNODB;