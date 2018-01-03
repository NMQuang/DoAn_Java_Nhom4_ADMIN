package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.Chiphingay;


public interface ChiPhiNgayDao {
	List<Chiphingay> getListIn(Date begin, Date end);
	long getSum(Date begin, Date end);
	long getSum(Date begin, Date end, int ChiNhanh);
	List<Chiphingay> getListIn(Date begin, Date end, int ChiNhanh);

	List<Chiphingay> getChiPhiNgayInDate(Date date);

    void create(Chiphingay chiphingay);

    Chiphingay getById(int id);

    void update(Chiphingay chiphingay);
}
