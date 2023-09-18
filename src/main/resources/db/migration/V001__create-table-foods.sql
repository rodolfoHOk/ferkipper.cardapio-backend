CREATE TABLE foods(
    id SERIAL PRIMARY KEY,
    title TEXT NOT NULL UNIQUE,
    image TEXT,
    price INTEGER NOT NULL
);