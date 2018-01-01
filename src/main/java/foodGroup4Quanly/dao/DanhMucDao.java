package foodGroup4Quanly.dao;



import java.util.List;

import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.entity.Mon;

public interface DanhMucDao {
    Danhmuc findById(int id);

    List<Danhmuc> getAllDanhmucs();
    List<Danhmuc> getAllDanhmucDontcareActive();
    List<Danhmuc> getAllDanhmuc(boolean active);

    void create(Danhmuc dm);

    void setActiveDm(int idDanhmuc, boolean active);

    List<Mon> getMonByIdDm(int idDanhmuc, boolean monIsActive);

    void suaTenDm(String ten, int id);
}
