package foodGroup4Quanly.pojo;

import java.util.List;

public class DonHangTongDai {

	private String ten_khach_hang;
	private String sdt_khach ;
	private String sdt_nguoi_nhan;

	public String getTen_khach_hang() {
		return ten_khach_hang;
	}
	public void setTen_khach_hang(String ten_khach_hang) {
		this.ten_khach_hang = ten_khach_hang;
	}
	public String getSdt_khach() {
		return sdt_khach;
	}
	public void setSdt_khach(String sdt_khach) {
		this.sdt_khach = sdt_khach;
	}
	public String getSdt_nguoi_nhan() {
		return sdt_nguoi_nhan;
	}
	public void setSdt_nguoi_nhan(String sdt_nguoi_nhan) {
		this.sdt_nguoi_nhan = sdt_nguoi_nhan;
	}
	public String getHo_ten_nguoi_nhan() {
		return ho_ten_nguoi_nhan;
	}
	public void setHo_ten_nguoi_nhan(String ho_ten_nguoi_nhan) {
		this.ho_ten_nguoi_nhan = ho_ten_nguoi_nhan;
	}
	public String getDia_chi_nhan() {
		return dia_chi_nhan;
	}
	public void setDia_chi_nhan(String dia_chi_nhan) {
		this.dia_chi_nhan = dia_chi_nhan;
	}
	public int getId_Chinhanh() {
		return id_Chinhanh;
	}
	public void setId_Chinhanh(int id_Chinhanh) {
		this.id_Chinhanh = id_Chinhanh;
	}
	public List<ChiTietHoaDonCustom> getListChiTiet() {
		return listChiTiet;
	}
	public void setListChiTiet(List<ChiTietHoaDonCustom> listChiTiet) {
		this.listChiTiet = listChiTiet;
	}
	private String ho_ten_nguoi_nhan ;
	private String dia_chi_nhan ;
	private int id_Chinhanh ;
	private List<ChiTietHoaDonCustom> listChiTiet ;
}
