create database quanlycafe;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

USE quanlycafe;

-- tạo bảng bàn

CREATE TABLE quanlycafe.ban (
MaBan int (10) NOT NULL,
MaKhuVuc int(10) NOT NULL,
TenBan varchar(30) NOT NULL,
TrangThai varchar(30) NOT NULL 
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

-- cho dữ liệu vào bảng

INSERT INTO ban  VALUES
(32, 1, 'Ban 1', 'Trống'),
(33, 1, 'Ban 2', 'Trống'),
(34, 1, 'Ban 3', 'Trống'),
(35, 1, 'Ban 4', 'Trống'),
(36, 1, 'Ban 5', 'Trống'),
(37, 1, 'Ban 6', 'Trống'),
(38, 2, 'Ban 7', 'Trống'),
(39, 2, 'Ban 8', 'Trống'),
(40, 2, 'Ban 9', 'Trống'),
(41, 2, 'Ban 10', 'Trống'),
(42, 2, 'Ban 11', 'Trống'),
(43, 2, 'Ban 12', 'Trống'),
(44, 3, 'Ban 13', 'Trống'),
(45, 3, 'Ban 14', 'Trống'),
(46, 3, 'Ban 15', 'Trống'),
(47, 3, 'Ban 16', 'Trống'),
(48, 3, 'Ban 17', 'Trống'),
(49, 3, 'Ban 18', 'Trống');

-- tạo bảng nhân viên
CREATE TABLE quanlycafe.nhanvien (
   MaNV varchar(50) NOT NULL,
   TenNV varchar(150) NOT NULL,
   GioiTinh tinyint(4) NOT NULL,
   ChucVu varchar(50) NOT NULL,
   NgayVaoLam date NOT NULL,
   DiaChi varchar(200) NOT NULL,
   SDT int(11) NOT NULL,
   MatKhau varchar(32) NOT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- Đang đổ dữ liệu cho bảng `nhanvien`

INSERT INTO nhanvien 
 VALUES
-- ('', '', 0, '', '0000-00-00', '', 0, ''),
('NV1', 'Nguyen Van A', 1, 'Nhan Vien', '2005-08-13', 'Da Nang', 123234345, '123456'),
('NV2', 'Nguyen Van B', 1, 'Nhan Vien', '2004-07-07', 'Da Nang', 123234345, '123456'),
('NV3', 'Nguyen Van C', 1, 'Nhan Vien', '2003-10-06', 'Da Nang', 123234345, '123456'),
('NV4', 'Nguyen Van D', 1, 'Nhan Vien', '2002-03-24', 'Da Nang', 123234345, '123456');


-- tạo bảng hóa đơn 
CREATE TABLE quanlycafe.hoadon (
    MaHoaDon int(11) NOT NULL,
    MaNV varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
    GiamGia int(11) DEFAULT NULL,
    MaBan int(11) NOT NULL,
    GioDen datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    TongTien int(11) DEFAULT NULL,
    TrangThai int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- đổ dữ liệu vào cho bảng
INSERT INTO hoadon 
 VALUES
(20, 'NV1', NULL, 33, '2020-12-14 19:03:07', 50000, 1),
(21, 'NV1', NULL, 35, '2020-12-14 19:04:29', 25000, 1),
(23, 'NV1', NULL, 45, '2020-12-14 19:20:01', 25000, 1),
(24, 'NV1', NULL, 43, '2020-12-14 19:22:42', 25000, 1),
(25, 'NV1', NULL, 41, '2020-12-14 19:54:50', 50000, 1),
(26, 'NV1', NULL, 47, '2020-12-14 22:13:04', 100000, 1),
(27, 'NV1', 20, 46, '2020-12-14 22:13:32', 20000, 1),
(28, 'NV1', NULL, 34, '2020-12-14 22:13:36', 25000, 1),
(29, 'NV3', 50, 39, '2020-12-15 17:59:50', 37500, 1),
(30, 'NV3', NULL, 40, '2020-12-17 19:53:27', 50000, 1),
(31, 'NV3', NULL, 47, '2020-12-18 21:02:17', 50000, 1),
(32, 'NV3', NULL, 32, '2020-12-18 22:09:08', 150000, 1);

-- tạo bảng chi tiết hóa đơn

CREATE TABLE quanlycafe.chitiethd (
  MaChiTietHD int(11) NOT NULL,
  MaHoaDon int(11) NOT NULL,
  MaMon int(11) NOT NULL,
  SoLuong int(11) NOT NULL,
  Gia int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Đang đổ dữ liệu cho bảng  
INSERT INTO chitiethd
VALUES 
(396, 20, 60, 2, 50000),
(397, 20, 64, 1, 35000),
(398, 23, 67, 3, 45000),
(399, 23, 69, 2, 60000);





-- tạo bảng khu vưc 
CREATE TABLE quanlycafe.khuvuc (
    MaKhuVuc int(11) NOT NULL,
    TenKhuVuc varchar(25),
    PRIMARY KEY (MaKhuVuc)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- đổ dữ liệu vào cho bảng
INSERT INTO khuvuc
 VALUES
(1, 'Tầng 1'),
(2, 'Tầng 2'),
(3, 'Tầng 3');






-- tạo bảng phân loại món
CREATE TABLE quanlycafe.phanloaimon (
MaLoai int (11) NOT NULL,
TenLoai varchar(30) NOT NULL
) ENGINE= InnoDB DEFAULT CHARSET=utf8mb4;

-- đổ dũ liệu vào cho bảng


INSERT INTO phanloaimon
VALUES
(1, 'Cà phê'),
(2, 'Trà sữa'),
(3, 'Bánh Ngọt');

-- tạo bảng thực đơn

CREATE TABLE quanlycafe.thucdon (
   MaMon int(11) NOT NULL,
   TenMon varchar(55) NOT NULL,
   MaLoai int(11) NOT NULL,
   DonGia int(11) NOT NULL,
   DonViTinh varchar(55) NOT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;


-- đổ dữ liệu vào bảng

INSERT INTO thucdon 
 VALUES
('60', 'Bánh ngọtrứng muối', 3, 25000, 'Cái'),
('61', 'Bánh ngọt socola', 3, 30000, 'Cái'),
('62', 'Bánh ngọt kem dâu', 3, 28000, 'Cái'),
('63', 'Bánh ngọt hạt sen', 3, 27000, 'Cái'),
('64', 'Bánh ngọt hồng trà', 3, 26000, 'Cái'),
('65', 'Bánh ngọt matcha', 3, 32000, 'Cái'),
('66', 'Cà phê đen', 1, 35000, 'Ly'),
('67', 'Cà phê sữa',1, 40000, 'Ly'),
('68', 'Cà phê đá xay', 1, 45000, 'Ly'),
('69', 'Cappuccino', 1, 38000, 'Ly'),
('70', 'Espresso', 1, 30000, 'Ly'),
('71', 'Trà sữa trân châu đen', 2, 45000, 'Ly'),
('72', 'Trà sữa trân châu trắng', 2, 48000, 'Ly'),
('73', 'Trà sữa thái xanh', 2, 42000, 'Ly'),
('74', 'Trà sữa hoa hồng', 2, 50000, 'Ly'),
('75', 'Trà sữa olong', 2, 47000, 'Ly'),
('76', 'Trà sữa mật ong', 2, 49000, 'Ly'),
('77', 'Bánh ngọt hạnh nhân',3, 29000, 'Cái'),
('78', 'Bánh ngọt dừa', 3, 31000, 'Cái'),
('79', 'Bánh ngọt chuối', 3, 33000, 'Cái'),
('80', 'Bánh ngọt xoài', 3, 34000, 'Cái'),
('81', 'Bánh ngọt cam',3, 32000, 'Cái'),
('82', 'Bánh ngọt dưa hấu', 3, 35000, 'Cái'),
('83', 'Cà phê phin', 1, 38000, 'Ly'),
('84', 'Cà phê sữa đá', 1, 42000, 'Ly'),
('85', 'Latte', 1, 45000, 'Ly'),
('86', 'Americano', 1, 37000, 'Ly'),
('87', 'Macchiato', 1, 39000, 'Ly');



ALTER TABLE `ban`
  ADD PRIMARY KEY (`MaBan`);


--
-- Chỉ mục cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD PRIMARY KEY (`MaChiTietHD`),
  ADD KEY `MaHoaDon` (`MaHoaDon`),
  ADD KEY `MaMon` (`MaMon`);


--
-- Chỉ mục cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD PRIMARY KEY (`MaHoaDon`),
  ADD KEY `MaBan` (`MaBan`),
  ADD KEY `MaNV` (`MaNV`);

--
-- Chỉ mục cho bảng `nhanvien`
--
ALTER TABLE `nhanvien`
  ADD PRIMARY KEY (`MaNV`);

--
-- Chỉ mục cho bảng `nhommon`
--
ALTER TABLE `phanloaimon`
  ADD PRIMARY KEY (`MaLoai`);

--
-- Chỉ mục cho bảng `thucdon`
--
-- Thêm khóa chính vào cột MaMon

ALTER TABLE `thucdon`
  ADD PRIMARY KEY (`MaMon`);

-- Thêm khóa ngoại vào cột MaLoai
ALTER TABLE `thucdon`
  ADD KEY `MaLoai` (`MaLoai`);


--

-- AUTO_INCREMENT cho bảng `ban`
--
ALTER TABLE `ban`
  MODIFY `MaBan` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;
--

-- AUTO_INCREMENT cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  MODIFY `MaChiTietHD` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=400;
--
-- AUTO_INCREMENT cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  MODIFY `MaHoaDon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;
--
-- AUTO_INCREMENT cho bảng `nhommon`
--
ALTER TABLE `phanloaimon`
  MODIFY `MaLoai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  MODIFY `MaMon` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=88;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitiethd`
--
ALTER TABLE `chitiethd`
  ADD CONSTRAINT `chitiethd_ibfk_1` FOREIGN KEY (`MaHoaDon`) REFERENCES `hoadon` (`MaHoaDon`),
  ADD CONSTRAINT `chitiethd_ibfk_2` FOREIGN KEY (`MaMon`) REFERENCES `thucdon` (`MaMon`);

--
-- Các ràng buộc cho bảng `hoadon`
--
ALTER TABLE `hoadon`
  ADD CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`MaBan`) REFERENCES `ban` (`MaBan`);
ALTER TABLE quanlycafe.hoadon
ADD CONSTRAINT hoadon_ibfk_2 FOREIGN KEY (MaNV) REFERENCES quanlycafe.nhanvien (MaNV);


--
-- Các ràng buộc cho bảng `thucdon`
--
ALTER TABLE `thucdon`
  ADD CONSTRAINT `thucdon_ibfk_1` FOREIGN KEY (`MaLoai`) REFERENCES `phanloaimon` (`MaLoai`);

ALTER TABLE quanlycafe.ban
ADD CONSTRAINT fk_khuvuc_ban FOREIGN KEY (MaKhuVuc) REFERENCES quanlycafe.khuvuc(MaKhuVuc);


