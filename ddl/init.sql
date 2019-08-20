DROP TABLE IF EXISTS tree_naive;
DROP TABLE IF EXISTS tree_path;
DROP TABLE IF EXISTS tree_closure_path;
DROP TABLE IF EXISTS tree_closure;

CREATE TABLE tree_naive (
  id INTEGER NOT NULL PRIMARY KEY,
  parent_id INTEGER,
  FOREIGN KEY(parent_id) REFERENCES tree_naive (id)
);

CREATE TABLE tree_path (
  id INTEGER NOT NULL PRIMARY KEY,
  path TEXT NOT NULL
);

CREATE TABLE tree_closure (
  id INTEGER NOT NULL PRIMARY KEY,
  depth INTEGER NOT NULL
);

CREATE TABLE tree_closure_path (
  ancestor INTEGER NOT NULL,
  descendant INTEGER NOT NULL,
  PRIMARY KEY(ancestor, descendant),
  FOREIGN KEY(ancestor) REFERENCES tree_closure (id),
  FOREIGN KEY(descendant) REFERENCES tree_closure (id)
);
