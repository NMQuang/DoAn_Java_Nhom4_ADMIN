package foodGroup4Quanly.dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Component;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Khachhang;
import foodGroup4Quanly.pojo.KhachHangGroup;

@Component
public class KhachHangDaoImp extends HibernateUtil implements KhachHangDao{

	@Override
	public List<KhachHangGroup> getAllGroupByTime() {
		ProjectionList projectionList = Projections.projectionList();   
		projectionList.add(Projections.groupProperty("ngayTao")).add(Projections.rowCount());
		Criteria criteria  = getSession().createCriteria(Khachhang.class);
		criteria.setProjection(projectionList);
		List<KhachHangGroup> kq = new ArrayList<KhachHangGroup>();
		List<Object[]> khgs = criteria.list();
		for(Object[] item : khgs){
			kq.add(new KhachHangGroup(new Timestamp(((Date)item[0]).getTime()), (long)item[1]));
		}
		return kq;
	}

}
