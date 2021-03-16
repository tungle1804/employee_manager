<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="forrm"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>

<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Purple Admin</title>
<!-- plugins:css -->

<link href="<c:url value="/resources/theme1/css/style.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/style1.css" />" rel="stylesheet">
 <link href="<c:url value="/resources/theme1/css/materialdesignicons.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/vendor.bundle.base.css" />" rel="stylesheet">
<link href="<c:url value="/resources/theme1/css/auth.scss" />" rel="stylesheet">

<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js">
 
</script>

<base href="${pageContext.servletContext.contextPath}/">

</head>
<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div
				class="content-wrapper d-flex align-items-stretch auth auth-img-bg">
				<div class="row flex-grow">
					<div
						class="col-lg-6 d-flex align-items-center justify-content-center">
						<div class="auth-form-transparent text-left p-3">
							<div class="brand-logo">
								<img src="resources/theme1/images/logo.svg" alt="logo">
							</div>
							<h4><s:message code="global.register.title"/></h4>
							<h6 class="font-weight-light"><s:message code="global.register.join"/></h6>
							<form class="pt-3" action="home/register.htm"  method="post">
								<div class="form-group">
									<label><s:message code="global.register.username"/></label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-account-outline text-primary"></i>
											</span>
										</div>
										<input  type="text" name="username"
											class="form-control form-control-lg border-left-0"
											placeholder="" />
									</div>
								</div>
								<div class="form-group">
									<label>Email</label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-email-outline text-primary"></i>
											</span>
										</div>
										<input type="email" name="email"
											class="form-control form-control-lg border-left-0"
											placeholder="Email">
									</div>
								</div>
							<div class="form-group">
									<label><s:message code="global.register.fullname"/></label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-account-outline text-primary"></i>
											</span>
										</div>
										<input  type="text" name="fullname"
											class="form-control form-control-lg border-left-0"
											placeholder=""/>
									</div>
								</div>
							<%-- 	 <div class="form-group">
									<label><s:message code="global.register.password"/></label>
									<div class="input-group">
										<div class="input-group-prepend bg-transparent">
											<span class="input-group-text bg-transparent border-right-0">
												<i class="mdi mdi-lock-outline text-primary"></i>
											</span>
										</div>
										<input type="text"
											class="form-control form-control-lg border-left-0"
											id="exampleInputPassword" placeholder=""/>
									</div>
								</div>  --%>
								<div class="form-group">
                        <label for="exampleTextarea1">Nội dung</label>
                        <textarea class="form-control" name="noidung" id="exampleTextarea1"  rows="4"></textarea>
                      </div>
								<%--  <form:input path="role"  type="hidden" value="true"
											class="form-control form-control-lg border-left-0"
											id="exampleInputPassword" />  --%>
								<div class="mb-4">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> <s:message code="global.register.agree"/> <i class="input-helper"></i></label>
									</div>
								</div>
								<div class="mt-3">
									<a
										
										><button class="btn btn-block btn-gradient-primary btn-lg font-weight-medium auth-form-btn"><s:message code="global.register.signup"/></button></a>
								</div>
								<div class="text-center mt-4 font-weight-light">
									<s:message code="global.register.already"/> <a href="home/login.htm"
										class="text-primary"><s:message code="global.register.login"/></a>
								</div>
							</form>
						</div>
					</div>
					<div class="col-lg-6 register-half-bg d-flex flex-row">
						<p
							class="text-white font-weight-medium text-center flex-grow align-self-end"><s:message code="global.register.copy"/></p>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	 <script src="<c:url value="/resources/theme1/js/off-canvas.js" />"></script>
    <script src="<c:url value="/resources/theme1/js/misc.js" />"></script>
    <script src="<c:url value="/resources/theme1/js/hoverable-collapse.js" />"></script> 
    <script src="<c:url value="/resources/theme1/js/vendor.bundle.base.js" />"></script> 



	<!--     <script src="../../../assets/js/settings.js"></script> -->

	<!-- endinject -->

</body>
</html>