package foodGroup4Quanly.service;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.FoodDAO;
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
}
