package foodGroup4Quanly.service;

import foodGroup4Quanly.dto.DanhSachLuongNhanVienDto;
import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import foodGroup4Quanly.entity.Chinhanh;
import foodGroup4Quanly.entity.Luongchonhanvien;
import foodGroup4Quanly.entity.LuongchonhanvienPK;

import java.util.List;

public interface LuongNhanVienService {

    List<TongLuongNhanVienTheoThangDto> getTongLuongTheoThang(String strYear, int idChiNhanh);

    boolean hasLuongNhanVien(int nhanVien, String thang, String nam);

    void saveDsLuongNhanVien(DanhSachLuongNhanVienDto danhSachLuongNhanVien);

    List<Luongchonhanvien> getListLuong(String month, String year, int chiNhanhId);

    void updateDsLuongNhanVien(DanhSachLuongNhanVienDto danhSachLuongNhanVien);

}
