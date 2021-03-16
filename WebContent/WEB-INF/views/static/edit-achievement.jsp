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
			<h4 class="card-title">Sửa đánh giá</h4>
		<br>
			<form:form action="admin/edit-achievement.htm"
				modelAttribute="record">
				<div class="form-group">
					<label for="exampleInputEmail3">Staff</label>
					<form:select path="staff.id" class="form-control">
						<form:options items="${liststaff}" itemLabel="name" itemValue="id" />
					</form:select>


				</div>
				<div class="form-group row">
					<label class="col-sm-3 col-form-label">Type</label>
					<div class="col-sm-4">
						<div class="form-check">
							<label class="form-check-label"> <form:radiobutton
									class="form-check-input" name="membershipRadios"
									id="membershipRadios1" value="1" path="type" /> Achievement <i
								class="input-helper"></i></label>
						</div>
					</div>
					<div class="col-sm-5">
						<div class="form-check">
							<label class="form-check-label"> <form:radiobutton
									class="form-check-input" name="membershipRadios"
									id="membershipRadios2" value="0" path="type" /> Discipline <i
								class="input-helper"></i></label>
						</div>
					</div>
				</div>
				 <div class="form-group">
					<label for="exampleInputCity1">Date</label>
					<form:input path="date" type="text" class="form-control"
						placeholder="dd/mm/yyyy" />
				</div> 
				 <div class="form-group">
					<label for="exampleTextarea1">Reason</label>
					<form:textarea path="reason" class="form-control"
						id="exampleTextarea1" rows="4" />
				</div> 
				<form:input path="id" type="hidden" />
				<button type="submit"
					class="btn btn-gradient-success btn-rounded btn-fw">Sửa</button>
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