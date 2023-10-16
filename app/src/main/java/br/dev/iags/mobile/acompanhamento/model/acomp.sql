CREATE TABLE IF NOT EXISTS servico (
  idservico INT UNSIGNED NOT NULL,
  dservico VARCHAR(200) NOT NULL,
  PRIMARY KEY (idservico));

CREATE UNIQUE INDEX spServico_UNIQUE ON servico (idservico);

CREATE UNIQUE INDEX dservico_UNIQUE ON servico (dservico );

CREATE TABLE IF NOT EXISTS pedido (
  idPedido INT AUTO_INCREMENT,
  nrcpfcliente VARCHAR(11) NOT NULL,
  dtservico DATE NOT NULL,
  deinfservico VARCHAR(250) NULL,
  idservico INT UNSIGNED NOT NULL,
  PRIMARY KEY (idPedido, nrcpfcliente));

CREATE UNIQUE INDEX idanimal_UNIQUE ON pedido (idPedido ) ;

CREATE INDEX fk_pedido_servico_idx ON pedido (idservico ) ;