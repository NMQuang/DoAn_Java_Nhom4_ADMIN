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

	@Override
	public int countMonByChiNhanh(int idChiNhanh) {
		Query query = getSession().createQuery("select count(*)  from Chinhanhmon where pk.chinhanh.chiNhanhId = :idChiNhanh")
				.setParameter("idChiNhanh", idChiNhanh);
	    	int count = ((Long) query.uniqueResult()).intValue();
	    	return count;
	}

	@Override
	public List<Chinhanhmon> getListChiNhanhMonPageByChiNhanh(int idChiNhanh, int maxResult, int begin) {
		String hql = "from Chinhanhmon where pk.chinhanh.chiNhanhId = :idChiNhanh";
	         Query query = getSession().createQuery(hql).setParameter("idChiNhanh", idChiNhanh);
	         query.setFirstResult(begin).setMaxResults(maxResult);
	         return query.list();
	}

	@Override
	public void updateGia(int idChinhanh, int idMon, int gia) {
		String hql = "update Chinhanhmon m set m.gia =:gia where m.pk.mon.monId=:idMon and m.pk.chinhanh.chiNhanhId=:idChinhanh";
		Query query = getSession().createQuery(hql)
				.setParameter("gia", gia)
				.setParameter("idMon", idMon)
				.setParameter("idChinhanh", idChinhanh);
		query.executeUpdate();
	}


}
