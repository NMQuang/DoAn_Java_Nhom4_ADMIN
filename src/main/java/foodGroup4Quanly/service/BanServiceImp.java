package foodGroup4Quanly.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import foodGroup4Quanly.dao.BanDao;
import foodGroup4Quanly.dto.BanDto;
import foodGroup4Quanly.entity.Ban;

@Component
@Transactional
public class BanServiceImp implements BanService {

	@Autowired
	public BanDao banDao;

	@Override
	public List<BanDto> getListTableByChiNhanh(int idChinhanh) {
		List<BanDto> list = banDao.getListTableByChiNhanh(idChinhanh);

		if (list.size() > 0 && list != null) {
			return list;
		}
		return null;
	}

	@Override
	public Ban getInfoBan(int idBan) {
		return banDao.getInfoBan(idBan);
	}

	@Override
	public void saveBan(Ban ban) {
		banDao.saveBan(ban);
	}

	@Override
	public void delete(int idBan) {
		banDao.delete(idBan);
	}

	@Override
	public void update(Ban b) {
		banDao.update(b);
	}
}
