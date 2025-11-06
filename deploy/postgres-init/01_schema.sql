-- Tablas base
CREATE TABLE IF NOT EXISTS equipos (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  city VARCHAR(100) NOT NULL,
  conference VARCHAR(50) NOT NULL,
  championships INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS jugadores (
  id SERIAL PRIMARY KEY,
  full_name VARCHAR(160) NOT NULL,
  position VARCHAR(60) NOT NULL,
  jersey_number INTEGER,
  equipo_id INT REFERENCES equipos(id) ON DELETE SET NULL
);

-- Datos demo
INSERT INTO equipos (name, city, conference, championships) VALUES
  ('Lakers', 'Los Angeles', 'Western', 17),
  ('Warriors', 'Golden State', 'Western', 7),
  ('Bucks', 'Milwaukee', 'Eastern', 2),
  ('Celtics', 'Boston', 'Eastern', 18)
ON CONFLICT DO NOTHING;

INSERT INTO jugadores (full_name, position, jersey_number, equipo_id) VALUES
  ('LeBron James', 'Forward', 23, 1),
  ('Stephen Curry', 'Guard', 30, 2),
  ('Kevin Durant', 'Forward', 35, 1),
  ('Giannis Antetokounmpo', 'Forward', 34, 3)
ON CONFLICT DO NOTHING;
