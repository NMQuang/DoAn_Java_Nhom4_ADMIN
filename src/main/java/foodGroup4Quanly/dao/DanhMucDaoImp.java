package foodGroup4Quanly.dao;

import java.util.List;

import foodGroup4Quanly.entity.Mon;
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

    @Override
    public List<Danhmuc> getAllDanhmucDontcareActive() {
        return super.fetchAll(Danhmuc.class);
    }

    @Override
    public void create(Danhmuc dm) {
        super.create(dm);
    }

    @Override
    public void setActiveDm(int idDanhmuc, boolean active) {
        String hql = "update Danhmuc set active = :active where id = :id";
        Query query = getSession().createQuery(hql).setParameter("active", active).setParameter("id", idDanhmuc);
        query.executeUpdate();
    }

    @Override
    public List<Mon> getMonByIdDm(int idDanhmuc, boolean monIsActive) {
        String hql = "from Mon M where M.danhmuc.danhMucId=:idDanhmuc and M.active=:monIsActive";
        Query query = getSession().createQuery(hql);
        query.setParameter("idDanhmuc", idDanhmuc);
        query.setParameter("monIsActive", monIsActive);

        return query.list();
    }
}
