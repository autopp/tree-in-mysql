DROP TABLE IF EXISTS division_naive;

CREATE TABLE division_naive (
  id INTEGER NOT NULL PRIMARY KEY,
  parent_id INTEGER,
  FOREIGN KEY(parent_id) REFERENCES division_naive (id)
);
