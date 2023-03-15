ALTER TABLE lending_requests
DROP COLUMN approved;

ALTER TABLE lending_requests ADD COLUMN approved_at TIMESTAMP;