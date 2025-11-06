-- Create jugadores table
CREATE TABLE IF NOT EXISTS jugadores (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(160) NOT NULL,
  position VARCHAR(60) NOT NULL,
  jersey_number INTEGER,
  equipo_id INTEGER
);

-- Insert demo data
INSERT INTO jugadores (full_name, position, jersey_number, equipo_id) VALUES
  ('LeBron James', 'Forward', 23, 1),
  ('Stephen Curry', 'Guard', 30, 2),
  ('Kevin Durant', 'Forward', 35, 1),
  ('Giannis Antetokounmpo', 'Forward', 34, 3)
ON CONFLICT DO NOTHING;

