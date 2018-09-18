-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: localhost    Database: ee_lab
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `14031242`
--

DROP TABLE IF EXISTS `14031242`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `14031242` (
  `comp_name` varchar(30) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `14031242`
--

LOCK TABLES `14031242` WRITE;
/*!40000 ALTER TABLE `14031242` DISABLE KEYS */;
/*!40000 ALTER TABLE `14031242` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `14031243`
--

DROP TABLE IF EXISTS `14031243`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `14031243` (
  `comp_name` varchar(30) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `14031243`
--

LOCK TABLES `14031243` WRITE;
/*!40000 ALTER TABLE `14031243` DISABLE KEYS */;
/*!40000 ALTER TABLE `14031243` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `14031244`
--

DROP TABLE IF EXISTS `14031244`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `14031244` (
  `comp_name` varchar(30) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `14031244`
--

LOCK TABLES `14031244` WRITE;
/*!40000 ALTER TABLE `14031244` DISABLE KEYS */;
INSERT INTO `14031244` VALUES ('Function Generators VC2002','2017-12-25','2017-12-29'),('Function Generators VC2002','2017-12-25','2017-12-29'),('DSP Starter Kit Board DSK6713','2017-12-25','2017-12-28');
/*!40000 ALTER TABLE `14031244` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comp_list`
--

DROP TABLE IF EXISTS `comp_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comp_list` (
  `Comp_name` varchar(100) DEFAULT NULL,
  `type` varchar(50) NOT NULL,
  `status` varchar(30) NOT NULL,
  `quantity` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comp_list`
--

LOCK TABLES `comp_list` WRITE;
/*!40000 ALTER TABLE `comp_list` DISABLE KEYS */;
INSERT INTO `comp_list` VALUES ('Analogue and Digital Trainer M21-7000','analogue ','consume',12),('Oscilloscopes MOS 620-H','analogue ','consume',3),('Function Generators VC2002','analogue ','consume',0),('Power Supplies  PS-305D','analogue ','consume',55),('Communicaiton Trainers CT-3000 ','analogue ','non',5),('Microwave Kits ','analogue ','non',6),('Digital Multimeters','analogue ','non',5),('Resistor Box','analogue ','non',4),('Analogue Amperemeter ','analogue ','non',2),('Tool Kit Rapid','analogue ','non',5),('Mini Drill Machine for PCB','analogue ','non',4),('DC Motor','analogue ','non',6),('Solder with stands','analogue ','non',5),('Electric Desolder ','analogue ','non',3),('FPGA Kits NEXYS 3 Board','digital_electronic','non',2),('FPGA Board ALTERA DE1-SoC','digital_electronic','non',8),('Steper Motor','digital_electronic','non',5),('Microcontroller Board 8051 ATMEL','digital_electronic','non',7),('Arduino UNO','digital_electronic','non',5),('Servo Motors','digital_electronic','consume',10),('PLC Module  FATEK','digital_electronic','consume',6),('Development Board EBO83-00-I ','digital_electronic','consume',54),('LCD (1602A)','digital_electronic','consume',3),('LCD (128*128)','digital_electronic','consume',2),('LCD (2.8TFT LCD SHIELD )','digital_electronic','non',2),('Temperature Sensor DHT11','digital_electronic','non',4),('WiFi Module ESP8266','digital_electronic','non',5),('RTC Module ','digital_electronic','non',6),('SD Card Module','digital_electronic','non',8),('Key Pad','digital_electronic','non',0),('Bluetooth Module HC05','digital_electronic','non',7),('E-blocks Arduino Uno Shield','digital_electronic','non',9),('Desktop Computers ','digital_electronic','non',8),('Analogue and Digital Trainers M21-7000','digital_electronic','non',7),('Power Supplies Dual MATRiX MPS-3003L-3','digital_electronic','non',6),('Digital Multimeters Fluke','digital_electronic','non',5),('Digital Oscilloscope RIGOL DS1052E','digital_electronic','non',5),('PIC Development Board','digital_electronic','non',4),('FPGA Kits ATLYS Board','digital_electronic','non',3),('FPGA Board ALTERA DE1-SoC  ','digital_signal','consume',3),('DSP Starter Kit Board DSK6713','digital_signal','consume',1),('Motor, Electric Traction and Electrical Control Trainer YL-195','physics_robotics','consume',13),('Lego Robot Kits ','physics_robotics','consume',3),('Arduino Kits ','physics_robotics','consume',4),('Zumo Robots ','physics_robotics','consume',12),('Diffraction Grating and Spectrometer ','physics_robotics','consume',5),('Field Plotting Apparatus','physics_robotics','consume',6),('Spectrometer','physics_robotics','non',7),('Travelling Microscope Apparatus','physics_robotics','non',8),('Photo Electric Effect Apparatus','physics_robotics','non',9),('E/M Apparatus','physics_robotics','non',9),('Kund\'s Tube','physics_robotics','non',8),('Sextant Apparatus','physics_robotics','non',7),('Pullies','physics_robotics','non',12),('Stop Watch','physics_robotics','non',7),('Gravisand\'s Apparatus','physics_robotics','non',6),('Force Table','physics_robotics','non',5),('Organic Student Set','physics_robotics','non',5),('Pendulum Bob','physics_robotics','non',4),('500 g Weight Box','physics_robotics','non',3),('Spring Balance','physics_robotics','non',3),('Stand ','physics_robotics','non',3),('Mass Spring ','physics_robotics','non',4),('Digital Multimeter','physics_robotics','non',5),('Ampere Meter','physics_robotics','non',6),('Melde\'s Apparatus','physics_robotics','non',7),('Digital Micrometer','physics_robotics','non',8),('Vernier Caliper (Digital)','physics_robotics','non',8),('Vernier caliper (Analogue)','physics_robotics','consume',8),('Hall Effect Apparatus','physics_robotics','consume',8),('Centre Lathe Machine','eng_workshop','consume',7),('Drilling Machine with Stand','eng_workshop','consume',7),('Fitting Stations','eng_workshop','consume',6),('Carpentry Stations ','eng_workshop','consume',6),('Electrician Tool Kits 59-PC ','eng_workshop','consume',5),('Maintenance Kit PK-2087B','eng_workshop','consume',1),('Electron Jetech Tool 181054/JEB-E54','eng_workshop','non',4),('Micrometer','eng_workshop','non',4),('Digital Vernier caliper','eng_workshop','non',3),('Chisels Set ','eng_workshop','non',3),('Mini Drill Machines','eng_workshop','non',12),('Hand Drill Machine','eng_workshop','non',3),('Grinder','eng_workshop','non',4),('Iron Planner','eng_workshop','non',5),('Carpentry Vise','eng_workshop','non',6),('Electrical Wiring Panels ','eng_workshop','non',7),('Electrical Wiring Boards','eng_workshop','non',7),('Digital Multimeter','eng_workshop','non',2),('Hacksaw Frame','eng_workshop','non',8),('Woodsaw','eng_workshop','non',8),('Long Nose Plier','eng_workshop','non',8),('Combination Plier','eng_workshop','consume',6),('wire Cutter','eng_workshop','consume',6),('Try square 6\",8\",10\"','eng_workshop','consume',6),('Spanner Set','eng_workshop','consume',5),('Measuring Tape 7.5m','eng_workshop','non',4),('Adjustable Rench ','eng_workshop','non',4),('Allen Key Set','eng_workshop','non',3),('Steel Rule','eng_workshop','non',3),('Paper Cutter','eng_workshop','non',3),('Center Punch','eng_workshop','non',4),('Hammer Claw Type','eng_workshop','non',4),('Soldering Iron','eng_workshop','non',5),('Taper Handle','eng_workshop','non',6),('Reamer','eng_workshop','non',7),('Vise 5\"+4\"','eng_workshop','non',12),('Hammer Cross Pin','eng_workshop','non',2),('Paint Brush','eng_workshop','non',16),('Pincer','eng_workshop','non',4);
/*!40000 ALTER TABLE `comp_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requestedComp`
--

DROP TABLE IF EXISTS `requestedComp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `requestedComp` (
  `user_id` varchar(10) DEFAULT NULL,
  `comp_name` varchar(30) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requestedComp`
--

LOCK TABLES `requestedComp` WRITE;
/*!40000 ALTER TABLE `requestedComp` DISABLE KEYS */;
INSERT INTO `requestedComp` VALUES ('14031244','Hand Drill Machine','non'),('14031244','Servo Motors','consume');
/*!40000 ALTER TABLE `requestedComp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `roll` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`roll`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('14031242','1234'),('14031244','1234');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_account`
--

DROP TABLE IF EXISTS `t_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_account` (
  `stud_name` varchar(30) NOT NULL,
  `comp_name` varchar(30) NOT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_account`
--

LOCK TABLES `t_account` WRITE;
/*!40000 ALTER TABLE `t_account` DISABLE KEYS */;
INSERT INTO `t_account` VALUES ('14031244','Function Generators VC2002','2017-12-25','2017-12-29'),('14031244','Function Generators VC2002','2017-12-25','2017-12-29'),('14031244','DSP Starter Kit Board DSK6713','2017-12-25','2017-12-28');
/*!40000 ALTER TABLE `t_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `Email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`Email`(30))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('admin@namal.edu.pk','12345'),('amir.khurrum@namal.edu.pk','12345'),('farooq@namal.edu.pk','12345');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tokens`
--

DROP TABLE IF EXISTS `tokens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tokens` (
  `user_name` varchar(100) NOT NULL,
  `token` varchar(500) NOT NULL,
  PRIMARY KEY (`user_name`(30))
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tokens`
--

LOCK TABLES `tokens` WRITE;
/*!40000 ALTER TABLE `tokens` DISABLE KEYS */;
INSERT INTO `tokens` VALUES ('',''),('14031242','dP0mgU2vm8k:APA91bEuEcq79P7HbV2dq_UFXaCJV98nrLQGHQ5i4Yv--w8xAHBGNyoxPVCsRNsNbfbnjodvpZr35JBKjbyzoOduCRrtnVkQ8xzpeExOwXOyngCsnAG7C8VqgVAp8OPhxbB6DXbbCdat'),('14031244','fxL-16Zc8NY:APA91bFDOWotI5cQTisDlmD8-gPFArp3ayNAcQ3QmGo7gd1TKO8XFaD39AoSYQu-Dw4kRTyw1W2FHjzJ-vzoOgkxZM1qi4xASg45H9IhrlsQ57W3unt9FeX6q_ev-BW_zLEdZ4Q_g52w'),('adil.raja@namal.edu.pk','fWue8nFgq6Y:APA91bGlCd3gybB6aWP9ucI9-k9X0uJeScBI_a0B0f_0ddJDQ71GEWBBoWEQ5qJ1ptgzdkG9mj0VomQWRQ3ooyrKUqA-cZPjWrZ0pv1pzSYyOTdVz5BX98hERM6RrQQkvyltR1E2lneH'),('admin@namal.edu.pk','fajEsJ7nDCE:APA91bEJyt5rjev_C9MKF75ONQr7qb72Vq-hINGa8RNoiLggZ5VJKICtvLuU70E19zGVtPAL9XWFwTkOP-oQUzeXare_s-jCtuTttyTerPlrwtmN07jvUEKYInmxIMxoM9Fvh3qih6vf');
/*!40000 ALTER TABLE `tokens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-12-31 17:31:11
