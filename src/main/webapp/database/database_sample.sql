-- Tabela de desenvolvedores
CREATE TABLE `prj_desenvolvedores` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome_completo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gipv4c5ya15cijook44n8uht9` (`nome_completo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Tabela de projetos
CREATE TABLE `prj_projetos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_d051y2a9qok79mo0fxpt6amu8` (`descricao`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Tabela de tarefas
CREATE TABLE `prj_tarefas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `data_conclusao` timestamp NULL DEFAULT NULL,
  `data_criacao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `descricao` varchar(255) DEFAULT NULL,
  `observacoes` text,
  `status` tinyint(1) NOT NULL,
  `id_desenvolvedor` bigint(20) DEFAULT NULL,
  `id_projeto` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1qx5g1f8gfembimb900ioiahn` (`id_desenvolvedor`),
  KEY `FKm1xwlpf1fnl7l8rphtt2cwt4j` (`id_projeto`),
  CONSTRAINT `FK1qx5g1f8gfembimb900ioiahn` FOREIGN KEY (`id_desenvolvedor`) REFERENCES `prj_desenvolvedores` (`id`),
  CONSTRAINT `FKm1xwlpf1fnl7l8rphtt2cwt4j` FOREIGN KEY (`id_projeto`) REFERENCES `prj_projetos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;