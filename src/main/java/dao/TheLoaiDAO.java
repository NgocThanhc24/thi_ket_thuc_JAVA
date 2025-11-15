package dao;

import context.DbContext;
import model.TheLoai;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TheLoaiDAO {
    
    public List<TheLoai> getAllTheLoai() {
        List<TheLoai> list = new ArrayList<>();
        String sql = "SELECT * FROM TheLoai";
        
        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                TheLoai theLoai = new TheLoai();
                theLoai.setMaLoai(rs.getInt("MaLoai"));
                theLoai.setTenLoai(rs.getNString("TenLoai"));
                list.add(theLoai);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public TheLoai getTheLoaiById(int maLoai) {
        String sql = "SELECT * FROM TheLoai WHERE MaLoai = ?";
        
        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, maLoai);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                TheLoai theLoai = new TheLoai();
                theLoai.setMaLoai(rs.getInt("MaLoai"));
                theLoai.setTenLoai(rs.getNString("TenLoai"));
                return theLoai;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}

