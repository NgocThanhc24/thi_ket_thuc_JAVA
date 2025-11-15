<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<jsp:include page="shared/header.jsp" />

<jsp:include page="shared/nav.jsp" />
<section class="bg-body-secondary text-center">
    <div class="container">
        <h1 class="jumbotron-heading text-muted">SIÊU THỊ GIÀY</h1>
        <p class="lead text-muted mb-0">CHUYÊN CUNG CẤP GIÀY THỂ THAO SỐ 1 TẠI VIỆT NAM</p>
    </div>
</section>
<div class="container" id="main-content">
    <div class="row">
        <div class="col-sm-2">
            <jsp:include page="shared/category.jsp" />             
        </div>
        <div class="col-sm-10">          
            <div class="row">                 
                <div class="col-sm-12">
                    <h4 class="alert alert-primary">Thể loại giày ${selectedTheLoai.tenLoai} có ${count} sản phẩm</h4>
                    <div class="row">   
                        <c:forEach var="sp" items="${listSanPham}">
                            <div class="col-12 col-md-6 col-lg-4">
                                <div class="card mb-2">
                                    <div class="card-header">
                                        ${sp.tenSP}
                                    </div>
                                    <div class="card-body">
                                        <img class="card-img" src="assets/images/products/${sp.hinh}" alt="${sp.tenSP}">                         
                                    </div>
                                    <div class="card-footer">
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-danger btn-block"><fmt:formatNumber value="${sp.donGia}" type="number" pattern="#,###"/> đ</p>
                                            </div>
                                            <div class="col">
                                                <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>              
                            </div>
                        </c:forEach>
                    </div>                       
                </div>
            </div>              
        </div>
    </div>
</div>
<jsp:include page="shared/footer.jsp" />