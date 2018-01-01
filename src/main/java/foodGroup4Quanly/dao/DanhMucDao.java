package foodGroup4Quanly.dao;



import java.util.List;

import foodGroup4Quanly.entity.Danhmuc;

public interface DanhMucDao {
    List<Danhmuc> getAllDanhmucs();

    void create(Danhmuc dm);
    
}
