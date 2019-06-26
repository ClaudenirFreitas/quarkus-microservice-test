CREATE TABLE T_PRODUCT (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    TXT_NAME VARCHAR(255) NOT NULL,
    TXT_DESCRIPTION VARCHAR(255),
    NUM_PRICE DECIMAL(11,2) NOT NULL,
    CONSTRAINT PK_PRODUCT PRIMARY KEY (ID)
);