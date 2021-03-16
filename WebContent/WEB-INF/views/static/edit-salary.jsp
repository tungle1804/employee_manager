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
                    <h4 class="card-title">Sửa bậc Lương </h4>
                    <p class="card-description"> Vui lòng điền thông tin</p>
                            <span style="font-family: sans-serif; color: red"> Chú ý ! Không được sửa mã bậc lương</span>
                            <br>
                            <br>
                    <form:form  action="admin/edit-salary.htm" class="forms-sample" modelAttribute="salary">
                      <div class="form-group">
                        <label for="exampleInputName1">ID</label>
                        <form:input path="id" type="text" class="form-control" id="exampleInputID" placeholder="ID"/>
                      </div>
               
                      <div class="form-group">
                        <label for="exampleInputPassword4">Basicsalary</label>
                        <form:input path="basicsalary" type="text" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                       <div class="form-group">
                        <label for="exampleInputPassword4">Allowance</label>
                        <form:input path="allowance" type="text" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                       <div class="form-group">
                        <label for="exampleInputPassword4">Salaryfactor</label>
                        <form:input path="salary_factor" type="text" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                  
                     
                    
                      <button type="submit" class="btn btn-gradient-primary mr-2">Sửa</button>
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