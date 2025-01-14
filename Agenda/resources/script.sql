-- Tabela Agenda
CREATE TABLE Agenda (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Tabela Pessoa
CREATE TABLE Pessoa (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    endereco VARCHAR(255),
    cpf CHAR(11) UNIQUE NOT NULL
);

-- Tabela Contato
CREATE TABLE Contato (
    id INT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    agenda_id INT NOT NULL,
    FOREIGN KEY (id) REFERENCES Pessoa(id) ON DELETE CASCADE,
    FOREIGN KEY (agenda_id) REFERENCES Agenda(id) ON DELETE CASCADE
);
    