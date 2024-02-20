DROP TABLE IF EXISTS TEMPERATURE_DEVIATION;

CREATE TABLE  TEMPERATURE_DEVIATION(
    ID bigint AUTO_INCREMENT PRIMARY KEY,
    AIRCRAFT_ID VARCHAR (255) NOT NULL,
    ALTITUDE VARCHAR (255) NOT NULL,
    TEMPERATURE VARCHAR (255) NOT NULL,
    AIRCRAFT_TYPE VARCHAR (255) NOT NULL
);