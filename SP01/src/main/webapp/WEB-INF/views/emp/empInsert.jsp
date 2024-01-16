<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- name에는 EmpVo의 필드명이 들어가야함 -->
	<form action="empInsert" method="post">
		<div>
			<label>
				last_name : <input type="text" name="lastName">
			</label>
			<br>
			<label>
				email : <input type="text" name="email">
			</label>
			<br>
			<label>
				hire_date : <input type="date" name="hireDate">
			</label>
			<br>
			<label>
				job_id : <input type="text" name="jobId">
			</label>
			<br>
			<label>
				salary : <input type="number" name="salary">
			</label>
		</div>
		<div>
			<button type="button" onclick="location.href='empList'">목록으로</button>
			<button type="submit">등록</button>
		</div>
	</form>
</body>
</html>