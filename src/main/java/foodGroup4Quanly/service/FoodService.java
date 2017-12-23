package foodGroup4Quanly.service;

import foodGroup4Quanly.entity.Mon;

public interface FoodService {
	void save(Mon mon);
	void delete(int id);
	Mon getFood(int id);
	void update(Mon mon);
}
