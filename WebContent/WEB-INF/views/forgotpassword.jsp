<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="<c:url value="/resources/theme1/css/style.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />"
	rel="stylesheet">
<link
	href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />"
	rel="stylesheet">
	 <link href="<c:url value="/resources/theme1/css/jsgrid.min.css" />"
	rel="stylesheet"> 
	 <link href="<c:url value="/resources/theme1/css/jsgrid-theme.min.css" />"
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
		 <link href="<c:url value="/resources/theme1/css/dataTables.bootstrap4.css" />"
	 
	rel="stylesheet">
	<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js">
 
</script>

<base href="${pageContext.servletContext.contextPath}/">
</head>
<body>
<div class="container-scroller">
      <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth multi-step-login">
          <div class="row w-100">
            <div class="col-md-5 mx-auto py-5">
              <h4 class="text-center">Forgot Password</h4>
              <form action="home/forgotpass.htm" class="step-form" id="msform" method="post">
             
                <fieldset>
                 
                  <div class="form-group">
                    <input class="form-control" name="email" placeholder="Email">
                         <input class="form-control" name="username" placeholder="User">
                  </div>
          <button  class="btn btn-primary next action-button float-left" type="submit" > Next  </button> 
                </fieldset>
             
            
              </form>
            </div>
          </div>
        </div>
        <!-- content-wrapper ends -->
      </div>
      <!-- page-body-wrapper ends -->
    </div>
    
	<script src="<c:url value="/resources/theme1/js/off-canvas.js" />"></script>
	<script src="<c:url value="/resources/theme1/js/Chart.min.js" />"></script>
	<script src="<c:url value="/resources/theme1/js/dashboard.js" />"></script>
	<script
		src="<c:url value="/resources/theme1/js/hoverable-collapse.js" />"></script>
	<script src="<c:url value="/resources/theme1/js/misc.js" />"></script>
	<script src="<c:url value="/resources/theme1/js/todolist.js" />"></script>
	<script
		src="<c:url value="/resources/theme1/js/vendor.bundle.base.js" />"></script>
</body>
</html>