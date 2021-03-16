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
                    <h4 class="card-title">Sửa </h4>
                    <p class="card-description"> Vui Lòng Điển Thông Tin </p>
                    <span style="font-family: sans-serif; color: red"> Chú ý ! Không được sửa username</span>
                    <br>
                    <br>
                    <form:form class="forms-sample" action="admin/edit-user.htm" modelAttribute="user"  >
                      <div class="form-group">
                        <label for="exampleInputUsername1">Username</label>
                        
                        <form:input  path="username"   type="text" class="form-control" id="exampleInputUsername1" placeholder="Username" />
                      
                      </div>
                      <div class="form-group">
                        <label for="exampleInputEmail1">Fullname</label>
                        <form:input  path="fullname"  type="text" class="form-control" id="exampleInputFullname" placeholder="Fullname"/>
                      	<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="fullname" />
                      </div>
                      <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <form:input  path="pass" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password"/>
                      	<form:errors
						style="color: red;
    font-size: 13px;
    margin-top: 15px;"
						path="pass" />
                      </div>
                     <div class="form-group row">
                            <label class="col-sm-3 col-form-label">Role</label>
                            <div class="col-sm-4">
                              <div class="form-check">
                                <label class="form-check-label">
                                  <form:radiobutton  class="form-check-input" name="membershipRadios" id="membershipRadios1" value="0"   path="role"/> Admin <i class="input-helper"></i></label>
                              </div>
                            </div>
                            <div class="col-sm-5">
                              <div class="form-check">
                                <label class="form-check-label">
                                  <form:radiobutton class="form-check-input" name="membershipRadios" id="membershipRadios2" value="1"  path="role"/> Normal <i class="input-helper"></i></label>
                              </div>
                            </div>
                          </div>
                      <div class="form-check form-check-flat form-check-primary">
                        <label class="form-check-label">
                          <input type="checkbox" class="form-check-input"> Remember me </label>
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