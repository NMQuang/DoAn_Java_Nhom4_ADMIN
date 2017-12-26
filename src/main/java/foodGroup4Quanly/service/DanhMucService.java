package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.entity.Danhmuc;


public interface DanhMucService {

	List<Danhmuc> getAllDanhMuc();
	Danhmuc get(int id);
	void create(Danhmuc dm);
}
