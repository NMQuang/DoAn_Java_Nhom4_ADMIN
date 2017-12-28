package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.entity.Danhmuc;
import foodGroup4Quanly.entity.Mon;


public interface DanhMucService {

	List<Danhmuc> getAllDanhMuc();
	List<Danhmuc> getAllDanhmucDontcareActive();

	Danhmuc get(int id);
	void create(Danhmuc dm);

    void deactiveDanhmuc(int idDanhmuc);
	void activeDanhmuc(int idDanhmuc);

    List<Mon> getMonActiveByIdDm(int idDanhmuc);

	List<Mon> getMonDeactiveByIdDm(int idDanhmuc);
}
