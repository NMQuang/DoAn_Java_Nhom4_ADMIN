package foodGroup4Quanly.dao;

import java.util.List;

import foodGroup4Quanly.entity.Chinhanhmon;

public interface ChiNhanhMonDAO {


	List<Chinhanhmon> getListChiNhanhMon(int idMon);

	List<Chinhanhmon> getListChiNhanhMonByChiNhanh(int idChiNhanh);

	void save(Chinhanhmon chiNhanhMon);

	void delete(int idChinhanh, int idMon);
}
