<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
  <head>
  	<script src="resources/theme1/js/jquery-1.10.2.min.js"></script>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Purple Admin</title>
    <link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">
 <link href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />" rel="stylesheet">
     <link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/auth.scss" />" rel="stylesheet">
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js">
  

</script>
     <script src="<c:url value="/resources/theme1/js/off-canvas.js" />"></script>
    <script src="<c:url value="/resources/theme1/js/misc.js" />"></script>
    <script src="<c:url value="/resources/theme1/js/hoverable-collapse.js" />"></script> 
    <script src="<c:url value="/resources/theme1/js/vendor.bundle.base.js" />"></script> 
  
    <base href="${pageContext.servletContext.contextPath}/">
  </head>
  <body>
    <%-- <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
          <div class="row flex-grow">
            <div class="col-lg-4 mx-auto">
              <div class="auth-form-light text-left p-5">
                <div class="brand-logo">
                  <img src="resources/theme1/images/logo.svg">
                </div>
                <h4>Xin Chào !! Bắt Đầu Nào</h4>
                <h6 class="font-weight-light">Đăng nhập để tiếp tục</h6>
                <form action ="home/login.htm" class="pt-3"  method="post">
                  <div class="form-group">
                    <input type="text" class="form-control form-control-lg" name="Username"  placeholder="Username"/>
                  </div>
                  <div class="form-group">
                    <input   type="password" class="form-control form-control-lg" name="Pass" id="exampleInputPassword1" placeholder="Password"/>
                  </div>
                  <div class="mt-3">
                   <button class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn" > Đăng Nhập</button>
                   
                  </div>
                 
                  <div class="my-2 d-flex justify-content-between align-items-center">
                    <div class="form-check">
                      <label class="form-check-label text-muted">
                        <input type="checkbox" class="form-check-input"> Nhớ Mật Khẩu</label>
                    </div>
                    <a href="#" class="auth-link text-black">Quên Mật Khẩu</a>
                  </div>
                  <div class="mb-2">
                    <button type="button" class="btn btn-block btn-facebook auth-form-btn">
                      <i class="mdi mdi-facebook mr-2"></i>Đăng nhập bằng Facebook </button>
                  </div>
                  <div class="text-center mt-4 font-weight-light"> Bạn không có tài khoản <a href="register.html" class="text-primary">Tạo tài khoản</a>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
   
      </div>
   
    </div> --%>
  <div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
          <div class="row flex-grow">
            <div class="col-lg-6 d-flex align-items-center justify-content-center">
              <div class="auth-form-transparent text-left p-3">
                <div class="brand-logo">
                  <img src="resources/theme1/images/logo.svg" alt="logo">
                </div>
              
                <h4><s:message code="global.login.title"/></h4>
                <h6 class="font-weight-light"><s:message code="global.login.happy"/></h6>
                  <div class="dropdown">
                            <button type="button" class="btn btn-gradient-success dropdown-toggle" id="dropdownMenuIconButton4" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <i class="mdi mdi-heart"></i>
                            </button>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenuIconButton4">
                            <a class="dropdown-item" href="#" data-lang="en">English</a>
                              <a class="dropdown-item" href="#" data-lang="vi"> Việt Nam</a> 		

                             
                            </div>
                          </div>
                       <span  style="color: red;
    font-size: 13px;
    margin-top: 15px;" > ${message }</span>  
              <form:form action ="home/login.htm" class="pt-3"  method="post" modelAttribute="user">
                  <div class="form-group" style="margin-top: 20px">
                    <label for="exampleInputEmail"><s:message code="global.login.username"/></label>
                    <div class="input-group">
                      <div class="input-group-prepend bg-transparent">
                        <span class="input-group-text bg-transparent border-right-0">
                          <i class="mdi mdi-account-outline text-primary"></i>
                        </span>
                      </div>
                      <form:input path="username" type="text"  class="form-control form-control-lg border-left-0"  />                                 
                    </div>
                  </div>
                  <form:errors style="color: red;
    font-size: 13px;
    margin-top: 15px;"  path="username"/>
                  <div class="form-group" style="margin-top: 20px">
                    <label for="exampleInputPassword"><s:message code="global.login.password"/></label>
                    <div class="input-group">
                      <div class="input-group-prepend bg-transparent">
                        <span class="input-group-text bg-transparent border-right-0">
                          <i class="mdi mdi-lock-outline text-primary"></i>
                        </span>
                      </div>
                     
                      <form:input path="pass" type="Password"  class="form-control form-control-lg border-left-0" id="exampleInputPassword"/>               
                    </div>
                  </div>
                   <form:errors style="color: red;
    font-size: 13px;
    margin-top: 15px;" path="pass"/>
                  <div class="my-2 d-flex justify-content-between align-items-center">
                    <div class="form-check" class="form-group">
                      <label class="form-check-label text-muted">
                        <input type="checkbox" class="form-check-input"> <s:message code="global.login.keep"/><i class="input-helper"></i></label>
                    </div>
                    <a href="home/forgotpass.htm" class="auth-link text-black"><s:message code="global.login.forgot"/></a>
                  </div>
                  <div class="my-3">
                    <a  > <button class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"><s:message code="global.login"/></button></a>
                  </div>
                  <div class="mb-2 d-flex" class="form-group" style="margin-top: 20px">
                    <button type="button" class="btn btn-facebook auth-form-btn flex-grow mr-1">
                      <i class="mdi mdi-facebook mr-2"></i>Facebook </button>
                    <button type="button" class="btn btn-google auth-form-btn flex-grow ml-1">
                      <i class="mdi mdi-google mr-2"></i>Google </button>
                  </div>
                  <div class="text-center mt-4 font-weight-light"> <s:message code="global.login.dont"/> <a href="home/register.htm" class="text-primary"><s:message code="global.login.create"/></a>
                  </div>
                </form:form>
              </div>
            </div>
            <div class="col-lg-6 login-half-bg d-flex flex-row">
              <p class="text-white font-weight-medium text-center flex-grow align-self-end"><s:message code="global.login.copy"/></p>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
   

  	<script>
$(function(){
	$("a[data-lang]").click(function(){
		var lang = $(this).attr("data-lang");
		$.get("home/login.htm?language="+ lang, function(){
			location.reload();
		});
		return false;
	});
});
</script>
 
  </body>
</html>