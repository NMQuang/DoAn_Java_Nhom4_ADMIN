package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.entity.Mon;

public interface FoodService {
	void save(Mon mon);
	void delete(int id);
	Mon getFood(int id);
	void update(Mon mon);
	int getCountFood(boolean active);
	List<Mon> getList(int maxResult, int begin, boolean active);
}
