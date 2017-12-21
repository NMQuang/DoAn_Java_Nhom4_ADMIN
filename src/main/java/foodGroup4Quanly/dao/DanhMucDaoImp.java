package foodGroup4Quanly.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Danhmuc;



@Component
public class DanhMucDaoImp extends HibernateUtil implements DanhMucDao{

    @Override
    public List<Danhmuc> getAllDanhmucs() {
        String hql = "from Danhmuc DM where DM.active=true";
        Query query = getSession().createQuery(hql);
        return query.list();
    }
}
