package foodGroup4Quanly.service;

import foodGroup4Quanly.dao.LuongChoNhanVienDao;
import foodGroup4Quanly.dto.DanhSachLuongNhanVienDto;
import foodGroup4Quanly.dto.LuongNhanVienDto;
import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import foodGroup4Quanly.entity.Luongchonhanvien;
import foodGroup4Quanly.entity.LuongchonhanvienPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class LuongNhanVienServiceImp implements LuongNhanVienService {

    @Autowired
    LuongChoNhanVienDao luongChoNhanVienDao;

    @Override
    public List<TongLuongNhanVienTheoThangDto> getTongLuongTheoThang(String strYear, int idChiNhanh) {
        List<TongLuongNhanVienTheoThangDto> listTongLuong =
                luongChoNhanVienDao.getListTongLuongTheoThang(strYear, idChiNhanh);
        return listTongLuong;
    }

    @Override
    public boolean hasLuongNhanVien(int nhanVien, String thang, String nam) {
        return luongChoNhanVienDao.hasLuongNhanVien(nhanVien, thang, nam);
    }

    @Override
    public void saveDsLuongNhanVien(DanhSachLuongNhanVienDto danhSachLuongNhanVien) {
        for(LuongNhanVienDto luongNvDto: danhSachLuongNhanVien.getListLuongNhanVien()) {

            Luongchonhanvien luongNv = new Luongchonhanvien();
            luongNv.setNhanVien(luongNvDto.getId());
            luongNv.setThang(danhSachLuongNhanVien.getThang());
            luongNv.setNam(danhSachLuongNhanVien.getNam());
            luongNv.setMoTa(luongNvDto.getMota());
            luongNv.setTien(luongNvDto.getLuong());

            luongChoNhanVienDao.create(luongNv);
        }
    }

    @Override
    public List<Luongchonhanvien> getListLuong(String month, String year, int chiNhanhId) {
        return luongChoNhanVienDao.getLuongNhanVien(month, year, chiNhanhId);
    }

    @Override
    public void updateDsLuongNhanVien(DanhSachLuongNhanVienDto danhSachLuongNhanVien) {
        String thang = danhSachLuongNhanVien.getThang();
        String nam = danhSachLuongNhanVien.getNam();
        for(LuongNhanVienDto luongNvDto: danhSachLuongNhanVien.getListLuongNhanVien()) {
            Luongchonhanvien luongNv = luongChoNhanVienDao.findById(luongNvDto.getId(), thang, nam);

            luongNv.setMoTa(luongNvDto.getMota());
            luongNv.setTien(luongNvDto.getLuong());

            luongChoNhanVienDao.update(luongNv);
        }
    }


}
