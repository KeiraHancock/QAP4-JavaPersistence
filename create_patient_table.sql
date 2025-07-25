-- create_tables.sql

-- Table for storing patient records
CREATE TABLE patients (
    patientId INT PRIMARY KEY,
    patientFirstName VARCHAR(50),
    patientLastName VARCHAR(50),
    patientDOB DATE
);
