package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ban {
	private int maBan;
	private String tenBan, trangThai;

	public Ban(int maBan, String tenBan, String trangThai) {
		super();
		this.maBan = maBan;
		this.tenBan = tenBan;
		this.trangThai = trangThai;
	}

	public Ban() {
		super();
	}

	public int getMaBan() {
		return maBan;
	}

	public void setMaBan(int maBan) {
		this.maBan = maBan;
	}

	public String getTenBan() {
		return tenBan;
	}

	public void setTenBan(String tenBan) {
		this.tenBan = tenBan;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return this.tenBan;
	}

	// xu ly
	private Connection con = MyConnect.con;
	public void Insert(Ban b) {
		try {
			String sql = String.format("insert into ban (tenban,trangthai) values ('%s', '%s')", b.getTenBan(),
					b.getTrangThai());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showInternalMessageDialog(null, "Thêm thành công");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Thêm thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void UpdateBan(Ban b) {
		try {
			String sql = String.format("update ban set tenban='%s' where maban=%d", b.getTenBan(), b.getMaBan());

			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showInternalMessageDialog(null, "Cập nhật bàn thành công");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Cập nhật bàn thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void UpdateTrangThaiBan(Ban b) {
		try {
			String sql = String.format("update ban set trangthai='%s' where maban=%d", b.getTrangThai(), b.getMaBan());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showInternalMessageDialog(null, "Cập nhật trạng thái bàn thành công");
			} else {
				JOptionPane.showInternalMessageDialog(null, "Cập nhật trạng thái bàn thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void Delete(Ban b) {
		try {
			String sql = String.format("delete form ban where maban= %d)", b.getMaBan());
			PreparedStatement s = con.prepareStatement(sql);
			if (s.executeUpdate() > 0) {
				JOptionPane.showConfirmDialog(null, "Xoá bàn thành công");
			} else {
				JOptionPane.showConfirmDialog(null, "Xoá bàn thất bại");
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public ArrayList<Ban> ShowBan(int maban) {
		ArrayList<Ban> arrBan = null;
		String sql;
		if (maban == 0)
			sql = "Select * From ban";
		else
			sql = "Select * From ban Where MaBan = " + maban;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			arrBan = new ArrayList<Ban>();
			while (rs.next()) {
				Ban b = new Ban(rs.getInt(1), rs.getString(2), rs.getString(3));
				arrBan.add(b);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi !");
		}
		return arrBan;
	}
	
}
