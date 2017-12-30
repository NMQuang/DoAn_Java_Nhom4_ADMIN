package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.dto.BanDto;
import foodGroup4Quanly.entity.Ban;
import foodGroup4Quanly.entity.Chinhanh;

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

	@Override
	public Ban getInfoBan(int idBan) {
		Ban ban = new Ban();
		String hql = "from Ban where banId =: idBan";
		Query query = hibernateUtil.getSession().createQuery(hql).setParameter("idBan", idBan);
		if (query.list().isEmpty()) {
			return null;
		} else {
			ban = (Ban) query.list().get(0);
			return ban;
		}
	}

	@Override
	public void saveBan(Ban ban) {

		hibernateUtil.create(ban);
	}

	@Override
	public void delete(int idBan) {
		String hql = "delete from Ban where banId =:idBan";
		Query query = hibernateUtil.getSession().createQuery(hql)
				.setParameter("idBan", idBan);
		query.executeUpdate();

	}

}
