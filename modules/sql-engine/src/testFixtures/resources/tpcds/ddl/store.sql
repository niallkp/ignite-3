create table STORE
(
    S_STORE_SK         INTEGER       not null,
    S_STORE_ID         VARCHAR(16) not null,
    S_REC_START_DATE   DATE,
    S_REC_END_DATE     DATE,
    S_CLOSED_DATE_SK   INTEGER,
    S_STORE_NAME       VARCHAR(50),
    S_NUMBER_EMPLOYEES INTEGER,
    S_FLOOR_SPACE      INTEGER,
    S_HOURS            VARCHAR(20),
    S_MANAGER          VARCHAR(40),
    S_MARKET_ID        INTEGER,
    S_GEOGRAPHY_CLASS  VARCHAR(100),
    S_MARKET_DESC      VARCHAR(100),
    S_MARKET_MANAGER   VARCHAR(40),
    S_DIVISION_ID      INTEGER,
    S_DIVISION_NAME    VARCHAR(50),
    S_COMPANY_ID       INTEGER,
    S_COMPANY_NAME     VARCHAR(50),
    S_STREET_NUMBER    VARCHAR(10),
    S_STREET_NAME      VARCHAR(60),
    S_STREET_TYPE      VARCHAR(15),
    S_SUITE_NUMBER     VARCHAR(10),
    S_CITY             VARCHAR(60),
    S_COUNTY           VARCHAR(30),
    S_STATE            VARCHAR(2),
    S_ZIP              VARCHAR(10),
    S_COUNTRY          VARCHAR(20),
    S_GMT_OFFSET       NUMERIC(5, 2),
    S_TAX_PERCENTAGE   NUMERIC(5, 2),
    constraint STORE_PK
        primary key (S_STORE_SK)
);
