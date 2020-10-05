alter table animais 
	rename column tag to tag_delete;
	
alter table animais
	add column tag varchar(100) unique;
	
insert into animais (tag)
	select tag_delete from animais;
	
alter table animais
	drop column tag_delete;
