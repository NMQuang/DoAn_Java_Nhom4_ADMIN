package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import foodGroup4Quanly.entity.Luongchonhanvien;
import foodGroup4Quanly.entity.LuongchonhanvienPK;

public interface LuongChoNhanVienDao {
	List<Luongchonhanvien> getListIn(Date begin, Date end);
	long getSum(Date begin, Date end);
	long getSum(Date begin, Date end, int ChiNhanh);
	List<Luongchonhanvien> getListIn(Date begin, Date end, int ChiNhanh);

	List<TongLuongNhanVienTheoThangDto> getListTongLuongTheoThang(String year, int idChiNhanh);

    boolean hasLuongNhanVien(int nhanVien, String thang, String nam);

    void create(Luongchonhanvien luongNv);

}
