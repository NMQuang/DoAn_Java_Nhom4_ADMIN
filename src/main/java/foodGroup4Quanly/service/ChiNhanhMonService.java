package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.entity.Chinhanhmon;

public interface ChiNhanhMonService {

	List<Chinhanhmon> getListChiNhanhMonByMon(int idMon);

	List<Chinhanhmon> getListChiNhanhMonByChiNhanh(int idChiNhanh);

	void save(Chinhanhmon chiNhanhMon);

	void delete(int idChinhanh, int idMon);
}
