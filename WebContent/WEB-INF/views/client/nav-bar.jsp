<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
		<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<nav class="sidebar sidebar-offcanvas" id="sidebar">
		<ul class="nav">
			<li class="nav-item nav-profile"><a href="#" class="nav-link">
					<div class="nav-profile-image">
						<img src="resources/theme1/images/face1.jpg"  alt="profile">
						<span class="login-status online"></span>
						<!--change to offline or busy as needed-->
					</div>
					<div class="nav-profile-text d-flex flex-column">
						<span class="font-weight-bold mb-2">David Grey. H</span> <span
							class="text-secondary text-small">Project Manager</span>
					</div> <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="home/client.htm">
					<span class="menu-title"><s:message code="global.admin.home"/></span> <i
					class="mdi mdi-home menu-icon"></i>
			</a></li>


			
			
			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#general-pages1" aria-expanded="false"
				aria-controls="general-pages1" href="#"> <span
					class="menu-title"><s:message code="global.admin.manager"/>   </span> <i
					class="mdi mdi-table-large menu-icon"></i>
			</a>
			<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="home/personal.htm">  <s:message code="global.admin.manageraccount"/>  </a></li>




					</ul>
				</div>
				
				<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="home/department.htm"> <s:message code="global.admin.managerdepartment"/> </a></li>




					</ul>
				</div>
					<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="#">  <s:message code="global.admin.managerachievement"/></a></li>




					</ul>
				</div>
				</li>
			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#general-pages" aria-expanded="false"
				aria-controls="general-pages"> <span class="menu-title">Sample
						Pages</span> <i class="menu-arrow"></i> <i
					class="mdi mdi-medical-bag menu-icon"></i>
			</a>
				<div class="collapse" id="general-pages">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/blank-page.html"> Blank Page </a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/login.html"> Login </a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/register.html"> Register </a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/error-404.html"> 404 </a></li>
						<li class="nav-item"><a class="nav-link"
							href="pages/samples/error-500.html"> 500 </a></li>
					</ul>
				</div></li>
			<li class="nav-item sidebar-actions"><span class="nav-link">
					<div class="border-bottom">
						<h6 class="font-weight-normal mb-3">Projects</h6>
					</div>
					<button class="btn btn-block btn-lg btn-gradient-primary mt-4">+
						Add a project</button>
					<div class="mt-4">
						<div class="border-bottom">
							<p class="text-secondary">Categories</p>
						</div>
						<ul class="gradient-bullet-list mt-4">
							<li>Free</li>
							<li>Pro</li>
						</ul>
					</div>
			</span></li>
		</ul>
	</nav>

</body>
</html>