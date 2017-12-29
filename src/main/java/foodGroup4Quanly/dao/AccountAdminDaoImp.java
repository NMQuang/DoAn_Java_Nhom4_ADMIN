package foodGroup4Quanly.dao;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.AccountAdmin;

@Component
public class AccountAdminDaoImp extends HibernateUtil implements AccountAdminDao{
	public AccountAdmin get(String username){
		String hql = "from AccountAdmin where username = :username";
		Query query = getSession().createQuery(hql).setParameter("username", username);
		return (AccountAdmin) query.uniqueResult();
	}
}
