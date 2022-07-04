-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th7 04, 2022 lúc 03:27 PM
-- Phiên bản máy phục vụ: 5.7.33
-- Phiên bản PHP: 7.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `db_quanlycoffe`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ban`
--

CREATE TABLE `ban` (
  `MaBan` int(11) NOT NULL,
  `TenBan` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `TrangThai` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `ban`
--

INSERT INTO `ban` (`MaBan`, `TenBan`, `TrangThai`) VALUES
(1, 'Bàn 1', 'Trống'),
(2, 'Bàn 2', 'Trống'),
(3, 'Bàn 3', 'Đang phục vụ'),
(4, 'Bàn 4', 'Đang phục vụ'),
(5, 'Bàn 5', 'Trống'),
(6, 'bàn 6', 'Trống'),
(7, 'Bàn 7', 'Đang phục vụ'),
(8, 'Bàn 8', 'Đang phục vụ'),
(9, 'Bàn 9', 'Đang phục vụ'),
(10, 'Bàn 10', 'Trống'),
(11, 'Bàn 11', 'Trống'),
(12, 'Bàn 12', 'Trống'),
(13, 'Bàn 13', 'Trống'),
(14, 'Bàn 14', 'Trống'),
(15, 'Bàn 15', 'Trống'),
(16, 'Bàn 16', 'Trống'),
(17, 'Bàn 17', 'Trống'),
(18, 'Bàn 18', 'Trống'),
(19, 'Bàn 19', 'Trống'),
(20, 'Bàn 20', 'Trống'),
(21, 'Bàn 21', 'Trống');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cthd`
--

CREATE TABLE `cthd` (
  `MaHD` int(11) NOT NULL,
  `MaTA` int(11) NOT NULL,
  `Gia` int(11) NOT NULL,
  `SoLuong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `cthd`
--

INSERT INTO `cthd` (`MaHD`, `MaTA`, `Gia`, `SoLuong`) VALUES
(3, 3, 20000, 1),
(5, 5, 20000, 1),
(6, 4, 20000, 1),
(7, 7, 20000, 1),
(8, 8, 20000, 1),
(9, 9, 60000, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoadon`
--

CREATE TABLE `hoadon` (
  `MaHD` int(11) NOT NULL,
  `MaBan` int(11) NOT NULL,
  `TongTien` int(11) DEFAULT NULL,
  `GioDen` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `hoadon`
--

INSERT INTO `hoadon` (`MaHD`, `MaBan`, `TongTien`, `GioDen`) VALUES
(3, 3, NULL, '2022-07-04 14:04:42'),
(4, 2, NULL, '2022-07-04 14:11:48'),
(5, 5, NULL, '2022-07-04 14:24:27'),
(6, 4, NULL, '2022-07-04 14:53:46'),
(7, 7, NULL, '2022-07-04 14:55:03'),
(8, 8, NULL, '2022-07-04 14:58:45'),
(9, 9, NULL, '2022-07-04 16:05:09');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaita`
--

CREATE TABLE `loaita` (
  `MaLoai` int(11) NOT NULL,
  `TenLoai` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `loaita`
--

INSERT INTO `loaita` (`MaLoai`, `TenLoai`) VALUES
(1, 'Nước có gas'),
(2, 'Nước không có gas'),
(3, 'Sinh tố'),
(4, 'Nước ly'),
(5, 'nước ép'),
(6, 'cafe'),
(7, 'd');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `MaTK` int(11) NOT NULL,
  `Username` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `Password` varchar(32) COLLATE utf8mb4_unicode_ci NOT NULL,
  `HoTen` text COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`MaTK`, `Username`, `Password`, `HoTen`) VALUES
(1, 'a', 'a', 'Đình Nguyên');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thucdon`
--

CREATE TABLE `thucdon` (
  `MaTA` int(11) NOT NULL,
  `TenTA` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `Gia` int(11) NOT NULL,
  `DVT` text COLLATE utf8mb4_unicode_ci NOT NULL,
  `MaLoai` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `thucdon`
--

INSERT INTO `thucdon` (`MaTA`, `TenTA`, `Gia`, `DVT`, `MaLoai`) VALUES
(1, 'Sting', 20000, 'Chai', 1),
(2, 'Ô long', 18000, 'Chai', 2),
(3, 'Trà xanh', 15000, 'Chai', 2),
(4, 'Cafe sữa', 10000, 'Ly', 4),
(5, 'Cafe', 20000, 'Ly', 4),
(6, 'Yaout', 22000, 'Ly', 4),
(7, 'Ca cao đá', 22000, 'Ly', 4),
(8, 'Ca cao sữa đá', 22000, 'Ly', 4),
(9, 'Number one', 22000, 'Chai', 1),
(10, 'milo dầm', 10000, 'Ly', 4),
(11, 'milo sữa', 10000, 'Ly', 4),
(12, 'dddd', 1212, 'Chai', 1),
(13, '13', 33333, 'Chai', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ban`
--
ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`);

--
-- Chỉ mục cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD PRIMARY KEY (`MaHD`,`MaTA`),
  ADD KEY `FK_CTHD_TA` (`MaTA`);

--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHD`,`MaBan`),
  ADD KEY `FK_HD_BAN` (`MaBan`);

--
-- Chỉ mục cho bảng `loaita`
--
ALTER TABLE `loaita`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`MaTK`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- Chỉ mục cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaTA`),
  ADD KEY `FK_TA_LOAI` (`MaLoai`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `loaita`
--
ALTER TABLE `loaita`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `MaTK` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaTA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `cthd`
--
ALTER TABLE `cthd`
  ADD CONSTRAINT `FK_CTHD_HD` FOREIGN KEY (`MaHD`) REFERENCES `hoadon` (`MaHD`),
  ADD CONSTRAINT `FK_CTHD_TA` FOREIGN KEY (`MaTA`) REFERENCES `thucdon` (`MaTA`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `FK_HD_BAN` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);

--
-- Các ràng buộc cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD CONSTRAINT `FK_TA_LOAI` FOREIGN KEY (`MaLoai`) REFERENCES `loaita` (`MaLoai`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
