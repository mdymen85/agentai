-- Create a new database
CREATE DATABASE IF NOT EXISTS agentai_db;

-- Switch to the new database
USE agentai_db;

-- Create a user and grant them privileges
# CREATE USER 'mdymen85'@'%' IDENTIFIED BY 'mdymen_pass';
# GRANT ALL PRIVILEGES ON agentai_db.* TO 'mdymen85'@'%';
# FLUSH PRIVILEGES;

-- Create a sample table
CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    secret_key VARCHAR(255) DEFAULT NULL
);

-- Insert some data
INSERT INTO users (name, email, secret_key) VALUES ('Alice', 'alice@example.com', 's3cr3tK3y');
INSERT INTO users (name, email, secret_key) VALUES ('Bob', 'bob@example.com', 'an0th3rS3cr3t');