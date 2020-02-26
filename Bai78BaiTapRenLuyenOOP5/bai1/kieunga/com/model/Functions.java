package kieunga.com.model;


import java.util.ArrayList;
import java.util.Scanner;




public class Functions {
	public static ArrayList<DanhMucSanPham> dsDanhMuc=new ArrayList<DanhMucSanPham>();
	
	//thêm gạch phân cách
	private DanhMucSanPham timDanhMuc(String ma)
	{
		for(DanhMucSanPham dm:dsDanhMuc)
		{
			if(dm.getMaDanhMuc().compareTo(ma)==0)
			{
				return dm;
			}
		}
		return null;
	}
	
	private void xuatDanhSachDanhMuc()
	{
		for(DanhMucSanPham dm:dsDanhMuc)
			System.out.println(dm);
	}
		
	public void taoDanhMuc()
	{

		System.out.println("Mời bạn nhập mã danh mục: ");
		String maDanhMuc=new Scanner(System.in).nextLine();
		DanhMucSanPham dm=timDanhMuc(maDanhMuc);
			while(dm!=null)
			{
			System.out.println("Trùng mã danh mục, mời nhập lại:");
			maDanhMuc=new Scanner(System.in).nextLine();
			dm=timDanhMuc(maDanhMuc);
			}
		System.out.println("Mời bạn nhập tên danh mục:");
		String tenDanhMuc=new Scanner(System.in).nextLine();
		dm=new DanhMucSanPham(maDanhMuc,tenDanhMuc);
		dsDanhMuc.add(dm);
		System.out.println("Tạo danh mục thành công.");
	}
	
	//thêm t/h nhập trùng mã
	public void themSanPham() {
		System.out.println("Các danh mục đã nhập: ");
		xuatDanhSachDanhMuc();
		System.out.println("Mời bạn nhập mã danh mục cần thêm: ");
		String maDanhMuc=new Scanner(System.in).nextLine();
		DanhMucSanPham dmCanThem=timDanhMuc(maDanhMuc);
		while(dmCanThem==null)
		{
			System.out.println("Không tồn tại danh mục trên mời bạn nhập lại:");
			maDanhMuc=new Scanner(System.in).nextLine();
			dmCanThem=timDanhMuc(maDanhMuc);
		}
		System.out.println("Mời bạn nhập mã sản phẩm:");
		String ma=new Scanner(System.in).nextLine();
		System.out.println("Mời bạn nhập tên sản phẩm:");
		String ten=new Scanner(System.in).nextLine();
		System.out.println("Mời bạn nhập giá sản phẩm:");
		double gia=new Scanner(System.in).nextDouble();
		System.out.println("Mời bạn nhập xuất xứ sản phẩm: ");
		String xuatXu=new Scanner(System.in).nextLine();
		SanPham sp=new SanPham(ma,ten, gia,xuatXu);
		dmCanThem.addSanPham(sp);
		System.out.println("Thêm sản phẩm thành công.");
	}
	
	public void xuatDanhSachSanPham() {
		System.out.println("Các danh mục đã nhập:");
		xuatDanhSachDanhMuc();
		System.out.println("Mời bạn nhập mã danh mục muốn xuất:");
		String ma=new Scanner(System.in).nextLine();
		DanhMucSanPham dmCanXuat=timDanhMuc(ma);
		while(dmCanXuat==null)
		{
			System.out.println("Không tìm thấy danh mục trên, mời bạn nhập lại:");
			ma=new Scanner(System.in).nextLine();
			dmCanXuat=timDanhMuc(ma);
		}
		System.out.println("Danh sách sản phẩm thuộc danh mục mã ["+dmCanXuat.getMaDanhMuc()+
				"], tên ["+dmCanXuat.getTenDanhMuc()+"]:");
		dmCanXuat.xuatDSSanPham();		
	}
	
