package foodGroup4Quanly.service;

import foodGroup4Quanly.dto.TongLuongNhanVienTheoThangDto;
import foodGroup4Quanly.entity.Chinhanh;

import java.util.List;

public interface LuongNhanVienService {

    List<TongLuongNhanVienTheoThangDto> getTongLuongTheoThang(String strYear, int idChiNhanh);
}
