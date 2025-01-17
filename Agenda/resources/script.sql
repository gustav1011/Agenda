-- Tabela Agenda
CREATE TABLE Agenda (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único da agenda
    nome VARCHAR(255) NOT NULL         -- Nome da agenda
);

-- Tabela Contato
CREATE TABLE Contato (
    id INT AUTO_INCREMENT PRIMARY KEY, -- Identificador único do contato
    nome VARCHAR(255) NOT NULL,        -- Nome do contato
    email VARCHAR(255) NOT NULL,       -- Email do contato
    telefone VARCHAR(15) NOT NULL,     -- Telefone do contato
    tipo_ctt VARCHAR(50) NOT NULL,     -- Tipo do contato (ex: FAMILIA, AMIGO, TRABALHO)
    agenda_id INT NOT NULL,            -- Chave estrangeira para associar à Agenda
    FOREIGN KEY (agenda_id) REFERENCES Agenda(id) ON DELETE CASCADE -- Relacionamento com a tabela Agenda
);
