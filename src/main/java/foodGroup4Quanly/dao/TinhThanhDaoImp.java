package foodGroup4Quanly.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Tinhthanh;

@Component
public class TinhThanhDaoImp implements TinhThanhDao{

	@Autowired
	public HibernateUtil hibernateUtil;

	@Override
	public List<Tinhthanh> getAllTinhThanh() {
		String hql = "from Tinhthanh";
		return hibernateUtil.fetchAll(hql);
	}

}
