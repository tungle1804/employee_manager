<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

</head>
<body>
<div class="card">
		<div class="card-body">
			<h4 class="card-title">Danh sách hợp đồng sắp hết hạn</h4>
			
			<table class="table table-striped">
				<thead>
					<tr>
						<th>NO</th>
						<th>Name</th>
						<th>Days Left</th>
						
				
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${dayleft1}" var="R" varStatus="status">
						<tr>
							<td>${status.index+1}</td>
							<td>${R[0]} </td>
								<td>${R[1]}</td>
							<td>${R[2]}</td>

									

						</tr>
					</c:forEach>
				</tbody>
			</table>

			
		</div>
	</div>
</body>
</html>