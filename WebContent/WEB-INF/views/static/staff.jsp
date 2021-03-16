<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="tag" uri="/WEB-INF/configs/spring-config-taglib.tld" %>
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
	

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.11.3.js">
	
</script>

</head>
<body>
<form:form   class="ml-auto d-flex pt-2 pt-md-0 align-items-stretch w-50 justify-content-end" action="admin/search.htm" method="get">
                        <input type="text" class="form-control w-50" placeholder="Search" name="search">
                        <button type="submit" class="btn btn-gradient-success no-wrap ml-4">Search Ticket</button>
                      </form:form>
                      <br>
 <%-- <form:form action="admin/search.htm"  method="get"  >
			<div class="form-group">
				<input name="search" placeholder="Tìm kiếm Mã nhân viên"
					class="form-control" />
				<button type="submit" class="btn btn-danger btn-fill">
					Tìm kiếm
				</button>
			</div>
		</form:form>  --%>


	<div class="card">
		<div class="card-body">
			<h4 class="card-title">Danh sách nhân viên</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Photo</th>
						<th>Emp Name</th>
						<th>Gender</th>
						<th>Birthday</th>
						<th>Email</th>

						<th>Depart</th>
						<th>Salary</th>


						<th style="padding-left: 30px;">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${staffs}">
						<tr>
							<td><img src="<c:url value="/upload/${u.photo}"/>"
								width="80" height="70" /></td>
							<td>${u.name}</td>
							<td><c:if test="${u.gender}">Nam</c:if>
								<c:if test="${ not u.gender}">Nữ</c:if></td>
							<td>${u.birthday}</td>
							<td>${u.email}</td>
							<td>${u.depart.name}</td>
							<td>${u.salary.id}</td>
							<td><a onclick="chayNgayDi('${u.getId()}','${u.getName()}')" data-title="Delete" data-toggle="modal" data-target="#delete" > 
									<button type="button"
										class="btn btn-gradient-primary btn-rounded btn-icon">  <%-- href="admin/delete-staff.htm?id=${u.id}" --%> 
										<i class="mdi mdi-delete"></i>
									</button>
									
							</a> <a onclick="chayNgayDi1('${u.getId()}','${u.getName()}')" data-title="Delete" data-toggle="modal" data-target="#edit"  > <%-- href="admin/edit-staff.htm?id=${u.id}" --%>  
									<button type="button"
										class="btn btn-gradient-primary btn-rounded btn-icon">
										<i class="mdi mdi-table-edit"></i>
									</button>
							</a></td>


						</tr>
					</c:forEach>
				</tbody>
			</table>
				<input id="hre" type="hidden" value="${pageContext.servletContext.contextPath}">	
				  <div class="modal fade" id="delete" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                            </button>
                                            <h4 class="modal-title custom_align" style="margin-right: 160px;" id="Heading">Xóa nhân viên</h4>
                                        </div>
                                          <img style="width: 50px;height: 50px;margin-left: 240px;" src="resources/theme1/images/1200px-Octagon_delete.svg.png" 
										class="card-img-absolute"  />
                                        <div class="modal-body">
                                            <div ><span class="glyphicon glyphicon-warning-sign"></span>
                                                Bạn có chắc muốn xóa nhân viên <span id="nd"></span> ?</div>
                                        </div>
                                        <div class="modal-footer ">
                                            <a id="idDelelte" href="" class="btn btn-success">
                                                <span class="glyphicon glyphicon-ok-sign"></span>
                                                Có
                                            </a>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                                <span class="glyphicon glyphicon-remove"></span>
                                               Không
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="edit" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                            </button>
                                            <h4 class="modal-title custom_align" style="margin-right: 160px;" id="Heading">Sửa nhân viên</h4>
                                        </div>
                                        <img style="width: 50px;height: 50px;margin-left: 240px;" src="resources/theme1/images/1200px-Information_icon_alt.svg.png"
										class="card-img-absolute"  />
                                        <div class="modal-body">
                                            <div ><span class="glyphicon glyphicon-warning-sign"></span>
                                                Bạn có chắc muốn sửa nhân viên <span id="nd1"></span> ?</div>
                                        </div>
                                        <div class="modal-footer ">
                                            <a id="idEdit" href="" class="btn btn-success">
                                                <span class="glyphicon glyphicon-ok-sign"></span>
                                                Có
                                            </a>
                                            <button type="button" class="btn btn-default" data-dismiss="modal">
                                                <span class="glyphicon glyphicon-remove"></span>
                                               Không
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
			<br>
			
 <tag:paginate max="5" offset="${offset}" count="${count}" uri="admin/staff.htm" next="Previous" previous="Next"/>
			<br> <a href="admin/add-staff.htm"><button type="button"
					class="btn btn-gradient-success btn-rounded btn-fw">Thêm
					Mới</button></a>
		</div>

</div>
<!-- <script type="text/javascript">
var hre = document.getElementById("hre")

  document.getElementById("idDelelte").href = hre.value + '/Staff/Delete?ID=' + id;
         function testConfirmDialog()  {
 
              var result = confirm("Do you want to continue?");
 
              if(result)  {
                  alert("OK Next lesson!");
              } else {
                 
              }
         }
 
      </script> -->
        <script>
    var hre = document.getElementById("hre");
   
    function chayNgayDi(id, name) {
    
      document.getElementById("nd").innerHTML = name;
      document.getElementById("idDelelte").href = hre.value + '/admin/delete-staff.htm?id=' + id;
    }

  </script>
        <script>
    var hre = document.getElementById("hre");
   
    function chayNgayDi1(id, name) {
    
      document.getElementById("nd1").innerHTML = name;
      document.getElementById("idEdit").href = hre.value + '/admin/edit-staff.htm?id=' + id;
    }

  </script>
</body>
</html>