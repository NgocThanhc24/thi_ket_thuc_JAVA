package servlet;

import dao.SanPhamDAO;
import dao.TheLoaiDAO;
import model.SanPham;
import model.TheLoai;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductServlet", urlPatterns = {"/san-pham"})
public class ProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String maLoaiParam = request.getParameter("maloai");
        int maLoai;
        
        
        if (maLoaiParam == null || maLoaiParam.isEmpty()) {
            maLoai = 1; 
        } else {
            try {
                maLoai = Integer.parseInt(maLoaiParam);
            } catch (NumberFormatException e) {
                maLoai = 1; 
            }
        }
        
        TheLoaiDAO theLoaiDAO = new TheLoaiDAO();
        SanPhamDAO sanPhamDAO = new SanPhamDAO();
        
        
        List<TheLoai> listTheLoai = theLoaiDAO.getAllTheLoai();
        
        
        TheLoai theLoaiHienTai = theLoaiDAO.getTheLoaiById(maLoai);
        
      
        List<SanPham> listSanPham = sanPhamDAO.getSanPhamByMaLoai(maLoai);
        
       
        int soLuong = sanPhamDAO.countSanPhamByMaLoai(maLoai);
        
        request.setAttribute("listTheLoai", listTheLoai);
        request.setAttribute("theLoaiHienTai", theLoaiHienTai);
        request.setAttribute("listSanPham", listSanPham);
        request.setAttribute("soLuong", soLuong);
        request.setAttribute("maLoaiHienTai", maLoai);
        
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

