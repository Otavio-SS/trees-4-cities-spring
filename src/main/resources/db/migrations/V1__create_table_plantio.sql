CREATE TABLE IF NOT EXISTS plantio (
    id SERIAL PRIMARY KEY,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    nome TEXT NOT NULL,
    quantidade_plantio NUMERIC(10,2) NOT NULL,
    quantidade_rastreio NUMERIC(10,2) NOT NULL
);