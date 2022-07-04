package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class HoaDon {
	private int maDH, maBan, giamgia, tongtien;
	private String thoiGian;

	public HoaDon(int maDH, int maBan, int giamgia, int tongtien, String thoiGian) {
		super();
		this.maDH = maDH;
		this.maBan = maBan;
		this.giamgia = giamgia;
		this.tongtien = tongtien;
		this.thoiGian = thoiGian;
	}

	public HoaDon() {
		super();
	}

	public int getMaDH() {
		return maDH;
	}

	public void setMaDH(int maDH) {
		this.maDH = maDH;
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	public int getGiamgia() {
		return giamgia;
	}

	public void setGiamgia(int giamgia) {
		this.giamgia = giamgia;
	}

	public int getTongtien() {
		return tongtien;
	}

	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	private Connection con=MyConnect.con;

	public void Insert(HoaDon h) {
		try {
			String sql = String.format("insert into hoadon(maban,gioden)values (%d,'%s')", h.getMaBan(),
					h.getThoiGian());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,  "Thêm thành công");
			} else {
				JOptionPane.showMessageDialog(null,  "Thêm thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

//	public void Update(HoaDon h) {
//		try {
//			String sql = String.format("insert into hoadon(maban,thoigian)values (%d,'%s')", h.getMaBan(), h.getThoiGian());
//			PreparedStatement s = con.prepareStatement(sql);
//			if (s.executeUpdate() > 0) {
//				JOptionPane.showMessageDialog(null,  "Thêm thành công");
//			} else {
//				JOptionPane.showMessageDialog(null,  "Thêm thất bại");
//			}
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//	}
	
	public int GetMaHD_ByMa(int ma){
        String sql;
        int mahd = 0;
            sql = "Select mahd From hoadon Where MaBan ="+ma;
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                mahd = rs.getInt(1);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
        }
        return mahd;        
    } 

	public void Delete(HoaDon h) {
		try {
			String sql = String.format("delete from hoadon where mahd=%d", h.getMaDH());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null,  "Xoá thành công");
			} else {
				JOptionPane.showMessageDialog(null,  "Xoá thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public HoaDon GetHDbyMaBan(int ma) {
		String sql;
		HoaDon arrhd = null;
		sql = String.format("select * from hoadon where maban=%d", ma);
		System.err.println(sql);
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				arrhd = new HoaDon(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không lấy được danh sách hóa đơn !");
		}
		return arrhd;
	}
}
