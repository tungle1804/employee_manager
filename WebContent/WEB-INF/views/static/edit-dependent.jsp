<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<div class="card">
		<div class="card-body">
			<h4 class="card-title">Sửa quan hệ</h4>
			<p class="card-description">Vui lòng điền thông tin</p>
			<form:form  action="admin/edit-dependent.htm"  modelAttribute="dependent"     >
				<div class="form-group">
					<label for="exampleInputName1"> ID</label>
					<form:input path="id" type="text" class="form-control"
						id="exampleInputCode" placeholder="Code" />
				</div>
				<div class="form-group">
					<label for="exampleInputEmail3"> Name</label>
					<form:input path="name" type="text" class="form-control"
						id="exampleInputName" placeholder="Name" />
				</div>

				  <div class="form-group">
					<label for="exampleInputEmail3">Employee</label>
					<form:select path="staff.id"  class="form-control"
						>
						<form:options items="${liststaff}" itemLabel="name" itemValue="id" />
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
				
				
				
				<div class="form-group">
					<label for="exampleTextarea1">Relationship</label>
					<form:textarea path="relationship" class="form-control"
						id="exampleTextarea1" rows="4"/>
				</div>
				<form:button type="submit" class="btn btn-gradient-primary mr-2" 	>Sửa</form:button> 
				<button class="btn btn-light">Cancel</button>
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