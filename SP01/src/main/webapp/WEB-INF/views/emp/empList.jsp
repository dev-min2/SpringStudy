<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	사원 조회
</h1>
<button onclick="location.href='empInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>No.</th>
				<th>empId.</th>
				<th>lastName.</th>
				<th>email.</th>
				<th>hire_date.</th>
				<th>job_id.</th>
				<th>salary.</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${empList}" var="emp" varStatus="sts">
				<tr onclick="location.href='emp?employeeId=${emp.employeeId}'">
					<td>${sts.count}</td> <!-- sts.index는 배열 인덱스 stx.count는 1부터 시작. -->
					<td>${emp.employeeId}</td>
					<td>${emp.lastName}</td>
					<td>${emp.email}</td>
					<td><fmt:formatDate value="${emp.hireDate}" pattern="yyyy년MM월dd일"/>
					</td>
					<td>${emp.jobId}</td>
					<td>${emp.salary}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</body>
</html>
