<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<div>
			<label>
				employee_id : <input type="number" name="employeeId" value="${empInfo.employeeId}">
			</label>
			<br>
			<label>
				last_name : <input type="text" name="lastName" value="${empInfo.lastName}">
			</label>
			<br>
			<label>
				email : <input type="text" name="email" value="${empInfo.email}">
			</label>
			<br>
			<label>
				hire_date : <input type="date" name="hireDate" value='<fmt:formatDate value = "${empInfo.hireDate}" pattern ="yyyy-MM-dd" />'>
			</label>
			<br>
			<label>
				job_id : <input type="text" name="jobId" value="${empInfo.jobId}">
			</label>
			<br>
			<label>
				salary : <input type="number" name="salary" value="${empInfo.salary	}">
			</label>
		</div>
		<div>
			<button type="button" onclick="location.href='empList'">목록으로</button>
			<button type="button" id="updateBtn">수정</button>
			<button type="button">삭제</button>
		</div>
	</form>
	<script>
		document.querySelector('#updateBtn').addEventListener('click', updateEmpInfo);
		function updateEmpInfo(event) {
			//
			let empInfo = getEmpInfo();
			console.log(empInfo);
			// 해당 정보를 기반으로 Ajax
			// QueryString
			fetch('empUpdate', {
				method : 'post',
				body : new URLSearchParams(empInfo) // queryString(key=value)형태로 데이터를 보냄.
			})
			.then(res => res.json())
			.then(result => {
				console.log('query', result);		
			})
		}
		
		function getEmpInfo() {
			let inputList = document.querySelectorAll('form input'); // form내부 input요소 모두 들고옴
			let objData = {};
			
			// input 태그의 name속성을 이용해 js단에서 emp쪽 객체를 만들어 반환
			inputList.forEach(tag => {
				objData[tag.name] = tag.value;
			});
			return objData;
		}
	</script>
</body>
</html>