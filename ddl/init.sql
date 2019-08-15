DROP TABLE IF EXISTS division_naive;
DROP TABLE IF EXISTS division_path;
DROP TABLE IF EXISTS division_closure_path;
DROP TABLE IF EXISTS division_closure;

CREATE TABLE division_naive (
  id INTEGER NOT NULL PRIMARY KEY,
  parent_id INTEGER,
  FOREIGN KEY(parent_id) REFERENCES division_naive (id)
);

CREATE TABLE division_path (
  id INTEGER NOT NULL PRIMARY KEY,
  path TEXT NOT NULL
);

CREATE TABLE division_closure (
  id INTEGER NOT NULL PRIMARY KEY,
  depth INTEGER NOT NULL
);

CREATE TABLE division_closure_path (
  ancestor INTEGER NOT NULL,
  descendant INTEGER NOT NULL,
  PRIMARY KEY(ancestor, descendant),
  FOREIGN KEY(ancestor) REFERENCES division_closure (id),
  FOREIGN KEY(descendant) REFERENCES division_closure (id)
);
