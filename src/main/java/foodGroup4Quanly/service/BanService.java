package foodGroup4Quanly.service;

import java.util.List;

import foodGroup4Quanly.dto.BanDto;
import foodGroup4Quanly.entity.Ban;

public interface BanService {

	List<BanDto> getListTableByChiNhanh(int idChinhanh);

	Ban getInfoBan(int idBan);

	void saveBan(Ban ban);

	void delete(int idBan);

	void update(Ban b);
}
