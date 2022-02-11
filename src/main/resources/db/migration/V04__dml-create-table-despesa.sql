CREATE TABLE despesa (
  id serial CONSTRAINT PKDESPESA PRIMARY KEY,
  descricao VARCHAR (200) NOT NULL,
  dt_lancamento TIMESTAMP,
  dt_despesa TIMESTAMP,
  id_grupo integer,
  ocorrencia_despesa VARCHAR(15),
  id_usuario integer,
  valor decimal(12,2)
);

ALTER TABLE despesa add CONSTRAINT FK1DESPESA FOREIGN KEY (id_grupo) REFERENCES grupo(id);
ALTER TABLE despesa add CONSTRAINT FK2DESPESA FOREIGN KEY (id_usuario) REFERENCES usuario(id);
