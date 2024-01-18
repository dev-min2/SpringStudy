<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="m-5">
<button onclick="location.href='boardInsert'">등록</button>
	<table class="table">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="board" varStatus="sts">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'">
					<td>${board.bno}</td>
					<td>${board.title}</td>
					<td>${board.writer}</td>
					<td><fmt:formatDate value="${board.regdate}" pattern="yyyy년MM월dd일"/></td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</div>
