<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
 <link href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/auth.scss" />" rel="stylesheet">
</head>
<body>
<div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center text-center error-page bg-primary">
          <div class="row flex-grow">
            <div class="col-lg-7 mx-auto text-white">
              <div class="row align-items-center d-flex flex-row">
                <div class="col-lg-6 text-lg-right pr-lg-4">
                  <h1 class="display-1 mb-0">404</h1>
                </div>
                <div class="col-lg-6 error-page-divider text-lg-left pl-lg-4">
                  <h2>${Alert}!</h2>
                 
                  <h3 class="font-weight-light">Đã có lỗi xảy ra</h3>
                </div>
              </div>
              <div class="row mt-5">
                <div class="col-12 text-center mt-xl-2">
                  <a class="text-white font-weight-medium" href="../../index.html">Quay lại</a>
                </div>
              </div>
              <div class="row mt-5">
                <div class="col-12 mt-xl-2">
                  <p class="text-white font-weight-medium text-center">Copyright © 2018 All rights reserved.</p>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
       
</body>
</html>