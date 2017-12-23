package foodGroup4Quanly.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import foodGroup4Quanly.config.HibernateUtil;
import foodGroup4Quanly.entity.Chinhanh;

public interface BranchDao {

	public List<Chinhanh> getListChiNhanh();

	public void saveChiNhanh(Chinhanh chiNhanh);
}
