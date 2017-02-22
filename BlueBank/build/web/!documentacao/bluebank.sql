-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 22-Fev-2017 às 22:11
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bluebank`
--
CREATE DATABASE IF NOT EXISTS `bluebank` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `bluebank`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `agencia`
--

CREATE TABLE `agencia` (
  `IDAGENCIA` int(11) NOT NULL,
  `AGENCIA` varchar(45) NOT NULL,
  `IDBANCO` int(11) NOT NULL,
  `LOCAL` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `agencia`
--

INSERT INTO `agencia` (`IDAGENCIA`, `AGENCIA`, `IDBANCO`, `LOCAL`) VALUES
(3, '7771', 1, 'GUARULHOS'),
(4, '7772', 1, 'GUARULHOS'),
(5, '1231', 2, 'SÃO PAULO'),
(6, '1232', 2, 'GUARULHOS');

-- --------------------------------------------------------

--
-- Estrutura da tabela `banco`
--

CREATE TABLE `banco` (
  `IDBANCO` int(11) NOT NULL,
  `BANCO` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `banco`
--

INSERT INTO `banco` (`IDBANCO`, `BANCO`) VALUES
(1, 'Banco do Brasil'),
(2, 'Blue Bank'),
(3, 'Bradesco'),
(4, 'Itau'),
(5, 'Santander');

-- --------------------------------------------------------

--
-- Estrutura da tabela `conta`
--

CREATE TABLE `conta` (
  `IDCONTA` int(11) NOT NULL,
  `CONTA` varchar(5) NOT NULL,
  `IDCORRENTISTA` int(11) NOT NULL,
  `IDAGENCIA` int(11) NOT NULL,
  `SENHA` varchar(45) DEFAULT NULL COMMENT 'Só possue senha quem pertence ao Blue Bank'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `conta`
--

INSERT INTO `conta` (`IDCONTA`, `CONTA`, `IDCORRENTISTA`, `IDAGENCIA`, `SENHA`) VALUES
(16, '0011', 1, 5, '1234'),
(17, '1021', 1, 3, NULL),
(18, '0022', 2, 6, '1234'),
(19, '1022', 3, 3, NULL),
(20, '1120', 4, 4, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `contato`
--

CREATE TABLE `contato` (
  `IDCONTATO` int(11) NOT NULL,
  `IDCONTA` int(11) NOT NULL,
  `IDCORRENTISTA` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `contato`
--

INSERT INTO `contato` (`IDCONTATO`, `IDCONTA`, `IDCORRENTISTA`) VALUES
(1, 16, 2),
(2, 16, 3),
(3, 16, 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `correntista`
--

CREATE TABLE `correntista` (
  `IDCORRENTISTA` int(11) NOT NULL,
  `NOME_CORRENTISTA` varchar(45) NOT NULL,
  `CPF` int(11) NOT NULL,
  `IMAGEM` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `correntista`
--

INSERT INTO `correntista` (`IDCORRENTISTA`, `NOME_CORRENTISTA`, `CPF`, `IMAGEM`) VALUES
(1, 'DAVI MELK', 2147483647, 'http://lorempixel.com/output/people-q-c-70-70-1.jpg'),
(2, 'LUCRECIA GRACIELLY', 2147483647, 'http://lorempixel.com/output/people-q-c-70-70-9.jpg'),
(3, 'JOANA RAIMUNDA', 2147483647, 'http://lorempixel.com/output/people-q-c-70-70-9.jpg'),
(4, 'MARIA CLEUSA', 2147483647, 'http://lorempixel.com/output/people-q-c-70-70-9.jpg');

-- --------------------------------------------------------

--
-- Estrutura da tabela `extrato`
--

CREATE TABLE `extrato` (
  `IDEXTRATO` int(11) NOT NULL,
  `IDCONTA` int(11) NOT NULL,
  `IDPROCEDIMENTO` int(11) NOT NULL,
  `DATA` date NOT NULL,
  `SALDO` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `extrato`
--

INSERT INTO `extrato` (`IDEXTRATO`, `IDCONTA`, `IDPROCEDIMENTO`, `DATA`, `SALDO`) VALUES
(6, 16, 4, '2017-02-22', '500.00'),
(7, 17, 4, '2017-02-22', '500.00'),
(8, 18, 4, '2017-02-22', '500.00'),
(9, 19, 4, '2017-02-22', '500.00'),
(10, 20, 4, '2017-02-22', '500.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `procedimento`
--

CREATE TABLE `procedimento` (
  `IDPROCEDIMENTO` int(11) NOT NULL,
  `PROCEDIMENTO` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `procedimento`
--

INSERT INTO `procedimento` (`IDPROCEDIMENTO`, `PROCEDIMENTO`) VALUES
(1, 'SAQUE'),
(2, 'TRANSFERENCIA'),
(3, 'PAGAMENTO'),
(4, 'DEPOSITO');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agencia`
--
ALTER TABLE `agencia`
  ADD PRIMARY KEY (`IDAGENCIA`),
  ADD KEY `FK_AGENCIA_BANCO_idx` (`IDBANCO`);

