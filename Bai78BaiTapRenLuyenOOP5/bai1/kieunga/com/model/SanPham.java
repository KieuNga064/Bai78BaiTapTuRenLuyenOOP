package kieunga.com.model;

public class SanPham {
	private String maSanPham;
	private String tenSanPham;
	private double giaSanPham;
	private String xuatXu;
	
	
	public SanPham() {
		super();
	}
	public SanPham(String maSanPham, String tenSanPham, double giaSanPham, String xuatXu) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaSanPham = giaSanPham;
		this.xuatXu = xuatXu;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public double getGiaSanPham() {
		return giaSanPham;
	}
	public void setGiaSanPham(double giaSanPham) {
		this.giaSanPham = giaSanPham;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.maSanPham+" - "+this.tenSanPham;
	}
}
