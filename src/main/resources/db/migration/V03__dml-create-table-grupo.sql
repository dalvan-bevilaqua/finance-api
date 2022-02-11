CREATE TABLE grupo (
  id serial CONSTRAINT PKGRUPO PRIMARY KEY,
  descricao VARCHAR (200) NOT NULL,
  cor VARCHAR(15) NOT NULL,
  id_usuario integer
);
ALTER TABLE grupo add CONSTRAINT FK1GRUPO FOREIGN KEY (id_usuario) REFERENCES usuario(id);
