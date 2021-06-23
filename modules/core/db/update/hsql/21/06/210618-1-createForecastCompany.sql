create table UNTITLED_FORECAST_COMPANY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    ROW_ integer,
    COMPANY_ID varchar(36),
    TYPE_CASH integer,
    CURRENCY_ID varchar(36),
    BALANCE double precision,
    DAY_ integer,
    OPERATION varchar(50),
    SUMM double precision,
    --
    primary key (ID)
);