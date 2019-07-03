DROP TABLE IF EXISTS division_naive;

CREATE TABLE division_naive (
  id INTEGER NOT NULL PRIMARY KEY,
  name TEXT NOT NULL,
  parent_id INTEGER,
  FOREIGN KEY(parent_id) REFERENCES division_naive (id)
);

INSERT INTO division_naive (id, name, parent_id) VALUES (0, "root", null);
