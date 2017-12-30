package foodGroup4Quanly.dao;

import java.util.List;

import foodGroup4Quanly.dto.BanDto;

public interface BanDao {

	List<BanDto> getListTableByChiNhanh(int idChinhanh);

}
