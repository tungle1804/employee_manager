<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>

	<div class="card">
		<div class="card-body">
			<h4 class="card-title">Bảng lương</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>NO</th>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Gender</th>
						<th>Salary</th>



				
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${staff_salary}" var="R" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${R[0]} </td>
							<td>${R[1]}</td>

							<td>${R[2]}</td>


							<td><c:if test="${R[3]}">Nam</c:if><c:if
													test="${ not R[3]}">Nữ</c:if></td>
									<td> <fmt:formatNumber type="currency">${R[4]}</fmt:formatNumber> </td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

			
		</div>
	</div>
	
</body>
</html>