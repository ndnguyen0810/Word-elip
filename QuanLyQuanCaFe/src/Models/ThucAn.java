package Models;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ThucAn {

	// Constractor
	private int maTA;
	private String tenTA;
	private int gia;
	private String dVT;
	private int maLoai;

	public ThucAn(int maTA, String tenTA, int gia, String dVT, int maLoai) {
		super();
		this.maTA = maTA;
		this.tenTA = tenTA;
		this.gia = gia;
		this.dVT = dVT;
		this.maLoai = maLoai;
	}

	public ThucAn() {
		super();
	}

	public int getMaTA() {
		return maTA;
	}

	public void setMaTA(int maTA) {
		this.maTA = maTA;
	}

	public String getTenTA() {
		return tenTA;
	}

	public void setTenTA(String tenTA) {
		this.tenTA = tenTA;
	}

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
	}

	public String getdVT() {
		return dVT;
	}

	public void setdVT(String dVT) {
		this.dVT = dVT;
	}

	public int getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(int maLoai) {
		this.maLoai = maLoai;
	}

	// xử lý dữ liệu
	private Connection con = MyConnect.con;

	public void Insert(ThucAn ta) {
		try {
			String sql = String.format("insert into thucdon(tenta,gia,dvt,maloai)values ('%s',%d ,'%s',%d )",
					ta.getTenTA(), ta.getGia(), ta.getdVT(), ta.getMaLoai());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
			} else {
				JOptionPane.showConfirmDialog(null, "Thêm thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void Update(ThucAn ta) {
		try {
			String sql = String.format("update thucdon set tenta='%s', gia=%d, dvt='%s', maloai=%d where mata=%d",
					ta.getTenTA(), ta.getGia(), ta.getdVT(), ta.getMaLoai(), ta.getMaTA());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void Delete(ThucAn ta) {
		try {
			String sql = String.format("delete form thucdon where mata=%d )", ta.getMaTA());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showMessageDialog(null, "Xoá thành công");
			} else {
				JOptionPane.showMessageDialog(null, "Xoá thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<ThucAn> ShowTable(int key) {
		ArrayList<ThucAn> arrThucAn = null;
		String sql;
		if (key == 0) {
			sql = "Select * from thucdon, loaita where loaita.maloai=thucdon.mata";
		} else {
			sql = "Select * From thucdon Where maloai = " + key;
		}
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			arrThucAn = new ArrayList<ThucAn>();
			while (rs.next()) {
				ThucAn ta = new ThucAn(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				arrThucAn.add(ta);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Không lấy được danh sách thực đơn !");
		}
		return arrThucAn;
	}

}
