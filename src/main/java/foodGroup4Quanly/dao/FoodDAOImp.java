package foodGroup4Quanly.dao;


import java.util.Calendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Mon;

@Component
public class FoodDAOImp extends HibernateUtil implements FoodDAO {

	@Override
	public void save(Mon mon) {
		create(mon);
	}

	@Override
	public void delete(int id) {
		String hql = "update Mon set active = false where id = :id";
		Query query = getSession().createQuery(hql).setParameter("id", id);
		query.executeUpdate();
	}

    
}


















