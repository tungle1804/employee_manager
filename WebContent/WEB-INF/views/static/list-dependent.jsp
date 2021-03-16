<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="tag" uri="/WEB-INF/configs/spring-config-taglib.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title">Danh sách quan hệ</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>

						<th>Name</th>
						<th>Gender</th>
						<th>Birthday</th>
						<th>relationship</th>
						<th>Employee</th>




						<th style="padding-left: 30px;">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="u" items="${dependents}">
						<tr>

							<td>${u.name}</td> 
							<td><c:if test="${u.gender}">Nam</c:if>
								<c:if test="${ not u.gender}">Nữ</c:if></td>
							<td>${u.birthday}</td>

							<td>${u.relationship}</td>
							<td>${u.staff.name}</td>
							<td><a onclick="chayNgayDi('${u.id}','${u.name}')" data-title="Delete" data-toggle="modal" data-target="#delete">
									<button type="button"
										class="btn btn-gradient-primary btn-rounded btn-icon">
										<i class="mdi mdi-delete"></i>
									</button>
							</a> <a onclick="chayNgayDi1('${u.id}','${u.name}')" data-title="Delete" data-toggle="modal" data-target="#edit">
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
                                                Bạn có chắc muốn xóa quan hệ <span id="nd"></span> ?</div>
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
                                                Bạn có chắc muốn sửa quan hệ <span id="nd1"></span> ?</div>
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
			 <tag:paginate max="5" offset="${offset}" count="${count}" uri="admin/dependent.htm" next="Previous" previous="Next"/>
			<a href="admin/add-dependent.htm"><button type="button"
					class="btn btn-gradient-success btn-rounded btn-fw">Thêm
					Mới</button></a>
		</div>
	</div>
	 <script>
    var hre = document.getElementById("hre");
   
    function chayNgayDi(id, name) {
    	 console.log(name);
      document.getElementById("nd").innerHTML = name;
      document.getElementById("idDelelte").href = hre.value + '/admin/delete-dependent.htm?id=' + id;
    }

  </script>
        <script>
    var hre = document.getElementById("hre");
   
    function chayNgayDi1(id, name) {
    	 console.log(name);
      document.getElementById("nd1").innerHTML = name;
      document.getElementById("idEdit").href = hre.value + '/admin/edit-dependent.htm?id=' + id;
    }

  </script>
</body>
</html>