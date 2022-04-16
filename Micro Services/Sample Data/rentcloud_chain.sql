-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.33-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for rentcloud_customer
CREATE DATABASE IF NOT EXISTS `rentcloud_customer` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rentcloud_customer`;

-- Dumping structure for table rentcloud_customer.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dlNumber` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table rentcloud_customer.customer: ~1 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT IGNORE INTO `customer` (`id`, `dlNumber`, `firstName`, `lastName`, `zipcode`) VALUES
	(1, '65236', 'Lakshan', 'NV', '154'),
	(2, '54524', 'Kalana', 'Galpatha', '856');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;

-- Dumping structure for table rentcloud_customer.loyalitypoint
CREATE TABLE IF NOT EXISTS `loyalitypoint` (
  `transactionId` int(11) NOT NULL AUTO_INCREMENT,
  `expireDate` datetime(6) DEFAULT NULL,
  `point` int(11) NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`transactionId`),
  KEY `FK5c5y2l75v0efpgsq391cku4fe` (`customer_id`),
  CONSTRAINT `FK5c5y2l75v0efpgsq391cku4fe` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table rentcloud_customer.loyalitypoint: ~0 rows (approximately)
/*!40000 ALTER TABLE `loyalitypoint` DISABLE KEYS */;
/*!40000 ALTER TABLE `loyalitypoint` ENABLE KEYS */;


-- Dumping database structure for rentcloud_rent
CREATE DATABASE IF NOT EXISTS `rentcloud_rent` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rentcloud_rent`;

-- Dumping structure for table rentcloud_rent.rent
CREATE TABLE IF NOT EXISTS `rent` (
  `rentId` int(11) NOT NULL AUTO_INCREMENT,
  `currentOdometer` int(11) NOT NULL,
  `customerId` int(11) NOT NULL,
  `rentFrom` datetime(6) DEFAULT NULL,
  `rentTill` datetime(6) DEFAULT NULL,
  `returnLocation` varchar(255) DEFAULT NULL,
  `vehicleId` int(11) NOT NULL,
  PRIMARY KEY (`rentId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table rentcloud_rent.rent: ~0 rows (approximately)
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT IGNORE INTO `rent` (`rentId`, `currentOdometer`, `customerId`, `rentFrom`, `rentTill`, `returnLocation`, `vehicleId`) VALUES
	(1, 424452, 1, '2022-04-16 21:45:08.000000', '2024-04-16 21:45:12.000000', 'Colombo', 1),
	(2, 254114, 2, '2022-04-16 21:45:43.000000', '2027-04-16 21:45:43.000000', 'Kandy', 2);
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;


-- Dumping database structure for rentcloud_vehicle
CREATE DATABASE IF NOT EXISTS `rentcloud_vehicle` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `rentcloud_vehicle`;

-- Dumping structure for table rentcloud_vehicle.vehicle
CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `make` varchar(255) DEFAULT NULL,
  `model` varchar(255) DEFAULT NULL,
  `odometerValueOnRegister` int(11) NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `year` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table rentcloud_vehicle.vehicle: ~3 rows (approximately)
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT IGNORE INTO `vehicle` (`id`, `color`, `make`, `model`, `odometerValueOnRegister`, `type`, `year`) VALUES
	(1, 'Red', 'Metal', 'Celica', 56325, 'Car', 2014),
	(2, 'Black', 'Alloy', 'Caravan', 45258, 'Van', 2015),
	(3, 'White', 'Plastic', 'Caravan', 52344, 'Van', 2015);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
