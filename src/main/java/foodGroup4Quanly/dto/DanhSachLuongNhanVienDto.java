package foodGroup4Quanly.dto;

import foodGroup4Quanly.entity.Luongchonhanvien;
import foodGroup4Quanly.entity.Nhanvien;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DanhSachLuongNhanVienDto {
    private String thoiGian;
    private List<LuongNhanVienDto> listLuongNhanVien = new ArrayList<>();
    private boolean isUpdate = false;

    public DanhSachLuongNhanVienDto() {

    }

    public DanhSachLuongNhanVienDto(Set<Nhanvien> setNhanVien) {
        tranferDataFromDb(setNhanVien);
    }

    public DanhSachLuongNhanVienDto(List<Luongchonhanvien> listLuongNv) {
        tranferDataFromDb(listLuongNv);
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

    private void tranferDataFromDb(List<Luongchonhanvien> listLuongNv) {
        for(Luongchonhanvien luongNv: listLuongNv) {
            LuongNhanVienDto luongNvDto = new LuongNhanVienDto();

            luongNvDto.setId(luongNv.getNhanvien().getNhanVienId());
            luongNvDto.setTen(luongNv.getNhanvien().getTen());
            luongNvDto.setLuong(luongNv.getTien());
            luongNvDto.setMota(luongNv.getMoTa());

            listLuongNhanVien.add(luongNvDto);
        }
        this.thoiGian = listLuongNv.get(0).getThang() + "-" + listLuongNv.get(0).getNam();
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

    public boolean getUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        isUpdate = update;
    }
}
