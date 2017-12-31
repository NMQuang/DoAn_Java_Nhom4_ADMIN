package foodGroup4Quanly.dao;

import java.util.Date;
import java.util.List;

import foodGroup4Quanly.entity.Tienthuenha;

public interface TienThueNhaDao {
	List<Tienthuenha> getListIn(Date begin, Date end);
	long getSum(Date begin, Date end);
	long getSum(Date begin, Date end, int ChiNhanh);
}
