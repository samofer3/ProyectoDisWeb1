SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;

SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE DATABASE proyecto DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE proyecto;



-- -----------------------------------------------------

-- Table `proyecto`.`categoria`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`categoria` (

  `id_categoria` INT NOT NULL AUTO_INCREMENT ,

  `nombre_categoria` VARCHAR(45) NULL ,

  PRIMARY KEY (`id_categoria`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`articulo`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`articulo` (

  `id_articulo` INT NOT NULL AUTO_INCREMENT ,

  `nombre_articulo` VARCHAR(45) NOT NULL ,

  `descripcion` VARCHAR(200) NOT NULL ,

  `direccion_img` VARCHAR(50) NOT NULL ,

  `precio` FLOAT NOT NULL ,

  `categoria_id_categoria` INT NOT NULL ,

  PRIMARY KEY (`id_articulo`) ,

  INDEX `fk_articulo_categoria` (`categoria_id_categoria` ASC) ,

  CONSTRAINT `fk_articulo_categoria`

    FOREIGN KEY (`categoria_id_categoria` )

    REFERENCES `proyecto`.`categoria` (`id_categoria` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`sucursal`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`sucursal` (

  `id_sucursal` INT NOT NULL AUTO_INCREMENT ,

  `nombre_sucursal` VARCHAR(45) NOT NULL ,

  `direccion` VARCHAR(100) NOT NULL ,

  `numero_telefonico` INT(15) NOT NULL ,

  `email` VARCHAR(45) NOT NULL ,

  PRIMARY KEY (`id_sucursal`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`comentarios`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`comentarios` (

  `id_comentarios` INT NOT NULL AUTO_INCREMENT ,

  `comentario` VARCHAR(300) NOT NULL ,

  `autor` VARCHAR(45) NOT NULL ,

  `articulo_id_articulo` INT NOT NULL ,

  PRIMARY KEY (`id_comentarios`) ,

  INDEX `fk_comentarios_articulo1` (`articulo_id_articulo` ASC) ,

  CONSTRAINT `fk_comentarios_articulo1`

    FOREIGN KEY (`articulo_id_articulo` )

    REFERENCES `proyecto`.`articulo` (`id_articulo` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`usuario`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`usuario` (

  `id_usuario` INT NOT NULL AUTO_INCREMENT ,

  `nombre_usuario` VARCHAR(40) NOT NULL ,

  `password` VARCHAR(20) NOT NULL ,

  `permiso` CHAR NOT NULL ,

  `sucursal_id_sucursal` INT NOT NULL ,

  PRIMARY KEY (`id_usuario`) ,

  INDEX `fk_usuario_sucursal1` (`sucursal_id_sucursal` ASC) ,

  CONSTRAINT `fk_usuario_sucursal1`

    FOREIGN KEY (`sucursal_id_sucursal` )

    REFERENCES `proyecto`.`sucursal` (`id_sucursal` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`empresa`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`empresa` (

  `nombre_empresa` VARCHAR(80) NOT NULL ,

  `fondo_color` VARCHAR(10) NULL ,

  `fondo_imagen` VARCHAR(50) NULL DEFAULT 'img/Fondo.png' ,

  PRIMARY KEY (`nombre_empresa`) )

ENGINE = InnoDB;





-- -----------------------------------------------------

-- Table `proyecto`.`articulo_sucursal`

-- -----------------------------------------------------

CREATE  TABLE IF NOT EXISTS `proyecto`.`articulo_sucursal` (

  `unidad` INT NOT NULL ,

  `articulo_id_articulo` INT NOT NULL ,

  `sucursal_id_sucursal` INT NOT NULL ,

  INDEX `fk_articulo_has_sucursal_sucursal1` (`sucursal_id_sucursal` ASC) ,

  INDEX `fk_articulo_has_sucursal_articulo1` (`articulo_id_articulo` ASC) ,

  PRIMARY KEY (`articulo_id_articulo`, `sucursal_id_sucursal`) ,

  CONSTRAINT `fk_articulo_has_sucursal_articulo1`

    FOREIGN KEY (`articulo_id_articulo` )

    REFERENCES `proyecto`.`articulo` (`id_articulo` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION,

  CONSTRAINT `fk_articulo_has_sucursal_sucursal1`

    FOREIGN KEY (`sucursal_id_sucursal` )

    REFERENCES `proyecto`.`sucursal` (`id_sucursal` )

    ON DELETE NO ACTION

    ON UPDATE NO ACTION)

ENGINE = InnoDB;







SET SQL_MODE=@OLD_SQL_MODE;

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

