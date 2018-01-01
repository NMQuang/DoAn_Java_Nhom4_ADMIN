package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.entity.Chinhanh;

public interface ChiNhanhService {

	List<Chinhanh> getListChiNhanh();

	Chinhanh getInfoBranch(int branchID);

}
