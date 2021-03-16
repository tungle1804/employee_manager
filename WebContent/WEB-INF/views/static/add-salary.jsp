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
                    <h4 class="card-title"> Thêm mới bậc lương </h4>
                    <form:form  action="admin/add-salary.htm" class="forms-sample" modelAttribute="salary">
                      <div class="form-group">
                        <label for="exampleInputName1">ID</label>
                        <form:input path="id" type="text" class="form-control" id="exampleInputID" placeholder="ID"/>
                      </div>
               <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="id" />
                      <div class="form-group">
                        <label for="exampleInputPassword4">Basicsalary</label>
                        <form:input path="basicsalary" type="float" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                      <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="basicsalary" />
                       <div class="form-group">
                        <label for="exampleInputPassword4">Allowance</label>
                        <form:input path="allowance" type="float" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                          <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="allowance" />
                       <div class="form-group">
                        <label for="exampleInputPassword4">Salary factor</label>
                        <form:input path="salary_factor" type="float" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                  
                                 <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="salary_factor" />
                    <div class="form-group">
                      <button type="submit" class="btn btn-gradient-primary mr-2">Thêm Mới</button>
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