IF NOT EXISTS (SELECT name FROM sys.databases WHERE name = 'Nexum')
BEGIN
    CREATE DATABASE Nexum;
END