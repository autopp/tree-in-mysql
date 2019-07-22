DROP TABLE IF EXISTS division_naive;
DROP TABLE IF EXISTS division_path;

CREATE TABLE division_naive (
  id INTEGER NOT NULL PRIMARY KEY,
  parent_id INTEGER,
  FOREIGN KEY(parent_id) REFERENCES division_naive (id)
);

CREATE TABLE division_path (
  id INTEGER NOT NULL PRIMARY KEY,
  path TEXT NOT NULL
);
