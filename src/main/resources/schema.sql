create table exchange
(
    id                     INTEGER NOT NULL PRIMARY KEY AUTO_INCREMENT,
    currency_from           VARCHAR(50),
    currency_to             VARCHAR(50),
    exchange_rate       NUMERIC(19, 2),
    operation            VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS access(
userid INT AUTO_INCREMENT PRIMARY KEY,
fullname VARCHAR(255) NOT NULL,
username VARCHAR(50) NOT NULL,
password VARCHAR(50) NOT NULL
);