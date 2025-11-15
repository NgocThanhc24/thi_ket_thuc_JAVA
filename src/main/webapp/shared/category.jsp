<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="card mb-3">
    <h3 class="card-header">Category</h3>  
        <div class="list-group">
            <c:forEach var="tl" items="${listTheLoai}">
                <a href="san-pham?maloai=${tl.maLoai}" 
                   class="list-group-item list-group-item-action ${maLoaiHienTai == tl.maLoai ? 'active' : ''}">
                    <i class="bi bi-arrow-right-circle"></i> ${tl.tenLoai}
                </a>
            </c:forEach>
       </div>
</div>
