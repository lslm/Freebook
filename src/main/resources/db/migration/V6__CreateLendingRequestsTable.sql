CREATE TABLE lending_requests (
    id UUID PRIMARY KEY,
    requested_by UUID REFERENCES users(id),
    book_id UUID REFERENCES books(id)
);