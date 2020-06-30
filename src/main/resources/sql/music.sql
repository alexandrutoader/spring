create database musicdb;
use musicdb;

create table singer
(
    ID         int auto_increment
        primary key,
    FIRST_NAME varchar(60) not null,
    LAST_NAME  varchar(40) not null,
    BIRTH_DATE date        null,
    constraint UQ_SINGER_1
        unique (FIRST_NAME, LAST_NAME)
);

INSERT INTO singer (ID, FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (2, 'Eric', 'Clapton', '1945-03-30');
INSERT INTO singer (ID, FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (3, 'John', 'Butler', '1975-04-01');
INSERT INTO singer (ID, FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (6, 'John', 'Lennon', '1940-10-09');
INSERT INTO singer (ID, FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (7, 'Ringo', 'Starr', '1940-07-07');
INSERT INTO singer (ID, FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (9, 'Elvis', 'Presley', '1942-10-12');
INSERT INTO singer (ID, FIRST_NAME, LAST_NAME, BIRTH_DATE) VALUES (10, 'DJ', 'Tiesto', '1945-03-30');


create table album
(
    ID           int auto_increment
        primary key,
    SINGER_ID    int          not null,
    TITLE        varchar(100) not null,
    RELEASE_DATE date         null,
    constraint UQ_SINGER_ALBUM_1
        unique (SINGER_ID, TITLE),
    constraint singer_id_foreign_key
        foreign key (SINGER_ID) references singer (ID)
            on delete cascade
);

INSERT INTO album (ID, SINGER_ID, TITLE, RELEASE_DATE) VALUES (3, 2, ' From The Cradle ', '1994-09-13');
INSERT INTO album (ID, SINGER_ID, TITLE, RELEASE_DATE) VALUES (4, 6, 'The Beatles', '1968-01-01');
INSERT INTO album (ID, SINGER_ID, TITLE, RELEASE_DATE) VALUES (5, 7, 'Abbey Road', '1969-01-01');
INSERT INTO album (ID, SINGER_ID, TITLE, RELEASE_DATE) VALUES (6, 7, 'Flowers', '1969-01-23');
