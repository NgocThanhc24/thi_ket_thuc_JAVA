package dao;

import context.DbContext;
import model.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {
    
    public List<SanPham> getSanPhamKhuyenMai(int limit) {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT TOP (?) * FROM SanPham WHERE KhuyenMai = 1 ORDER BY DonGia ASC";
        
        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, limit);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getNString("TenSP"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setHinh(rs.getString("Hinh"));
                sp.setMaLoai(rs.getInt("MaLoai"));
                sp.setNgayCapNhat(rs.getDate("NgayCapNhat"));
                sp.setKhuyenMai(rs.getBoolean("KhuyenMai"));
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public List<SanPham> getSanPhamByMaLoai(int maLoai) {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE MaLoai = ?";
        
        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maLoai);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getInt("MaSP"));
                sp.setTenSP(rs.getNString("TenSP"));
                sp.setDonGia(rs.getDouble("DonGia"));
                sp.setHinh(rs.getString("Hinh"));
                sp.setMaLoai(rs.getInt("MaLoai"));
                sp.setNgayCapNhat(rs.getDate("NgayCapNhat"));
                sp.setKhuyenMai(rs.getBoolean("KhuyenMai"));
                list.add(sp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public int countSanPhamByMaLoai(int maLoai) {
        String sql = "SELECT COUNT(*) FROM SanPham WHERE MaLoai = ?";
        
        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maLoai);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return 0;
    }
}

