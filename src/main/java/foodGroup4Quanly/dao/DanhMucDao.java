package foodGroup4Quanly.dao;



import java.util.List;

import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.entity.Mon;

public interface DanhMucDao {
    List<Danhmuc> getAllDanhmucs();

    void create(Danhmuc dm);

    void deactiveDanhmuc(int idDanhmuc);

    List<Mon> getMonByIdDm(int idDanhmuc, boolean monIsActive);
}
