package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.dto.BanDto;

@Component
public class BanDaoImp implements BanDao {

	@Autowired
	public HibernateUtil hibernateUtil;

	@Override
	public List<BanDto> getListTableByChiNhanh(int idChinhanh) {
		String hql = "select ban.banId, ban.tenBan, ban.tinhTrang, chinhanh.ten from Ban ban join ban.chinhanh chinhanh where chinhanh.chiNhanhId =:idChinhanh";
		Query query = hibernateUtil.getSession().createQuery(hql).setParameter("idChinhanh", idChinhanh);
		return query.list();
	}

}
