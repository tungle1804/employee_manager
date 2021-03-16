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
                    <h4 class="card-title">Thêm mới hợp đồng </h4>
                    <p class="card-description"> Vui Lòng Điển Thông Tin </p>
                    <form:form class="forms-sample" action="admin/add-contract.htm" modelAttribute="contract"  >
                      <div class="form-group" style="margin-top: 20px">
                        <label for="exampleInputUsername1">ID</label>
                        <form:input path="id"  type="text" class="form-control" id="exampleInputUsername1" placeholder="Username"/>
                      </div>
                       <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="id" />
                      <div class="form-group" style="margin-top: 20px">
					<label for="exampleInputEmail3">Name</label>
					<form:select path="staff.id"  class="form-control"
						>
						<form:options items="${liststaff}" itemLabel="name" itemValue="id" />
							</form:select>

					
				</div> 
                      <div class="form-group" style="margin-top: 20px">
                        <label for="exampleInputEmail1">Type Contract</label>
                        <form:input path="type"  type="text" class="form-control" id="exampleInputFullname" placeholder="Type"/>
                      </div>
                       <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="type" />
                      <div class="form-group" style="margin-top: 20px">
                        <label for="exampleInputPassword1">From Date</label>
                        <form:input path="fromdate" type="text" class="form-control" id="exampleInputPassword1" placeholder="From Date"/>
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">To Date</label>
                        <form:input path="todate" type="text" class="form-control" id="exampleInputPassword1" placeholder="To Date"/>
                      </div>
                      <div class="form-check form-check-flat form-check-primary">
                        <label class="form-check-label">
                          <input type="checkbox" class="form-check-input"> Remember me </label>
                      </div>
                      <div class="form-group" style="margin-top: 20px">
                      <button type="submit" class="btn btn-gradient-primary mr-2" >Thêm mới</button>
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