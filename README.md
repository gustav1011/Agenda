#📒 Projeto: Sistema de Gerenciamento de Agenda

📌 Descrição

Este projeto consiste em um sistema de gerenciamento de agendas e contatos, permitindo a criação, armazenamento e consulta de agendas no banco de dados. Ele utiliza a arquitetura DAO para facilitar a interação com o banco de dados.

#🚀 Tecnologias Utilizadas

Java (versão 8 ou superior)

JDBC (para comunicação com o banco de dados)

MySQL (como banco de dados relacional)

##🔧 Funcionalidades

Criar uma nova agenda com múltiplos contatos.

Adicionar contatos à agenda durante a criação.

Buscar agendas no banco de dados:

Por ID

Por Nome

##🗂 Estrutura do Projeto

📂 src/ ├── 📁 app/ # Contém a classe principal (App.java) ├── 📁 DAO/ # Contém a classe de acesso ao banco de dados (AgendaDAO.java) ├── 📁 Modelo/ # Contém as classes de modelo (Agenda.java, Contato.java)

##🏗️ Configuração e Execução

1️⃣ Configurar o Banco de Dados

Criar o banco de dados no MySQL:

CREATE DATABASE agenda_db;

Criar a tabela da Agenda:

CREATE TABLE Agenda ( id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL );

Criar a tabela de Contatos:

CREATE TABLE Contato ( id INT AUTO_INCREMENT PRIMARY KEY, nome VARCHAR(255) NOT NULL, email VARCHAR(255), telefone VARCHAR(50), tipo VARCHAR(50), agenda_id INT, FOREIGN KEY (agenda_id) REFERENCES Agenda(id) );

2️⃣ Configurar a Conexão com o Banco

No arquivo ConnectionFactory.java, configure os detalhes da conexão:

private static final String URL = "jdbc:mysql://localhost:3306/agenda_db"; private static final String USER = "root"; private static final String PASSWORD = "sua_senha";

3️⃣ Compilar e Executar o Projeto

📌 Compilar o projeto:

javac -d bin src/**/*.java

📌 Executar o projeto:

java -cp bin app.App

🔄 Operações CRUD Implementadas

Operação

Método

Create (Inserção de uma nova agenda)

agendaDAO.insert(agenda)

Read (Busca por ID ou Nome)

agendaDAO.selectById(id, agenda) / agendaDAO.selectByName(nome, agenda)

Update (Em desenvolvimento)

Não implementado nesta versão

Delete (Em desenvolvimento)

Não implementado nesta versão

##📝 Como Usar

O programa perguntará se deseja adicionar uma nova agenda ao banco.

Caso a resposta seja "sim", ele solicitará o nome da agenda e a quantidade de contatos a serem adicionados.

Após a inserção, o programa perguntará se deseja buscar uma agenda já cadastrada.

O usuário poderá buscar por ID ou Nome.

##👨‍💻 Autor

Nome: Gustavo Munoz Dutra
