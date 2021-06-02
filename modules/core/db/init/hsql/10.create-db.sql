-- begin UNTITLED_COMPANY
create table UNTITLED_COMPANY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    EDRPOU varchar(12),
    BUSINESS_DIRECTION_ID varchar(36),
    --
    primary key (ID)
)^
-- end UNTITLED_COMPANY
-- begin UNTITLED_BUSINESS_DIRECTION
create table UNTITLED_BUSINESS_DIRECTION (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    --
    primary key (ID)
)^
-- end UNTITLED_BUSINESS_DIRECTION
-- begin UNTITLED_CURRENCY
create table UNTITLED_CURRENCY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    BASE_ boolean,
    --
    primary key (ID)
)^
-- end UNTITLED_CURRENCY
-- begin UNTITLED_FORECAST_BN
create table UNTITLED_FORECAST_BN (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    BUSINESS_DIRECTION_ID varchar(36),
    BALANCE_DATE date,
    ACTIVE boolean,
    --
    primary key (ID)
)^
-- end UNTITLED_FORECAST_BN
-- begin UNTITLED_FORECAST_BN_DETAIL
create table UNTITLED_FORECAST_BN_DETAIL (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    COMPANY_ID varchar(36),
    TYPE_CASH integer,
    CURRENCY_ID varchar(36),
    BALANCE double precision,
    IN_SUMM1 double precision,
    IN_SUMM2 double precision,
    IN_SUMM3 double precision,
    IN_SUMM4 double precision,
    IN_SUMM5 double precision,
    OUT_SUMM1 double precision,
    OUT_SUMM2 double precision,
    OUT_SUMM3 double precision,
    OUT_SUMM4 double precision,
    OUT_SUMM5 double precision,
    FORECAST_SUMM1 double precision,
    FORECAST_SUMM2 double precision,
    FORECAST_SUMM3 double precision,
    FORECAST_SUMM4 double precision,
    FORECAST_SUMM5 double precision,
    FORECAST_BN_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end UNTITLED_FORECAST_BN_DETAIL
-- begin UNTITLED_FORECAST
create table UNTITLED_FORECAST (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    POROG double precision,
    BALANCE_IN_BASE_CURRENCY double precision,
    --
    primary key (ID)
)^
-- end UNTITLED_FORECAST
-- begin UNTITLED_FORECAST_CURRENCY_BALANCE
create table UNTITLED_FORECAST_CURRENCY_BALANCE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CURRENCY_ID varchar(36),
    BALANCE double precision,
    IN_SUMM1 double precision,
    IN_SUMM2 double precision,
    IN_SUMM3 varchar(255),
    IN_SUMM4 double precision,
    IN_SUMM5 double precision,
    OUT_SUMM1 double precision,
    OUT_SUMM2 double precision,
    OUT_SUMM3 double precision,
    OUT_SUMM4 double precision,
    OUT_SUMM5 double precision,
    FORECAST_SUMM1 double precision,
    FORECAST_SUMM2 double precision,
    FORECAST_SUMM3 double precision,
    FORECAST_SUMM4 double precision,
    FORECAST_SUMM5 double precision,
    FORECAST_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end UNTITLED_FORECAST_CURRENCY_BALANCE
