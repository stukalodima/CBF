-- begin UNTITLED_COMPANY
alter table UNTITLED_COMPANY add constraint FK_UNTITLED_COMPANY_ON_BUSINESS_DIRECTION foreign key (BUSINESS_DIRECTION_ID) references UNTITLED_BUSINESS_DIRECTION(ID)^
create index IDX_UNTITLED_COMPANY_ON_BUSINESS_DIRECTION on UNTITLED_COMPANY (BUSINESS_DIRECTION_ID)^
-- end UNTITLED_COMPANY
-- begin UNTITLED_FORECAST_BN
alter table UNTITLED_FORECAST_BN add constraint FK_UNTITLED_FORECAST_BN_ON_BUSINESS_DIRECTION foreign key (BUSINESS_DIRECTION_ID) references UNTITLED_BUSINESS_DIRECTION(ID)^
create index IDX_UNTITLED_FORECAST_BN_ON_BUSINESS_DIRECTION on UNTITLED_FORECAST_BN (BUSINESS_DIRECTION_ID)^
-- end UNTITLED_FORECAST_BN
-- begin UNTITLED_FORECAST_BN_DETAIL
alter table UNTITLED_FORECAST_BN_DETAIL add constraint FK_UNTITLED_FORECAST_BN_DETAIL_ON_COMPANY foreign key (COMPANY_ID) references UNTITLED_COMPANY(ID)^
alter table UNTITLED_FORECAST_BN_DETAIL add constraint FK_UNTITLED_FORECAST_BN_DETAIL_ON_CURRENCY foreign key (CURRENCY_ID) references UNTITLED_CURRENCY(ID)^
alter table UNTITLED_FORECAST_BN_DETAIL add constraint FK_UNTITLED_FORECAST_BN_DETAIL_ON_FORECAST_BN foreign key (FORECAST_BN_ID) references UNTITLED_FORECAST_BN(ID)^
create index IDX_UNTITLED_FORECAST_BN_DETAIL_ON_COMPANY on UNTITLED_FORECAST_BN_DETAIL (COMPANY_ID)^
create index IDX_UNTITLED_FORECAST_BN_DETAIL_ON_CURRENCY on UNTITLED_FORECAST_BN_DETAIL (CURRENCY_ID)^
create index IDX_UNTITLED_FORECAST_BN_DETAIL_ON_FORECAST_BN on UNTITLED_FORECAST_BN_DETAIL (FORECAST_BN_ID)^
-- end UNTITLED_FORECAST_BN_DETAIL
-- begin UNTITLED_FORECAST_CURRENCY_BALANCE
alter table UNTITLED_FORECAST_CURRENCY_BALANCE add constraint FK_UNTITLED_FORECAST_CURRENCY_BALANCE_ON_CURRENCY foreign key (CURRENCY_ID) references UNTITLED_CURRENCY(ID)^
alter table UNTITLED_FORECAST_CURRENCY_BALANCE add constraint FK_UNTITLED_FORECAST_CURRENCY_BALANCE_ON_FORECAST foreign key (FORECAST_ID) references UNTITLED_FORECAST(ID)^
create index IDX_UNTITLED_FORECAST_CURRENCY_BALANCE_ON_CURRENCY on UNTITLED_FORECAST_CURRENCY_BALANCE (CURRENCY_ID)^
create index IDX_UNTITLED_FORECAST_CURRENCY_BALANCE_ON_FORECAST on UNTITLED_FORECAST_CURRENCY_BALANCE (FORECAST_ID)^
-- end UNTITLED_FORECAST_CURRENCY_BALANCE
