package kieunga.com.model;

import java.sql.Array;
import java.util.ArrayList;

public class DanhMucSanPham {
	private String maDanhMuc;
	private String tenDanhMuc;
	private ArrayList<SanPham> dsSP;
	
	
	public void xuatXuTrungQuoc()
	{
		for(SanPham sp:dsSP)
		{
			if((sp.getXuatXu().trim()).compareToIgnoreCase("trung quốc")==0)
			{
				System.out.println(sp);
			}
		}
	}
	
	public double tinhTongGiaTri()
	{
		double sum=0;
		for(SanPham sp:dsSP)
		{
			sum+=sp.getGiaSanPham();
		}
		return sum;
	}
	
	public SanPham timSanPham(String ma)
	{
		for (SanPham p:dsSP) 
		{			
			if(p.getMaSanPham().compareTo(ma)==0)
				return p;				
		}
		return null;
	}
	
	public void addSanPham(SanPham sp)
	{
		dsSP.add(sp);
	}
	
	public void removeSanPham(SanPham sp)
	{
		dsSP.remove(sp);
	}
	
	public void xuatDSSanPham()
	{
		for(SanPham p:dsSP)
			System.out.println(p);
	}
	public DanhMucSanPham(String maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.dsSP=new ArrayList<SanPham>();
	}
	public String getMaDanhMuc() {
		return maDanhMuc;
	}
	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}
	public String getTenDanhMuc() {
		return tenDanhMuc;
	}
	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}
	public DanhMucSanPham() {
		super();
		this.dsSP=new ArrayList<SanPham>();
	}
	@Override
	public String toString() {		
		return this.getMaDanhMuc()+"-"+this.getTenDanhMuc();
	}
	
}
