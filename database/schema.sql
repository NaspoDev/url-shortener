-- URL Shortener database schema.

CREATE TABLE `urls` (
  id INT NOT NULL AUTO_INCREMENT,
  original_url VARCHAR(2048) NOT NULL,
  -- 'COLLATE utf8mb4_bin' enforces case sensitivity for 'token' values.
  token VARCHAR(5) COLLATE utf8mb4_bin DEFAULT NULL,
  PRIMARY KEY (id)
);