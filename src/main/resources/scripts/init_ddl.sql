CREATE TABLE SampleTable
(
    Id INT(10) UNSIGNED PRIMARY KEY NOT NULL,
    IdOwner INT(10) UNSIGNED,
    Name VARCHAR(255),
    UUID VARCHAR(255) NOT NULL,
    Area VARCHAR(16) NOT NULL,
    IdElection INT(10) UNSIGNED
);