	public void capNhatThongTinSanPham() {
		System.out.println("Các danh mục hiện có: ");
		xuatDanhSachDanhMuc();
		System.out.println("Mời bạn nhập mã danh mục chứa sản phẩm cần cập nhật:");
		String maDanhMuc=new Scanner(System.in).nextLine();
		DanhMucSanPham dmCanSua=timDanhMuc(maDanhMuc);
		while(dmCanSua==null)
		{
			System.out.println("Không tồn tại danh mục có mã ["+maDanhMuc+"] mời bạn nhập lại:");
			maDanhMuc=new Scanner(System.in).nextLine();
			dmCanSua=timDanhMuc(maDanhMuc);
		}
		System.out.println("Các sản phẩm thuộc danh mục ["+maDanhMuc+"] - ["+dmCanSua.getTenDanhMuc()+"]:");
		dmCanSua.xuatDSSanPham();
		System.out.println("Mời bạn nhập mã sản phẩm cần sửa:");
		String maSP=new Scanner(System.in).nextLine();
		SanPham spCanSua=dmCanSua.timSanPham(maSP);
		while(spCanSua==null)
		{
			System.out.println("Không tồn tại sản phẩm có mã ["+maSP+"] mời bạn nhập lại:");
			maSP=new Scanner(System.in).nextLine();
			spCanSua=dmCanSua.timSanPham(maSP);
		}
		boolean thoat=false;
		while(thoat==false)
		{
		System.out.println("Mời bạn chọn thuộc tính cần sửa:");
		System.out.println("1. Mã");
		System.out.println("2. Tên");
		System.out.println("3. Giá");
		System.out.println("4. Xuất xứ");
		System.out.println("5. Thoát");
		int kq=new Scanner(System.in).nextInt();
		switch (kq) {
		case 1:
			System.out.println("Mời bạn nhập mã mới:");
			String maMoi=new Scanner(System.in).nextLine();
			while((dmCanSua.timSanPham(maMoi))!=null)
			{
				System.out.println("Đã tồn tại sản phẩm có mã ["+maMoi+"] mời bạn nhập lại:");
				maMoi=new Scanner(System.in).nextLine();
			}
			spCanSua.setMaSanPham(maMoi);
			break ;
		case 2:
			System.out.println("Mời bạn nhập tên mới: ");
			String tenMoi=new Scanner(System.in).nextLine();
			spCanSua.setTenSanPham(tenMoi);
			break;
		case 3:
			System.out.println("Mời bạn nhập giá mới:");
			double giaMoi=new Scanner(System.in).nextDouble();
			spCanSua.setGiaSanPham(giaMoi);
			break;
		case 4:
			System.out.println("Mời bạn nhập xuất xứ mới:");
			String xuatXuMoi=new Scanner(System.in).nextLine();
			spCanSua.setXuatXu(xuatXuMoi);
			break;
		case 5:
			thoat=true;
			break;
		default:
			System.out.println("Nhập sai.");
		}
		}		
	}
	
	public void xoaSanPham() {
		System.out.println("Các danh mục hiện có: ");
		xuatDanhSachDanhMuc();
		System.out.println("Mời bạn nhập mã danh mục chứa sản phẩm cần xóa:");
		String maDanhMuc=new Scanner(System.in).nextLine();
		DanhMucSanPham dmCanXoa=timDanhMuc(maDanhMuc);
		while(dmCanXoa==null)
		{
			System.out.println("Không tồn tại danh mục có mã ["+maDanhMuc+"] mời bạn nhập lại:");
			maDanhMuc=new Scanner(System.in).nextLine();
			dmCanXoa=timDanhMuc(maDanhMuc);
		}
		System.out.println("Các sản phẩm thuộc danh mục ["+maDanhMuc+"] - ["+dmCanXoa.getTenDanhMuc()+"]:");
		dmCanXoa.xuatDSSanPham();
		System.out.println("Mời bạn nhập mã sản phẩm cần sửa:");
		String maSP=new Scanner(System.in).nextLine();
		SanPham spCanXoa=dmCanXoa.timSanPham(maSP);
		while(spCanXoa==null)
		{
			System.out.println("Không tồn tại sản phẩm có mã ["+maSP+"] mời bạn nhập lại:");
			maSP=new Scanner(System.in).nextLine();
			spCanXoa=dmCanXoa.timSanPham(maSP);
		}
		dmCanXoa.removeSanPham(spCanXoa);
		System.out.println("Xóa thành công sản phẩm "+spCanXoa);
		
	}
	
	//thêm thống kê theo danh mục
	public void thongKeGiaTri() {
		double sum=0;
		for(DanhMucSanPham dm:dsDanhMuc)
		{
			sum+=dm.tinhTongGiaTri();
		}
		System.out.println("Tổng giá trị sản phẩm là: "+sum);
	}
	
	public void xuatXuTrungQuoc() {
		System.out.println("Các sản phẩm xuất xứ Trung Quốc là:");		
		for(DanhMucSanPham dm:dsDanhMuc)
		{
			dm.xuatXuTrungQuoc();
		}
		
	}
}
