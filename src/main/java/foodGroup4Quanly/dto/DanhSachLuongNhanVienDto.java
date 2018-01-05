package foodGroup4Quanly.dto;

import foodGroup4Quanly.entity.Nhanvien;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DanhSachLuongNhanVienDto {
    private String thoiGian;
    private List<LuongNhanVienDto> listLuongNhanVien = new ArrayList<>();

    public DanhSachLuongNhanVienDto() {

    }

    public DanhSachLuongNhanVienDto(Set<Nhanvien> listNhanVien) {
        tranferDataFromDb(listNhanVien);
    }

    private void tranferDataFromDb(Set<Nhanvien> listNhanVien) {
        for(Nhanvien nv: listNhanVien) {
            LuongNhanVienDto luongNv = new LuongNhanVienDto();
            luongNv.setId(nv.getNhanVienId());
            luongNv.setTen(nv.getTen());
            luongNv.setLuong(nv.getLuong());
            listLuongNhanVien.add(luongNv);
        }
    }

    public String getThang() {
        return (new String(this.thoiGian)).split("-")[0];
    }

    public String getNam() {
        return (new String(this.thoiGian)).split("-")[1];
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public List<LuongNhanVienDto> getListLuongNhanVien() {
        return listLuongNhanVien;
    }

    public void setListLuongNhanVien(List<LuongNhanVienDto> listLuongNhanVien) {
        this.listLuongNhanVien = listLuongNhanVien;
    }
}
