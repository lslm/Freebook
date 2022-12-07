CREATE TABLE books(
    id UUID primary key,
    title varchar not null,
    author varchar not null,
    gender varchar not null,
    isbn varchar not null,
    publication_year varchar not null,
    synopsis varchar not null,
    edition varchar not null,
    publisher varchar not null
);