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

	@Override
	public int getCountFood(boolean active) {
		Query query = getSession().createQuery("select count(*) from Mon where active is :active");
		query.setParameter("active", active);
    	int count = ((Long) query.uniqueResult()).intValue();
    	return count;
	}

	@Override
	public List<Mon> getList(int maxResult, int begin, boolean active) {
		 String hql = "from Mon where active is :active";
        Query query = getSession().createQuery(hql);
        query.setParameter("active", active);
        query.setFirstResult(begin).setMaxResults(maxResult);
        List<Mon> mons = query.list();
        return mons;
	}

	@Override
	public void active(int idMonan) {
		 String hql = "update Mon set active = true where monId = :id";
		 Query query = getSession().createQuery(hql);
	     query.setParameter("id", idMonan);
	     query.executeUpdate();
	}

    
}


















