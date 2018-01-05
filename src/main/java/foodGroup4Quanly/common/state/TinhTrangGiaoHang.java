package foodGroup4Quanly.common.state;

public class TinhTrangGiaoHang {
    public static final int DANG_XU_LY = 0;
    public static final int DANG_CHE_BIEN = 1;
    public static final int DANG_GIAO_HANG = 2;
    public static final int DA_GIAO_HANG = 3;
    public static final int CHO_CHE_BIEN = 4;

    public static String codeToString(int code) {
        switch (code) {
            case DANG_XU_LY:
                return "Đang xử lý";
            case DANG_CHE_BIEN:
                return "Đang chế biến";
            case DANG_GIAO_HANG:
                return "Đang giao hàng";
            case  DA_GIAO_HANG:
                return "Đã giao hàng";
            case CHO_CHE_BIEN:
            	return "Chờ chế biến";
        }
        return "Không rõ tình trạng";
    }
}
