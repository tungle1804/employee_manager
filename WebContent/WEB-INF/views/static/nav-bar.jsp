<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js">
 
</script>
</head>
<body>
	<nav class="sidebar sidebar-offcanvas" id="sidebar">
		<ul class="nav">
			<li class="nav-item nav-profile"><a href="#" class="nav-link">
					<div class="nav-profile-image">
						<img src="resources/theme1/images/face1.jpg" alt="profile">
						<span class="login-status online"></span>
						<!--change to offline or busy as needed-->
					</div>
					<div class="nav-profile-text d-flex flex-column">
						<span class="font-weight-bold mb-2">David Grey. H</span> <span
							class="text-secondary text-small">Project Manager</span>
					</div> <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
			</a></li>
			<li class="nav-item"><a class="nav-link" href="admin/static.htm">
					<span class="menu-title"><s:message code="global.admin.home"/></span> <i
					class="mdi mdi-home menu-icon"></i>
			</a></li>
			
			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#general-pages6" aria-expanded="false"
				aria-controls="general-pages2" > <span class="menu-title">Tổng quan</span>
					<i class="mdi mdi-apps-box menu-icon"></i>
			</a>
			<div class="collapse" id="general-pages6">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/IT.htm">IT </a></li>




					</ul>
				</div>
					<div class="collapse" id="general-pages6">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/administrative.htm"> Hành Chính </a></li>




					</ul>
				</div>
				<div class="collapse" id="general-pages6">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/manager.htm"> Giám đốc </a></li>




					</ul>
				</div>
				<div class="collapse" id="general-pages6">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/personnel.htm"> Nhân sự </a></li>




					</ul>
				</div>
				<div class="collapse" id="general-pages6">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/protect.htm"> Bảo Vệ</a></li>




					</ul>
				</div>
			</li>
			
			
			


			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#general-pages2" aria-expanded="false"
				aria-controls="general-pages2" > <span class="menu-title"><s:message code="global.admin.salary"/></span>
					<i class="mdi mdi-format-list-bulleted menu-icon"></i>
			</a>
			<div class="collapse" id="general-pages2">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/staff-salary.htm"><s:message code="global.admin.salarystaff"/> </a></li>




					</ul>
				</div>
					<div class="collapse" id="general-pages2">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/department-salary.htm"> <s:message code="global.admin.salarydepartment"/> </a></li>




					</ul>
				</div>
			</li>
			<li class="nav-item"><a class="nav-link" class="nav-link" data-toggle="collapse"
				href="#general-pages5" aria-expanded="false"
				aria-controls="general-pages5"
			> <span class="menu-title"><s:message code="global.admin.dependent"/></span> <i class="mdi mdi-attachment menu-icon"></i>
			</a>
			
			<div class="collapse" id="general-pages5">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
								href="admin/dependent.htm"> <s:message code="global.admin.dependentstaff"/> </a></li>




					</ul>
				</div>
					<%-- <div class="collapse" id="general-pages5">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/department-salary.htm"> <s:message code="global.admin.dependentdepartment"/> </a></li>




					</ul>
				</div> --%>
			
			</li>
			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#general-pages3" aria-expanded="false"
				aria-controls="general-pages3"
				> <span class="menu-title"><s:message code="global.admin.contract"/></span> <i class="mdi mdi-chart-bar menu-icon"></i>
			</a>
			<div class="collapse" id="general-pages3">
					<ul class="nav flex-column sub-menu"> 
						<li class="nav-item"><a class="nav-link"
							href="admin/contract.htm"> <s:message code="global.admin.contractlist"/> </a></li>




					</ul>
				</div>
					<div class="collapse" id="general-pages3">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/dayleft.htm">  <s:message code="global.admin.contractlexpired"/>  </a></li>




					</ul>
				</div>
			</li>
			<li class="nav-item"><a class="nav-link" data-toggle="collapse"
				href="#general-pages1" aria-expanded="false"
				aria-controls="general-pages1" > <span
					class="menu-title"> <s:message code="global.admin.manager"/>  </span> <i
					class="mdi mdi-table-large menu-icon"></i>
			</a>
			<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/user.htm">  <s:message code="global.admin.manageraccount"/>  </a></li>




					</ul>
				</div>
				<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/staff.htm">  <s:message code="global.admin.managerstaff"/>  </a></li>
					</ul>
				</div>
				<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">  
						<li class="nav-item"><a class="nav-link"
							href="admin/department.htm"> <s:message code="global.admin.managerdepartment"/></a></li>
					</ul>
				</div>      
					<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/achievement.htm"> <s:message code="global.admin.managerachievement"/></a></li>
					</ul>
				</div>   
					<div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/salary.htm"> <s:message code="global.admin.managersalary"/></a></li>
					</ul>
				</div>
				<%-- <div class="collapse" id="general-pages1">
					<ul class="nav flex-column sub-menu">
						<li class="nav-item"><a class="nav-link"
							href="admin/salary.htm"> <s:message code="global.admin.managersalary"/></a></li>
					</ul>
				</div> --%>
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