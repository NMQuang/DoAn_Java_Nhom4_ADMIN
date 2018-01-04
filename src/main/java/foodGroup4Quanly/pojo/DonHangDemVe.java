package foodGroup4Quanly.pojo;

import java.util.List;

public class DonHangDemVe {

	private List<ChiTietHoaDonCustom> listChiTiet;
	private String ten_nguoi_nhan;
	
	public List<ChiTietHoaDonCustom> getListChiTiet() {
		return listChiTiet;
	}
	public void setListChiTiet(List<ChiTietHoaDonCustom> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}
	public String getTen_nguoi_nhan() {
		return ten_nguoi_nhan;
	}
	public void setTen_nguoi_nhan(String ten_nguoi_nhan) {
		this.ten_nguoi_nhan = ten_nguoi_nhan;
	}
}
