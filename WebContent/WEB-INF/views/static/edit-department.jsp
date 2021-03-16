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
                    <h4 class="card-title"> Sửa Phòng Ban </h4>
                <span style="font-family: sans-serif; color: red"> Chú ý ! Không được sửa mã phòng ban</span>
                <br>
                <br>
                    <form:form  action="admin/edit-department.htm" class="forms-sample" modelAttribute="depart">
                      <div class="form-group">
                        <label for="exampleInputName1">ID</label>
                        <form:input path="id" type="text" class="form-control" id="exampleInputID" placeholder="ID"/>
                      
                      </div>
               
                      <div class="form-group">
                        <label for="exampleInputPassword4">Name</label>
                       
                        <form:input path="name" type="text" class="form-control" id="exampleInputName" placeholder="Name"/>
                               	<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="name" />
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