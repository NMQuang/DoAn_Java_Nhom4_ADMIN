package foodGroup4Quanly.dao;



import java.util.List;

import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.entity.Mon;

public interface DanhMucDao {
    List<Danhmuc> getAllDanhmucs();
    List<Danhmuc> getAllDanhmucDontcareActive();

    void create(Danhmuc dm);

    void setActiveDm(int idDanhmuc, boolean active);

    List<Mon> getMonByIdDm(int idDanhmuc, boolean monIsActive);
}
