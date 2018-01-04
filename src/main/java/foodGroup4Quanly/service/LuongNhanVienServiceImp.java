package foodGroup4Quanly.service;

import foodGroup4Quanly.dao.LuongChoNhanVienDao;
import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class LuongNhanVienServiceImp implements LuongNhanVienService {

    @Autowired
    LuongChoNhanVienDao luongChoNhanVienDao;

    @Override
    public List<TongLuongNhanVienTheoThangDto> getTongLuongTheoThang(String strYear, int idChiNhanh) {
        List<TongLuongNhanVienTheoThangDto> listTongLuong =
                luongChoNhanVienDao.getListTongLuongTheoThang(strYear, idChiNhanh);
        return listTongLuong;
    }
}
