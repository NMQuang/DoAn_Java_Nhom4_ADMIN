package foodGroup4Quanly.dao;

import java.util.List;

import foodGroup4Quanly.entity.Mon;


public interface FoodDAO {
   void save(Mon mon);
   void delete(int id);
   int getCountFood(boolean active);
List<Mon> getList(int maxResult, int begin, boolean active);
}
