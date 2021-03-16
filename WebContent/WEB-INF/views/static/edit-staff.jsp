<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title">Sửa nhân viên</h4>
			<p class="card-description">Vui lòng điền thông tin</p>
			   <span style="font-family: sans-serif; color: red"> Chú ý ! Không được sửa mã nhân viên</span>
			   <br>
			   <br>
			<form:form  action="admin/edit-staff.htm" modelAttribute="staff"  method="post" enctype="multipart/form-data" >
				<div class="form-group">
					<label for="exampleInputName1">Emp Code</label>
					<form:input path="id" type="text" class="form-control"
						id="exampleInputCode" placeholder="Code" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail3">Emp Name</label>
					<form:input path="name" type="text" class="form-control"
						id="exampleInputName" placeholder="Name" />
				</div>
<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="name" />
				  <div class="form-group">
					<label for="exampleInputEmail3">Department</label>
					<form:select path="depart.id"  class="form-control"
						>
						<form:options items="${departss}" itemLabel="name" itemValue="id" />
							</form:select>

					
				</div> 
				 <div class="form-group">
					<label for="exampleInputEmail3">Salary</label>
					<form:select path="salary.id"  class="form-control"
						>
						<form:options items="${salaryss}" itemLabel="id" itemValue="id" />
							</form:select>

					
				</div> 
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">Gender</label>
					<div class="col-sm-4">
						<div class="form-check">
							<label class="form-check-label"> <form:radiobutton
									class="form-check-input" name="membershipRadios"
									id="membershipRadios1" value="0" path="gender" /> Fermale <i
								class="input-helper"></i></label>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-check">
							<label class="form-check-label"> <form:radiobutton
									class="form-check-input" name="membershipRadios"
									id="membershipRadios2" value="1" path="gender" /> Male <i
								class="input-helper"></i></label>
						</div>
					</div>
				</div>
				<!--     <div class="form-group"> -->
				<div class="form-group">
				<label>File upload</label>
				
								
			
			<br> <br>
				<form:hidden path="photo"/>
				<input type="hidden"  id="txtanhgoc" value="${staff.getPhoto()}" />
						
						<input type="file" name="img"   />
						</div>
									<!--  <input type="file" name="img" class="file-upload-default"> -->
				<%-- <form:input  path="photo" type="file" name="img"
				
					class="file-upload-default" /> --%>
				<br>
				<br>
				<!-- <div class="input-group col-xs-12"> -->
				<!--     <input type="file" class="form-control file-upload-info"   placeholder="Upload Image"> -->
				<!--   <span class="input-group-append">
                            <button class="file-upload-browse btn btn-gradient-primary" type="button">Upload</button>
                          </span> -->
				<!--   </div> -->
				<!--      </div> -->
				<div class="form-group">
					<label for="exampleInputCity1">Birthday</label>
					<form:input path="birthday" type="text" class="form-control"
						placeholder="dd/mm/yyyy" />
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="birthday" />
				<div class="form-group">
					<label for="exampleInputEmail3">Email address</label>
					<form:input path="email" type="email" class="form-control"
						id="exampleInputEmail" placeholder="Email" />
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="email" />
				<div class="form-group">
					<label for="exampleInputName1">Phone</label>
					<form:input path="phone" type="text" class="form-control"
						id="exampleInputPhone" placeholder="Phone" />
				</div>
			<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="phone" />
				<div class="form-group">
					<label for="exampleTextarea1">Notes</label>
					<form:textarea path="notes" class="form-control"
						id="exampleTextarea1" rows="4"/>
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="notes" />
				<form:button type="submit" class="btn btn-gradient-primary mr-2">Thêm</form:button> 
				<button class="btn btn-light">Cancel</button>
			</form:form>

		</div>
	</div>
</body>
</html>