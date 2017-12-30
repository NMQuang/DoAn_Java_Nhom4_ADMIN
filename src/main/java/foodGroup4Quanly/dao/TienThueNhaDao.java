package foodGroup4Quanly.dao;

import java.util.Date;

public interface TienThueNhaDao {
	long getSum(Date begin, Date end);
	long getSum(Date begin, Date end, int ChiNhanh);
}
