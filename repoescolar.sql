-- MySQL dump 10.13  Distrib 5.6.40, for macos10.13 (x86_64)
--
-- Host: localhost    Database: repoescolar
-- ------------------------------------------------------
-- Server version	5.6.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Academia`
--

DROP TABLE IF EXISTS `Academia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Academia` (
  `idAcademias` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `EscuelaFK` int(11) NOT NULL,
  `JefeAcademiaFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAcademias`),
  KEY `fk_Academia_Escuela1_idx` (`EscuelaFK`),
  KEY `fk_Academia_JefeAcademia1_idx` (`JefeAcademiaFK`),
  CONSTRAINT `fk_Academia_Escuela1` FOREIGN KEY (`EscuelaFK`) REFERENCES `Escuela` (`idEscuela`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Academia_JefeAcademia1` FOREIGN KEY (`JefeAcademiaFK`) REFERENCES `JefeAcademia` (`idJefeAcademia`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Academia`
--

LOCK TABLES `Academia` WRITE;
/*!40000 ALTER TABLE `Academia` DISABLE KEYS */;
/*!40000 ALTER TABLE `Academia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Administrador`
--

DROP TABLE IF EXISTS `Administrador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administrador` (
  `idAdministrador` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioFK` int(11) NOT NULL,
  PRIMARY KEY (`idAdministrador`),
  KEY `fk_Administrador_Usuario1_idx` (`UsuarioFK`),
  CONSTRAINT `fk_Administrador_Usuario1` FOREIGN KEY (`UsuarioFK`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrador`
--

LOCK TABLES `Administrador` WRITE;
/*!40000 ALTER TABLE `Administrador` DISABLE KEYS */;
INSERT INTO `Administrador` VALUES (1,1);
/*!40000 ALTER TABLE `Administrador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Administrativo`
--

DROP TABLE IF EXISTS `Administrativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Administrativo` (
  `idAdministrativo` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioFK` int(11) NOT NULL,
  PRIMARY KEY (`idAdministrativo`),
  KEY `fk_Administrativo_Usuario1_idx` (`UsuarioFK`),
  CONSTRAINT `fk_Administrativo_Usuario1` FOREIGN KEY (`UsuarioFK`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Administrativo`
--

LOCK TABLES `Administrativo` WRITE;
/*!40000 ALTER TABLE `Administrativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Administrativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Alumno`
--

DROP TABLE IF EXISTS `Alumno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Alumno` (
  `idAlumno` int(11) NOT NULL AUTO_INCREMENT,
  `boleta` varchar(15) NOT NULL,
  `UsuarioFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAlumno`),
  KEY `fk_Alumno_Usuario1_idx` (`UsuarioFK`),
  CONSTRAINT `fk_Alumno_Usuario1` FOREIGN KEY (`UsuarioFK`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Alumno`
--

LOCK TABLES `Alumno` WRITE;
/*!40000 ALTER TABLE `Alumno` DISABLE KEYS */;
/*!40000 ALTER TABLE `Alumno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Archivo`
--

DROP TABLE IF EXISTS `Archivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Archivo` (
  `idArchivo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `fechaSubida` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `MateriasFK` int(11) NOT NULL,
  `ProfesorFK` int(11) NOT NULL,
  PRIMARY KEY (`idArchivo`),
  KEY `fk_Archivo_Materias1_idx` (`MateriasFK`),
  KEY `fk_Archivo_Profesor1_idx` (`ProfesorFK`),
  CONSTRAINT `fk_Archivo_Materias1` FOREIGN KEY (`MateriasFK`) REFERENCES `Materias` (`idMaterias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Archivo_Profesor1` FOREIGN KEY (`ProfesorFK`) REFERENCES `Profesor` (`idProfesor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Archivo`
--

LOCK TABLES `Archivo` WRITE;
/*!40000 ALTER TABLE `Archivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `Archivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Clase`
--

DROP TABLE IF EXISTS `Clase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Clase` (
  `idClase` int(11) NOT NULL AUTO_INCREMENT,
  `AlumnoFK` int(11) NOT NULL,
  `CursoFK` int(11) NOT NULL,
  PRIMARY KEY (`idClase`),
  KEY `fk_Clase_Alumno1_idx` (`AlumnoFK`),
  KEY `fk_Clase_Curso1_idx` (`CursoFK`),
  CONSTRAINT `fk_Clase_Alumno1` FOREIGN KEY (`AlumnoFK`) REFERENCES `Alumno` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Clase_Curso1` FOREIGN KEY (`CursoFK`) REFERENCES `Curso` (`idCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Clase`
--

LOCK TABLES `Clase` WRITE;
/*!40000 ALTER TABLE `Clase` DISABLE KEYS */;
/*!40000 ALTER TABLE `Clase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Curso`
--

DROP TABLE IF EXISTS `Curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Curso` (
  `idCurso` int(11) NOT NULL AUTO_INCREMENT,
  `MateriasFK` int(11) NOT NULL,
  `ProfesorFK` int(11) NOT NULL,
  `GruposFK` int(11) NOT NULL,
  PRIMARY KEY (`idCurso`),
  KEY `fk_Materias_has_Profesor_Profesor1_idx` (`ProfesorFK`),
  KEY `fk_Materias_has_Profesor_Materias1_idx` (`MateriasFK`),
  KEY `fk_Curso_Grupos1_idx` (`GruposFK`),
  CONSTRAINT `fk_Curso_Grupos1` FOREIGN KEY (`GruposFK`) REFERENCES `Grupos` (`idGrupo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materias_has_Profesor_Materias1` FOREIGN KEY (`MateriasFK`) REFERENCES `Materias` (`idMaterias`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Materias_has_Profesor_Profesor1` FOREIGN KEY (`ProfesorFK`) REFERENCES `Profesor` (`idProfesor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Curso`
--

LOCK TABLES `Curso` WRITE;
/*!40000 ALTER TABLE `Curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `Curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Escuela`
--

DROP TABLE IF EXISTS `Escuela`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Escuela` (
  `idEscuela` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `extension` varchar(5) NOT NULL,
  `sitioWeb` varchar(80) NOT NULL,
  `referencia` varchar(10) NOT NULL,
  `claveAdmin` int(11) NOT NULL,
  `claveProfesor` int(11) NOT NULL,
  PRIMARY KEY (`idEscuela`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Escuela`
--

LOCK TABLES `Escuela` WRITE;
/*!40000 ALTER TABLE `Escuela` DISABLE KEYS */;
/*!40000 ALTER TABLE `Escuela` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Grupos`
--

DROP TABLE IF EXISTS `Grupos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Grupos` (
  `idGrupo` int(11) NOT NULL AUTO_INCREMENT,
  `grupo` varchar(6) NOT NULL,
  `EscuelaFK` int(11) NOT NULL,
  PRIMARY KEY (`idGrupo`),
  KEY `fk_Grupos_Escuela1_idx` (`EscuelaFK`),
  CONSTRAINT `fk_Grupos_Escuela1` FOREIGN KEY (`EscuelaFK`) REFERENCES `Escuela` (`idEscuela`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Grupos`
--

LOCK TABLES `Grupos` WRITE;
/*!40000 ALTER TABLE `Grupos` DISABLE KEYS */;
/*!40000 ALTER TABLE `Grupos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `JefeAcademia`
--

DROP TABLE IF EXISTS `JefeAcademia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `JefeAcademia` (
  `idJefeAcademia` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioFK` int(11) NOT NULL,
  PRIMARY KEY (`idJefeAcademia`),
  KEY `fk_JefeAcademia_Usuario1_idx` (`UsuarioFK`),
  CONSTRAINT `fk_JefeAcademia_Usuario1` FOREIGN KEY (`UsuarioFK`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `JefeAcademia`
--

LOCK TABLES `JefeAcademia` WRITE;
/*!40000 ALTER TABLE `JefeAcademia` DISABLE KEYS */;
/*!40000 ALTER TABLE `JefeAcademia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Materias`
--

DROP TABLE IF EXISTS `Materias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Materias` (
  `idMaterias` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `nivel` int(11) NOT NULL,
  `AcademiaFK` int(11) NOT NULL,
  PRIMARY KEY (`idMaterias`),
  KEY `fk_Materias_Academia1_idx` (`AcademiaFK`),
  CONSTRAINT `fk_Materias_Academia1` FOREIGN KEY (`AcademiaFK`) REFERENCES `Academia` (`idAcademias`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Materias`
--

LOCK TABLES `Materias` WRITE;
/*!40000 ALTER TABLE `Materias` DISABLE KEYS */;
/*!40000 ALTER TABLE `Materias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Persona`
--

DROP TABLE IF EXISTS `Persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Persona` (
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(45) NOT NULL,
  PRIMARY KEY (`idPersona`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Persona`
--

LOCK TABLES `Persona` WRITE;
/*!40000 ALTER TABLE `Persona` DISABLE KEYS */;
INSERT INTO `Persona` VALUES (1,'Andrés','Ortigoza Campos','57296000','direccion_escom@ipn.mx');
/*!40000 ALTER TABLE `Persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profesor`
--

DROP TABLE IF EXISTS `Profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profesor` (
  `idProfesor` int(11) NOT NULL AUTO_INCREMENT,
  `UsuarioFk` int(11) NOT NULL,
  PRIMARY KEY (`idProfesor`),
  KEY `fk_Profesor_Usuario1_idx` (`UsuarioFk`),
  CONSTRAINT `fk_Profesor_Usuario1` FOREIGN KEY (`UsuarioFk`) REFERENCES `Usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profesor`
--

LOCK TABLES `Profesor` WRITE;
/*!40000 ALTER TABLE `Profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `Profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(15) NOT NULL,
  `password` int(25) NOT NULL,
  `PersonaFK` int(11) NOT NULL,
  `EscuelaFK` int(11) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  KEY `fk_Usuario_Persona_idx` (`PersonaFK`),
  KEY `fk_Usuario_Escuela1_idx` (`EscuelaFK`),
  CONSTRAINT `fk_Usuario_Escuela1` FOREIGN KEY (`EscuelaFK`) REFERENCES `Escuela` (`idEscuela`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Persona` FOREIGN KEY (`PersonaFK`) REFERENCES `Persona` (`idPersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (1,'2015000000',-1194395094,1,NULL);
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-20 15:49:58
