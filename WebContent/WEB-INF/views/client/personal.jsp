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
			<h4 class="card-title">Striped Table</h4>
			<h4 class="card-title">Personal achievement</h4>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>NO</th>
						<th>Employee</th>
						<th>Total achievement</th>
						<th>Total discipline</th>
						<th>Reward points</th>

					</tr>
				</thead>
				<tbody>
				 <c:forEach items="${personal}" var="R" varStatus="status">											 		
						<tr>
						  <td>${status.index+1}</td>
                          <td>${R[1]}</td>
                          <td>${R[2]}</td>
                          <td>${R[3]}</td>
                          <td>${R[4]}</td>                    
                        </tr>                          
                      </c:forEach>    
					<%-- <c:set var="total" value="${0}" />  --%>
				<%--  <c:forEach    var="u" items="${personal}"> 

						<tr>
							<td>${u.staff.name}</td> --%>
							
						<%-- <td>${u.staff.id}</td> --%>
							
									
										
							
							<%--  <td>
								
										<c:if test="${u.type}">1</c:if>
										<c:if test="${ not u.type}">0</c:if>
							
									
						
								
								</td>  --%>

							<%-- <td><c:choose>
									<c:when test="${u.type}">0</c:when>
									<c:when test="${ not u.type}">1</c:when>

								</c:choose></td> --%>
							<%-- <td>${personal[0]}</td> --%>



					<%-- 	</tr>
				 	</c:forEach> --%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>