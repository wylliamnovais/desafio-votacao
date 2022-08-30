-- DROP SCHEMA public;

CREATE SCHEMA public AUTHORIZATION postgres;

-- DROP SEQUENCE public.hibernate_sequence;

CREATE SEQUENCE public.hibernate_sequence
	INCREMENT BY 1
	MINVALUE 1
	MAXVALUE 9223372036854775807
	START 1
	CACHE 1
	NO CYCLE;-- public.associado definition

-- Drop table

-- DROP TABLE public.associado;

CREATE TABLE public.associado (
	id int8 NOT NULL,
	cpf varchar(255) NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT associado_pkey PRIMARY KEY (id)
);


-- public.pauta definition

-- Drop table

-- DROP TABLE public.pauta;

CREATE TABLE public.pauta (
	id int8 NOT NULL,
	data_fechamento timestamp NULL,
	descricao varchar(255) NULL,
	tempo_liberado int4 NULL,
	CONSTRAINT pauta_pkey PRIMARY KEY (id)
);


-- public.votacao definition

-- Drop table

-- DROP TABLE public.votacao;

CREATE TABLE public.votacao (
	id int8 NOT NULL,
	voto bool NOT NULL,
	associado int8 NULL,
	pauta int8 NULL,
	CONSTRAINT votacao_pkey PRIMARY KEY (id),
	CONSTRAINT fk8c303haekydgalh9gp2rw4pu0 FOREIGN KEY (associado) REFERENCES public.associado(id),
	CONSTRAINT fk9n6r9mbkj8836dk7t8kr4jqca FOREIGN KEY (pauta) REFERENCES public.pauta(id)
);
