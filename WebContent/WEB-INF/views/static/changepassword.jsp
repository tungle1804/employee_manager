<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="/resources/theme1/css/style.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />"
	rel="stylesheet">
		 <link href="<c:url value="/resources/theme1/css/reset.css" />"
	 
	rel="stylesheet">
	 <link href="<c:url value="/resources/theme1/css/colcade.scss" />"
	 
	rel="stylesheet">
	 <link href="<c:url value="/resources/theme1/css/reboot.scss" />"
	 
	rel="stylesheet">
	 <link href="<c:url value="/resources/theme1/css/card.scss" />"
	 
	rel="stylesheet">
	 <link href="<c:url value="/resources/theme1/css/vertical.scss" />"
	 
	rel="stylesheet">
		 <link href="<c:url value="/resources/theme1/css/pagination.scss" />"
	 
	rel="stylesheet">
</head>
<body>

                       
                     <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Đổi mật khẩu </h4>
                    <p class="card-description"> Vui Lòng Điển Thông Tin </p>
                    <form class="forms-sample">
                      
                      <div class="form-group">
                        <label for="exampleInputEmail1">Mật khẩu cũ</label>
                        <input  name="mkcu" type="password" class="form-control" id="exampleInputFullname" placeholder="Password"/>
                      </div>
                      <span style="color: red;
    font-size: 13px;
    margin-top: 15px;"></span>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Mật khẩu mới</label>
                        <input name="mkmoi" type="password" class="form-control" id="exampleInputPassword1" placeholder=" New Password"/>
                      </div>
                      <span style="color: red;
    font-size: 13px;
    margin-top: 15px;"></span>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Xác nhận lại mật khẩu mới</label>
                        <input name="xacnhanmkmoi" type="password" class="form-control" id="exampleInputPassword1" placeholder="Confirm Password"/>
                      </div>
                      <span style="color: red;
    font-size: 13px;
    margin-top: 15px;"></span>
                     <%-- <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Role</label>
                            <div class="col-sm-4">
                              <div class="form-check">
                                <label class="form-check-label">
                                  <form:radiobutton   class="form-check-input" name="membershipRadios" id="membershipRadios1" value="0"   path="role"/> Admin <i class="input-helper"></i></label>
                              </div>
                            </div>
                            <div class="col-sm-5">
                              <div class="form-check">
                                <label class="form-check-label">
                                  <form:radiobutton  class="form-check-input" name="membershipRadios" id="membershipRadios2" value="1"  path="role"/> Normal <i class="input-helper"></i></label>
                              </div>
                            </div>
                          </div> --%>
                      <div class="form-check form-check-flat form-check-primary">
                        <label class="form-check-label">
                          <input type="checkbox" class="form-check-input"> Remember me </label>
                      </div>
                     <button type="submit" class="btn btn-gradient-primary mr-2"  >edit</button>
                      <button class="btn btn-light">Cancel</button>
                    </form>
                  </div>
                </div>
                      
                       
                  
</body>
</html>