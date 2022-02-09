CREATE TABLE despesa (
  id serial CONSTRAINT PKDESPESA PRIMARY KEY,
  descricao VARCHAR (200) NOT NULL,
  dtLancamento TIMESTAMP,
  dtDespesa TIMESTAMP,
  id_grupo integer,
  tipoDespesa VARCHAR(15)
);

ALTER TABLE despesa add CONSTRAINT FK1DESPESA FOREIGN KEY (id_grupo) REFERENCES grupo(id);
