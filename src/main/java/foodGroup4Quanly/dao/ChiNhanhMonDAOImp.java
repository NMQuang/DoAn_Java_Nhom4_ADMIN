package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chinhanhmon;

@Component
public class ChiNhanhMonDAOImp extends HibernateUtil implements ChiNhanhMonDAO {


	@Override
	public List<Chinhanhmon> getListChiNhanhMon(int idMon) {
		String hql = "from Chinhanhmon where pk.mon.monId = :idMon";
		Query q = getSession().createQuery(hql).setParameter("idMon", idMon);
		return q.list();
	}

	@Override
	public List<Chinhanhmon> getListChiNhanhMonByChiNhanh(int idChiNhanh) {
		String hql = "from Chinhanhmon where pk.chinhanh.chiNhanhId = :idChiNhanh";
		Query q = getSession().createQuery(hql).setParameter("idChiNhanh", idChiNhanh);
		return q.list();
	}


}
