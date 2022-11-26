
CREATE TABLE PERSONS
(
    name VARCHAR(30) NOT NULL,
    surname VARCHAR(30) NOT NULL,
    age INTEGER CHECK(Age > 0 AND Age < 100),
    phone_number VARCHAR(15) UNIQUE,
    city_of_living VARCHAR(30),
    PRIMARY KEY(name, surname, age)
);

INSERT INTO PERSONS (name, surname, age, phone_number, city_of_living)
VALUES ('Petr', 'Petrov', 20, 89283654596, 'MOSCOW'),
       ('Ivan', 'Ivanov', 31, 89283694536, 'MOSCOW'),
       ('Alex', 'Alexiev', 35, 89283656786, 'KAZAN'),
       ('Dmitry', 'Dmitrov', 37, 89383654596, 'VLADIVOSTOK'),
       ('Mihail', 'Mihailov', 35, 89283651236, 'MOSCOW');

