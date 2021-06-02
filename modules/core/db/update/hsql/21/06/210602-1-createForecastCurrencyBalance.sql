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
);