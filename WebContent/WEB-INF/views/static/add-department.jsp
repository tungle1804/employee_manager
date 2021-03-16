<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>		
																
                <div class="card">
                  <div class="card-body">
                    <h4 class="card-title">Thêm Phòng Ban </h4>
                    <p class="card-description"> Vui lòng điền thông tin </p>
                    <form:form  action="admin/add-department.htm" class="forms-sample" modelAttribute="depart">
                      <div class="form-group" style="margin-top: 20px">
                        <label for="exampleInputName1">ID</label>
                        <form:input path="id" type="text" class="form-control" id="exampleInputID" placeholder="ID"/>
                      </div>
               <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="id" />
                      <div class="form-group" style="margin-top: 20px">
                        <label for="exampleInputPassword4">Name</label>
                        <form:input path="name" type="text" class="form-control" id="exampleInputName" placeholder="Name"/>
                      </div>
                  <form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="name" />
                    
                     <div class="form-group" style="margin-top: 20px">
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