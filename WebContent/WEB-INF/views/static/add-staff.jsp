<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.servletContext.contextPath}/">

     
</head>
<body>
	<div class="card">
		<div class="card-body">
			<h4 class="card-title">Thêm mới nhân viên</h4>
			<p class="card-description">Vui lòng điền thông tin</p>
			<form:form  action="admin/add-staff.htm"  modelAttribute="staff" method="POST" enctype="multipart/form-data"   >
				<div class="form-group" style="margin-top: 20px"> 
					<label for="exampleInputName1">Emp Code</label>
					<form:input pattern="\w+" maxlength="10" required="required" path="id" type="text" class="form-control"
						id="exampleInputCode" placeholder="Code" />
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="id" />
				<div class="form-group" style="margin-top: 20px">
					<label for="exampleInputEmail3">Emp Name</label>
					<form:input   maxlength="50"   path="name" type="text" class="form-control"
						id="exampleInputName" placeholder="Name" />
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="name" />

				  <div class="form-group" style="margin-top: 20px">
					<label for="exampleInputEmail3">Department</label>
					<form:select path="depart.id"  class="form-control"
						>
						<form:options items="${departss}" itemLabel="name" itemValue="id" />
							</form:select>

					
				</div> 
			 <div class="form-group" style="margin-top: 20px">
					<label for="exampleInputEmail3">Salary</label>
					<form:select path="salary.id"  class="form-control"
						>
						<form:options items="${salaryss}" itemLabel="id" itemValue="id" />
							</form:select>

					
				</div> 
				<div class="form-group row" style="margin-top: 20px">
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
			
					 	<%-- <form:input path="photo" type="hidden"  id="txtanhgoc" value="${staff.getPhoto()}" /> 
						<input type="hidden" name="photonew"  id="txtanh" value="" />
						<input type="file" name="image" id="chooseimg"  accept="image/*" /> --%>
						  <div class="form-group" style="margin-top: 20px">
				 <label>File upload</label>
				
					
				<form:hidden path="photo"/>
									 <input type="file" name="img">
																	 
									 	
									 </div>
				<%-- <form:input path="photo" type="file" name="img"
					class="file-upload-default"  />  --%>
				<br>
				<br>
				<!-- <div class="input-group col-xs-12"> -->
				<!--     <input type="file" class="form-control file-upload-info"   placeholder="Upload Image"> -->
				<!--   <span class="input-group-append">
                            <button class="file-upload-browse btn btn-gradient-primary" type="button">Upload</button>
                          </span> -->
				<!--   </div> -->
				<!--      </div> -->
				<div class="form-group" style="margin-top: 20px">
					<label for="exampleInputCity1">Birthday</label>
					<form:input  required="required" path="birthday" type="text"  class="form-control"
						placeholder="dd/mm/yyyy" />
				</div>
				<%-- <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="birthday" /> --%>
				<div class="form-group" style="margin-top: 20px">
					<label for="exampleInputEmail3">Email address</label>
					<form:input maxlength="50"  required="required" pattern="^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$" path="email" type="email" class="form-control"
						id="exampleInputEmail" placeholder="Email" />
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="email" />
				<div class="form-group" style="margin-top: 20px">
					<label for="exampleInputName1">Phone</label>
					<form:input pattern="[0-9]{8,10}" required="required" path="phone" type="text" class="form-control"
						id="exampleInputPhone" placeholder="Phone" />
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="phone" />
				<div class="form-group" style="margin-top: 20px" >
					<label for="exampleTextarea1">Notes</label>
					<form:textarea  required="required" maxlength="500" path="notes" class="form-control"
						id="exampleTextarea1" rows="4"/>
				</div>
				<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="notes" />
						<div class="form-group" style="margin-top: 20px">
				<button type="submit" class="btn btn-gradient-primary mr-2" 	>Thêm</button> 
				<button class="btn btn-light">Cancel</button>
				</div>
			</form:form>

		</div>
	</div>
	    <script type="text/javascript">	
	window.setTimeout(function() {
	    $("#alert").fadeTo(1000, 0).slideUp(1000);
	}, 4000);	
	</script>
</body>
</html>