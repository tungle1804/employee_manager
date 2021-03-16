<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<div class="content-wrapper" >
<div class="row" id="proBanner" style="margin-top: 50px" >
						<div class="col-12" >
							<span class="d-flex align-items-center purchase-popup">
								<p>Chào mừng đến với thế giới của Tunganhle</p> <a
								href="https://www.bootstrapdash.com/product/purple-bootstrap-admin-template?utm_source=organic&utm_medium=banner&utm_campaign=free-preview"
								target="_blank"
								class="btn download-button purchase-button ml-auto">Tìm Hiểu Thêm</a> <i class="mdi mdi-close" id="bannerClose"></i>
									
							</span>
						</div>
					</div>
					</div> <br> <br>
						<c:if test="${Alert != null}">
										<div id="alert" class="alert alert-primary" role="alert">
 											   <i class="mdi mdi-alert-circle"></i>${Alert}
										</div>
								</c:if>		
</body>
</html>