--
-- Indexes for table `banco`
--
ALTER TABLE `banco`
  ADD PRIMARY KEY (`IDBANCO`);

--
-- Indexes for table `conta`
--
ALTER TABLE `conta`
  ADD PRIMARY KEY (`IDCONTA`),
  ADD KEY `FK_CONTA_AGENCIA_idx` (`IDAGENCIA`),
  ADD KEY `FK_CONTA_CORRENTISTA_idx` (`IDCORRENTISTA`);

--
-- Indexes for table `contato`
--
ALTER TABLE `contato`
  ADD PRIMARY KEY (`IDCONTATO`),
  ADD KEY `FK_CONTATO_CONTA_idx` (`IDCONTA`),
  ADD KEY `FK_CONTATO_CORRENTISTA_idx` (`IDCORRENTISTA`);

--
-- Indexes for table `correntista`
--
ALTER TABLE `correntista`
  ADD PRIMARY KEY (`IDCORRENTISTA`);

--
-- Indexes for table `extrato`
--
ALTER TABLE `extrato`
  ADD PRIMARY KEY (`IDEXTRATO`),
  ADD KEY `FK_EXTRATO_CONTA_idx` (`IDCONTA`),
  ADD KEY `FK_EXTRATO_PROCEDIMENTO_idx` (`IDPROCEDIMENTO`);

--
-- Indexes for table `procedimento`
--
ALTER TABLE `procedimento`
  ADD PRIMARY KEY (`IDPROCEDIMENTO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agencia`
--
ALTER TABLE `agencia`
  MODIFY `IDAGENCIA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `banco`
--
ALTER TABLE `banco`
  MODIFY `IDBANCO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `conta`
--
ALTER TABLE `conta`
  MODIFY `IDCONTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `contato`
--
ALTER TABLE `contato`
  MODIFY `IDCONTATO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `correntista`
--
ALTER TABLE `correntista`
  MODIFY `IDCORRENTISTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `extrato`
--
ALTER TABLE `extrato`
  MODIFY `IDEXTRATO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `procedimento`
--
ALTER TABLE `procedimento`
  MODIFY `IDPROCEDIMENTO` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `agencia`
--
ALTER TABLE `agencia`
  ADD CONSTRAINT `FK_AGENCIA_BANCO` FOREIGN KEY (`IDBANCO`) REFERENCES `banco` (`IDBANCO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `conta`
--
ALTER TABLE `conta`
  ADD CONSTRAINT `FK_CONTA_AGENCIA` FOREIGN KEY (`IDAGENCIA`) REFERENCES `agencia` (`IDAGENCIA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CONTA_CORRENTISTA` FOREIGN KEY (`IDCORRENTISTA`) REFERENCES `correntista` (`IDCORRENTISTA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `contato`
--
ALTER TABLE `contato`
  ADD CONSTRAINT `FK_CONTATO_CONTA` FOREIGN KEY (`IDCONTA`) REFERENCES `conta` (`IDCONTA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_CONTATO_CORRENTISTA` FOREIGN KEY (`IDCORRENTISTA`) REFERENCES `correntista` (`IDCORRENTISTA`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `extrato`
--
ALTER TABLE `extrato`
  ADD CONSTRAINT `FK_EXTRATO_CONTA` FOREIGN KEY (`IDCONTA`) REFERENCES `conta` (`IDCONTA`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_EXTRATO_PROCEDIMENTO` FOREIGN KEY (`IDPROCEDIMENTO`) REFERENCES `procedimento` (`IDPROCEDIMENTO`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
