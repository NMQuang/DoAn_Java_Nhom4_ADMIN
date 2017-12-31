package foodGroup4Quanly.pojo;

import java.sql.Timestamp;

public class KhachHangGroup {

	public KhachHangGroup(Timestamp ngayTao, long soLuong) {
		super();
		NgayTao = ngayTao;
		SoLuong = soLuong;
	}
	private Timestamp NgayTao;
	private long SoLuong;
	
	public Timestamp getNgayTao() {
		return NgayTao;
	}
	public void setNgayTao(Timestamp ngayTao) {
		NgayTao = ngayTao;
	}
	public long getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
}
