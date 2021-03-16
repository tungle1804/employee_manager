<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
	<link
	href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />"
	rel="stylesheet">

</head>
<body>
<div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth multi-step-login">
          <div class="row w-100">
           <div class="col-md-5 mx-auto py-5">
               <form class="step-form" id="msform">
 <fieldset class="text-center" style="display: block; left: 0%; opacity: 1;">
                  <p class="font-weight-bold">Created sucessfully</p>
                  <i class="mdi mdi-shield-check text-warning icon-lg"></i>
                   <h4 class="font-weight-bold">${email}</h4>
               
                </fieldset>
                </form>
                </div>
                </div>
                </div>
                </div>
                </div>
</body>
</html>