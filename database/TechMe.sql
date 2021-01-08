create database TeachMe;
use TeachMe;

CREATE TABLE Instituicao (
  CdInstituicao INT(11) NOT NULL,
  NmInstituicao VARCHAR(200) NOT NULL,
  Endereco VARCHAR(200) NOT NULL,
  PRIMARY KEY (`CdInstituicao`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE Usuario(
  CdUsuario INT(11) NOT NULL,
  `NmUsuario` VARCHAR(200) NOT NULL,
  `Email` VARCHAR(200) NOT NULL,
  `Login` VARCHAR(200) NOT NULL,
  `Senha` VARCHAR(100) NOT NULL,
  `DtNascimento` DATE NOT NULL,
  `Avaliacao` DECIMAL(3,2) NULL DEFAULT NULL,
  `Descricao` VARCHAR(240) NULL DEFAULT NULL,
  `Foto` BLOB NULL DEFAULT NULL,
  `CdInstituicao` INT(11) NOT NULL,
  PRIMARY KEY (`CdUsuario`),
  UNIQUE INDEX `Login_UNIQUE` (`Login` ASC),
  INDEX `fk_Usuario_Instituicao_idx` (`CdInstituicao` ASC),
  CONSTRAINT `fk_Usuario_Instituicao`
    FOREIGN KEY (`CdInstituicao`)
    REFERENCES `mydb`.`Instituicao` (`CdInstituicao`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE Tipo(
  `CdTipo` INT(11) NOT NULL,
  `NmTipo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`CdTipo`),
  UNIQUE INDEX `NmTipo_UNIQUE` (`NmTipo` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE Disciplina(
  `CdDisciplina` INT(11) NOT NULL,
  `NmDisciplina` VARCHAR(100) NOT NULL,
  `CdTipo` INT(11) NOT NULL,
  PRIMARY KEY (`CdDisciplina`),
  UNIQUE INDEX `NmDisciplina_UNIQUE` (`NmDisciplina` ASC),
  INDEX `fk_Disciplina_Tipo1_idx` (`CdTipo` ASC),
  CONSTRAINT `fk_Disciplina_Tipo1`
    FOREIGN KEY (`CdTipo`)
    REFERENCES `mydb`.`Tipo` (`CdTipo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE Anuncio(
  `CdAnuncio` INT(11) NOT NULL,
  `QtdAlunos` INT(11) NOT NULL,
  `Descricao` VARCHAR(200) NULL DEFAULT NULL,
  `CdDisciplina` INT(11) NOT NULL,
  `CdUsuario_Professor` INT(11) NOT NULL,
  `Valor` DECIMAL(3,2) NOT NULL,
  PRIMARY KEY (`CdAnuncio`),
  INDEX `fk_Anuncio_Disciplina1_idx` (`CdDisciplina` ASC),
  INDEX `fk_Anuncio_Usuario1_idx` (`CdUsuario_Professor` ASC),
  CONSTRAINT `fk_Anuncio_Disciplina1`
    FOREIGN KEY (`CdDisciplina`)
    REFERENCES `mydb`.`Disciplina` (`CdDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Anuncio_Usuario1`
    FOREIGN KEY (`CdUsuario_Professor`)
    REFERENCES `mydb`.`Usuario` (`CdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE Aula(
  `CdAula` INT(11) NOT NULL,
  `CdUsuario_Aluno` INT(11) NOT NULL,
  `CdAnuncio` INT(11) NOT NULL,
  `Horario` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`CdAula`),
  INDEX `fk_Aula_Usuario1_idx` (`CdUsuario_Aluno` ASC),
  INDEX `fk_Aula_Anuncio1_idx` (`CdAnuncio` ASC),
  CONSTRAINT `fk_Aula_Usuario1`
    FOREIGN KEY (`CdUsuario_Aluno`)
    REFERENCES `mydb`.`Usuario` (`CdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Aula_Anuncio1`
    FOREIGN KEY (`CdAnuncio`)
    REFERENCES `mydb`.`Anuncio` (`CdAnuncio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE Disciplina_Leciona(
  `CdDisciplina` INT(11) NOT NULL,
  `CdUsuario_Professor` INT(11) NOT NULL,
  PRIMARY KEY (`CdDisciplina`, `CdUsuario_Professor`),
  INDEX `fk_Disciplina_has_Usuario_Usuario1_idx` (`CdUsuario_Professor` ASC),
  INDEX `fk_Disciplina_has_Usuario_Disciplina1_idx` (`CdDisciplina` ASC),
  CONSTRAINT `fk_Disciplina_has_Usuario_Disciplina1`
    FOREIGN KEY (`CdDisciplina`)
    REFERENCES `mydb`.`Disciplina` (`CdDisciplina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Disciplina_has_Usuario_Usuario1`
    FOREIGN KEY (`CdUsuario_Professor`)
    REFERENCES `mydb`.`Usuario` (`CdUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;	
