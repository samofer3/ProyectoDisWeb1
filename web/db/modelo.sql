SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `proyecto` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

USE `proyecto` ;



-- -----------------------------------------------------

-- Table `proyecto`.`categoria`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`categoria` (

  `idCategoria` INT NOT NULL AUTO_INCREMENT ,

  `nombreCategoria` VARCHAR(45) NULL ,

  PRIMARY KEY (`idCategoria`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`articulo`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`articulo` (

  `idArticulo` INT NOT NULL AUTO_INCREMENT ,

  `nombreArticulo` VARCHAR(45) NOT NULL ,

  `descripcion` VARCHAR(200) NOT NULL ,

  `direccionImg` VARCHAR(50) NOT NULL ,

  `precio` FLOAT NOT NULL ,

  `categoriaIdCategoria` INT NOT NULL ,

  PRIMARY KEY (`idArticulo`) ,

  INDEX `fk_articulo_categoria` (`categoriaIdCategoria` ASC) ,

  CONSTRAINT `fk_articulo_categoria`

    FOREIGN KEY (`categoriaIdCategoria` )

    REFERENCES `proyecto`.`categoria` (`idCategoria` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`sucursal`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`sucursal` (

  `idSucursal` INT NOT NULL AUTO_INCREMENT ,

  `nombreSucursal` VARCHAR(45) NOT NULL ,

  `direccion` VARCHAR(100) NOT NULL ,

  `numeroTelefonico` INT(15) NOT NULL ,

  `email` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`idSucursal`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`comentarios`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`comentarios` (

  `idComentarios` INT NOT NULL AUTO_INCREMENT ,

  `comentario` VARCHAR(300) NOT NULL ,

  `autor` VARCHAR(45) NOT NULL ,

  `articuloIdArticulo` INT NOT NULL ,

  PRIMARY KEY (`idComentarios`) ,

  INDEX `fk_comentarios_articulo1` (`articuloIdArticulo` ASC) ,

  CONSTRAINT `fk_comentarios_articulo1`

    FOREIGN KEY (`articuloIdArticulo` )

    REFERENCES `proyecto`.`articulo` (`idArticulo` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`usuario`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`usuario` (

  `idUsuario` INT NOT NULL AUTO_INCREMENT ,

  `nombreUsuario` VARCHAR(40) NOT NULL ,

  `password` VARCHAR(20) NOT NULL ,

  `permiso` CHAR NOT NULL ,

  `sucursalIdSucursal` INT NOT NULL ,

  PRIMARY KEY (`idUsuario`) ,

  INDEX `fk_usuario_sucursal1` (`sucursalIdSucursal` ASC) ,

  CONSTRAINT `fk_usuario_sucursal1`

    FOREIGN KEY (`sucursalIdSucursal` )

    REFERENCES `proyecto`.`sucursal` (`idSucursal` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`empresa`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`empresa` (

  `nombreEmpresa` VARCHAR(80) NOT NULL ,

  `fondoColor` VARCHAR(10) NULL ,

  `fondoImagen` VARCHAR(50) NULL DEFAULT 'img/Fondo.png' ,

   `orientacion` VARCHAR(10) NOT NULL ,

  PRIMARY KEY (`nombreEmpresa`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`articuloSucursal`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`articuloSucursal` (

  `unidad` INT NOT NULL ,

  `articuloIdArticulo` INT NOT NULL ,

  `sucursalIdSucursal` INT NOT NULL ,

  INDEX `fk_articulo_has_sucursal_sucursal1` (`sucursalIdSucursal` ASC) ,

  INDEX `fk_articulo_has_sucursal_articulo1` (`articuloIdArticulo` ASC) ,

  PRIMARY KEY (`articuloIdArticulo`, `sucursalIdSucursal`) ,

  CONSTRAINT `fk_articulo_has_sucursal_articulo1`

    FOREIGN KEY (`articuloIdArticulo` )

    REFERENCES `proyecto`.`articulo` (`idArticulo` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_articulo_has_sucursal_sucursal1`

    FOREIGN KEY (`sucursalIdSucursal` )

    REFERENCES `proyecto`.`sucursal` (`idSucursal` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

