CREATE TABLE investimento (
  id serial CONSTRAINT PKINVESTIMENTO PRIMARY KEY,
  descricao VARCHAR (200) NOT NULL,
  entidade VARCHAR (200) NOT NULL,
  dt_lancamento TIMESTAMP,
  id_usuario integer,
  valor decimal(12,2),
  per_recebido decimal(12,2)
);

ALTER TABLE investimento add CONSTRAINT FK2INVESTIMENTOFOREIGN FOREIGN KEY (id_usuario) REFERENCES usuario(id);
