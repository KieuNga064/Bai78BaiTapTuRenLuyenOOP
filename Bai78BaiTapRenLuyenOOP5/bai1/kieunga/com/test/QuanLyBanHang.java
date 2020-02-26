package kieunga.com.test;

import java.util.ArrayList;
import java.util.Scanner;

import kieunga.com.model.DanhMucSanPham;
import kieunga.com.model.Functions;

public class QuanLyBanHang {

	public static Functions ft=new Functions();
	
	public static void main(String[] args) {
		System.out.println("Chào mừng bạn đến với chương trình quản lý bán hàng!");
		while(true)
		{
			menu();
		}
	}
	static void menu()
	{
		System.out.println("Mời bạn chọn chức năng:");
		System.out.println("1. Tạo danh mục sản phẩm.");
		System.out.println("2. Thêm sản phẩm.");
		System.out.println("3. Xuất danh sách sản phẩm.");
		System.out.println("4. Cập nhật thông tin sản phẩm.");
		System.out.println("5. Xóa sản phẩm.");
		System.out.println("6. Thống kê tổng giá trị của sản phẩm.");
		System.out.println("7. Xuất các sản phẩm xuất xứ Trung Quốc.");
		System.out.println("8. Thoát.");
		int kq=new Scanner(System.in).nextInt();
		switch (kq) {
		case 1:
			ft.taoDanhMuc();
			break;
		case 2:
			ft.themSanPham();
			break;
		case 3: 
			ft.xuatDanhSachSanPham();
			break;
		case 4:
			ft.capNhatThongTinSanPham();
			break;
		case 5:
			ft.xoaSanPham();
			break;
		case 6:
			ft.thongKeGiaTri();
			break;
		case 7:
			ft.xuatXuTrungQuoc();
			break;
		case 8:
			System.out.println("Cảm ơn bạn đã sử dụng phần mềm.");
			System.exit(0);
			
		default:
			System.out.println("Không tồn tại chức năng " + kq+" mời bạn chọn lại.");
		}
	}

}
