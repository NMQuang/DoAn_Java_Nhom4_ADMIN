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

	//sua them dk true
	@Override
	public List<Chinhanhmon> getListChiNhanhMonByChiNhanh(int idChiNhanh) {
		String hql = "from Chinhanhmon where pk.chinhanh.chiNhanhId = :idChiNhanh and pk.mon.active is true";
		Query q = getSession().createQuery(hql).setParameter("idChiNhanh", idChiNhanh);
		return q.list();
	}

	@Override
	public void save(Chinhanhmon chiNhanhMon) {

		getSession().save(chiNhanhMon);

	}

	@Override
	public void delete(int idChinhanh, int idMon) {
		String hql = "delete from Chinhanhmon where pk.chinhanh.chiNhanhId = :idChinhanh and pk.mon.monId = :idMon";
		Query query = getSession().createQuery(hql)
				.setParameter("idChinhanh", idChinhanh)
				.setParameter("idMon", idMon);
		query.executeUpdate();
	}


}
