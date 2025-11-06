-- Create equipos table
CREATE TABLE IF NOT EXISTS equipos (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  city VARCHAR(100) NOT NULL,
  conference VARCHAR(50) NOT NULL,
  championships INTEGER DEFAULT 0
);

-- Insert demo data
INSERT INTO equipos (name, city, conference, championships) VALUES
  ('Lakers', 'Los Angeles', 'Western', 17),
  ('Warriors', 'Golden State', 'Western', 7),
  ('Bucks', 'Milwaukee', 'Eastern', 2),
  ('Celtics', 'Boston', 'Eastern', 18)
ON CONFLICT DO NOTHING;

