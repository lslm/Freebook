CREATE TABLE lendings(
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users(id),
    book_id UUID REFERENCES books(id)
);