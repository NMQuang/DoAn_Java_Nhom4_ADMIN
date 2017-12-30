package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.dto.BanDto;

public interface BanService {

	List<BanDto> getListTableByChiNhanh(int idChinhanh);

}
