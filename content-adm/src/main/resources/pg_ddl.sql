CREATE SCHEMA deep2k;

CREATE TABLE deep2k.videos
(
    id        bigint NOT NULL,
    "content" bytea  NULL,
    moderated bool   NULL,
    CONSTRAINT videos_pk PRIMARY KEY (id)
);


CREATE TABLE deep2k.currencies
(
    code   char varying NOT NULL,
    "name" varchar      NULL,
    buy    float4       NULL,
    sell   float4       NULL,
    CONSTRAINT currencies_pk PRIMARY KEY (code)
);

CREATE TABLE deep2k.facilities
(
    id        bigint  NOT NULL,
    "name"    varchar NULL,
    moderated bool    NULL,
    CONSTRAINT facilities_pk PRIMARY KEY (id)
);


