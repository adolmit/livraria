CREATE DATABASE IF NOT EXISTS livraria
CHARACTER SET utf8mb4
COLLATE utf8mb4_unicode_ci;

-- Usa o banco de dados
USE livraria;

CREATE TABLE livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255),
    categoria VARCHAR(255)
);

CREATE TABLE capitulo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    titulo VARCHAR(255),
    livro_id BIGINT,
    FOREIGN KEY (livro_id) REFERENCES livro(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE pagina (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    capitulo_id BIGINT,
    FOREIGN KEY (capitulo_id) REFERENCES capitulo(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

CREATE TABLE conteudo (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    texto TEXT,
    pagina_id BIGINT,
    FOREIGN KEY (pagina_id) REFERENCES pagina(id)
        ON DELETE CASCADE
        ON UPDATE CASCADE
);

insert into livro (titulo,autor,categoria) values("O Senhor dos Anéis", "J.R.R. Tolkien","Fantasia");
insert into capitulo (numero,titulo,livro_id) values(1, "O Mago",1);
insert into pagina (numero,capitulo_id) values(1,1);
insert into conteudo (texto,pagina_id) values("Texto pagina 1  capitulo 1 ...",1);
insert into pagina (numero,capitulo_id) values(2,1);
insert into conteudo (texto,pagina_id) values("Texto pagina 2 capitulo 1 ...",2);
insert into pagina (numero,capitulo_id) values(3,1);
insert into conteudo (texto,pagina_id) values("Texto pagina 3 capitulo 1 ...",3);

