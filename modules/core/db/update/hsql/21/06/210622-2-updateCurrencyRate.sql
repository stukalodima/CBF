-- alter table UNTITLED_CURRENCY_RATE add column CURRENCY_ID varchar(36) ^
-- update UNTITLED_CURRENCY_RATE set CURRENCY_ID = <default_value> ;
-- alter table UNTITLED_CURRENCY_RATE alter column CURRENCY_ID set not null ;
alter table UNTITLED_CURRENCY_RATE add column CURRENCY_ID varchar(36) not null ;
