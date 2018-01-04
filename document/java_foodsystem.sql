-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: java_foodsystem
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.13-MariaDB

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
-- Table structure for table `account_admin`
--

DROP TABLE IF EXISTS `account_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_admin` (
  `Username` varchar(20) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `ChiNhanh` int(11) DEFAULT NULL,
  `Nhanvien` int(11) NOT NULL,
  `Quyen` varchar(45) NOT NULL,
  PRIMARY KEY (`Username`),
  KEY `FK_ac_nv_idx` (`Nhanvien`),
  KEY `Fk_acn_cn_idx` (`ChiNhanh`),
  CONSTRAINT `FK_ac_nv` FOREIGN KEY (`Nhanvien`) REFERENCES `nhanvien` (`NhanVienID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Fk_acn_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ban`
--

DROP TABLE IF EXISTS `ban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ban` (
  `BanID` int(11) NOT NULL AUTO_INCREMENT,
  `ChiNhanh` int(11) NOT NULL,
  `TenBan` varchar(50) NOT NULL,
  `TinhTrang` int(11) NOT NULL,
  `Active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`BanID`),
  KEY `fk_ban_cn_idx` (`ChiNhanh`),
  CONSTRAINT `fk_ban_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chinhanh`
--

DROP TABLE IF EXISTS `chinhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chinhanh` (
  `ChiNhanhID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) NOT NULL,
  `DiaChi` varchar(50) NOT NULL,
  `DienThoai` varchar(50) NOT NULL,
  `TinhThanh` int(11) NOT NULL,
  `hinhAnh` varchar(45) NOT NULL,
  `Active` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ChiNhanhID`),
  KEY `fk_cn_tt_idx` (`TinhThanh`),
  CONSTRAINT `fk_cn_tt` FOREIGN KEY (`TinhThanh`) REFERENCES `tinhthanh` (`TinhThanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chinhanhmon`
--

DROP TABLE IF EXISTS `chinhanhmon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chinhanhmon` (
  `ChiNhanh` int(11) NOT NULL,
  `Mon` int(11) NOT NULL,
  `Gia` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ChiNhanh`,`Mon`),
  KEY `fk_cnm_mon_idx` (`Mon`),
  CONSTRAINT `fk_cnm_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cnm_mon` FOREIGN KEY (`Mon`) REFERENCES `mon` (`MonID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chiphingay`
--

DROP TABLE IF EXISTS `chiphingay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chiphingay` (
  `ChiPhiNgayID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(255) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  `Ngay` datetime NOT NULL,
  `ChiNhanh` int(11) NOT NULL,
  `Tien` decimal(10,0) NOT NULL,
  PRIMARY KEY (`ChiPhiNgayID`),
  KEY `fk_cpn_cn_idx` (`ChiNhanh`),
  CONSTRAINT `fk_cpn_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chitiethoadon` (
  `HoaDon` int(11) NOT NULL,
  `Mon` int(11) NOT NULL,
  `SoLuong` int(255) NOT NULL,
  `TongTien` decimal(10,0) NOT NULL,
  PRIMARY KEY (`HoaDon`,`Mon`),
  KEY `fk_cthd_mon_idx` (`Mon`),
  CONSTRAINT `fk_cthd_hd` FOREIGN KEY (`HoaDon`) REFERENCES `hoadon` (`HoaDonID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cthd_mon` FOREIGN KEY (`Mon`) REFERENCES `mon` (`MonID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `chucvu` (
  `ChucVuID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(255) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  PRIMARY KEY (`ChucVuID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhmuc` (
  `DanhMucID` int(11) NOT NULL AUTO_INCREMENT,
  `Ten` varchar(50) NOT NULL,
  `Active` bit(1) NOT NULL,
  PRIMARY KEY (`DanhMucID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hoadon` (
  `HoaDonID` int(11) NOT NULL AUTO_INCREMENT,
  `KhachHang` varchar(20) DEFAULT NULL,
  `Ngay` datetime NOT NULL,
  `ChiNhanh` int(11) NOT NULL,
  `TongTien` decimal(10,0) NOT NULL,
  `TinhTrangThanhToan` int(11) NOT NULL,
  `HinhThucMua` varchar(50) NOT NULL,
  `TinhTrangGiaoHang` int(11) DEFAULT NULL,
  `Ban` int(11) DEFAULT NULL,
  `ThoiGianGiaoDuKien` datetime DEFAULT NULL,
  `HinhThucThanhToan` varchar(50) NOT NULL,
  `NguoiGiaoHang` int(11) DEFAULT NULL,
  `DiaChiGiao` varchar(450) DEFAULT NULL,
  `SDTNguoiNhan` varchar(45) DEFAULT NULL,
  `HoTenNguoiNhan` varchar(50) DEFAULT NULL,
  `NgayTraTien` datetime DEFAULT NULL,
  PRIMARY KEY (`HoaDonID`),
  KEY `fk_hd_cn_idx` (`ChiNhanh`),
  KEY `fk_hd_ban_idx` (`Ban`),
  KEY `fk_hd_nv_idx` (`NguoiGiaoHang`),
  KEY `fk_hd_kh_idx` (`KhachHang`),
  CONSTRAINT `fk_hd_ban` FOREIGN KEY (`Ban`) REFERENCES `ban` (`BanID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hd_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hd_kh` FOREIGN KEY (`KhachHang`) REFERENCES `khachhang` (`SDT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_hd_nv` FOREIGN KEY (`NguoiGiaoHang`) REFERENCES `nhanvien` (`NhanVienID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `khachhang` (
  `SDT` varchar(20) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `CMND` varchar(11) DEFAULT NULL,
  `Password` varchar(60) DEFAULT NULL,
  `NgayTao` date DEFAULT NULL,
  `DiaChi` varchar(450) DEFAULT NULL,
  `GioiTinh` bit(1) DEFAULT NULL,
  PRIMARY KEY (`SDT`),
  UNIQUE KEY `SDT_UNIQUE` (`SDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `luongchonhanvien`
--

DROP TABLE IF EXISTS `luongchonhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `luongchonhanvien` (
  `NhanVien` int(11) NOT NULL,
  `Thang` varchar(2) NOT NULL,
  `Nam` varchar(4) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  `Ngay` datetime DEFAULT NULL,
  `Tien` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`NhanVien`,`Thang`,`Nam`),
  CONSTRAINT `fk_lcnv_nv` FOREIGN KEY (`NhanVien`) REFERENCES `nhanvien` (`NhanVienID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mon`
--

DROP TABLE IF EXISTS `mon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mon` (
  `MonID` int(11) NOT NULL AUTO_INCREMENT,
  `DanhMuc` int(11) NOT NULL,
  `Ten` varchar(50) NOT NULL,
  `DonViTinh` varchar(10) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  `HinhAnh` varchar(255) NOT NULL,
  `SoLuongDaBan` int(255) NOT NULL,
  `Active` bit(1) NOT NULL,
  PRIMARY KEY (`MonID`),
  KEY `fk_mon_dm_idx` (`DanhMuc`),
  CONSTRAINT `fk_mon_dm` FOREIGN KEY (`DanhMuc`) REFERENCES `danhmuc` (`DanhMucID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS `news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `news` (
  `NewID` int(11) NOT NULL AUTO_INCREMENT,
  `ChuDe` varchar(255) NOT NULL,
  `NoiDung` text NOT NULL,
  `Ngay` date NOT NULL,
  PRIMARY KEY (`NewID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nhanvien` (
  `NhanVienID` int(11) NOT NULL AUTO_INCREMENT,
  `ChiNhanh` int(11) DEFAULT NULL,
  `ChucVu` int(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `NgaySinh` date NOT NULL,
  `GioiTinh` varchar(10) NOT NULL,
  `CMND` varchar(11) NOT NULL,
  `SDT` varchar(11) NOT NULL,
  `DiaChi` varchar(255) NOT NULL,
  `Luong` decimal(10,0) NOT NULL,
  PRIMARY KEY (`NhanVienID`),
  KEY `fk_nv_cv_idx` (`ChucVu`),
  KEY `fk_nv_cn_idx` (`ChiNhanh`),
  CONSTRAINT `fk_nv_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_nv_cv` FOREIGN KEY (`ChucVu`) REFERENCES `chucvu` (`ChucVuID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `subscriber`
--

DROP TABLE IF EXISTS `subscriber`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subscriber` (
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tienthuenha`
--

DROP TABLE IF EXISTS `tienthuenha`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tienthuenha` (
  `Thang` varchar(2) NOT NULL,
  `Nam` varchar(4) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  `MoTa` varchar(255) NOT NULL,
  `NgayChi` datetime NOT NULL,
  `ChiNhanh` int(11) NOT NULL,
  `Tien` decimal(10,0) NOT NULL,
  PRIMARY KEY (`Thang`,`Nam`),
  KEY `fk_ttn_cn_idx` (`ChiNhanh`),
  CONSTRAINT `fk_ttn_cn` FOREIGN KEY (`ChiNhanh`) REFERENCES `chinhanh` (`ChiNhanhID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tinhthanh`
--

DROP TABLE IF EXISTS `tinhthanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tinhthanh` (
  `TinhThanhID` int(11) NOT NULL AUTO_INCREMENT,
  `TenTinh` varchar(50) NOT NULL,
  PRIMARY KEY (`TinhThanhID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `trungtam`
--

DROP TABLE IF EXISTS `trungtam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trungtam` (
  `TrungTamID` int(11) NOT NULL AUTO_INCREMENT,
  `SoLuongTruyCap` bigint(20) NOT NULL,
  `Hotline` varchar(11) NOT NULL,
  `Ten` varchar(255) NOT NULL,
  PRIMARY KEY (`TrungTamID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-04 17:18:59
