package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.dao.FoodDAO;
import foodGroup4Quanly.dao.FoodDAOImp;
import foodGroup4Quanly.entity.Mon;

@Component
@Transactional
public class FoodServiceImp implements FoodService{
	@Autowired
	FoodDAO foodDao;

	@Override
	public void save(Mon mon) {
		foodDao.save(mon);
	}
	
	@Override
	public void delete(int id) {
		foodDao.delete(id);
	}
	
	@Override
	public Mon getFood(int id) {
		// TODO Auto-generated method stub
		return ((HibernateUtil)(FoodDAOImp)foodDao).fetchById(id, Mon.class);
	}

	@Override
	public void update(Mon mon) {
		((HibernateUtil)foodDao).update(mon);
	}

	@Override
	public int getCountFood(boolean active) {
		return foodDao.getCountFood(active);
	}

	@Override
	public List<Mon> getList(int maxResult, int begin, boolean active) {
		return foodDao.getList(maxResult, begin, active);
	}
}
