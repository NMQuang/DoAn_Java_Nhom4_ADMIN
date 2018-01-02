package foodGroup4Quanly.service;

import foodGroup4Quanly.entity.Hoadon;

public interface HoadonService {
	
	void create(Hoadon hoadon);
	Hoadon getTheLastBillByTableStillCooking(int idBan);
	void delete(Hoadon hoadon);
	void update(Hoadon hoadon);
}
