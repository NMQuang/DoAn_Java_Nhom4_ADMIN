package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.entity.Chinhanh;

public interface BranchService {


	public List<Chinhanh> getListChiNhanh();

	public void saveChiNhanh(Chinhanh chiNhanh);

	public Chinhanh getInfoChiNhanh(int idChinhanh);
}
