package foodGroup4Quanly.dao;

import java.util.List;

import foodGroup4Quanly.entity.Chinhanh;

public interface ChiNhanhDao {

	List<Chinhanh> getListBranch();

	Chinhanh getInfoBranch(int branchID);

}
