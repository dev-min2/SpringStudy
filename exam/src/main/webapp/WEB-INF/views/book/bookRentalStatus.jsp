<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<div class="m-5">
	<table class="table">
		<thead>
			<tr>
				<th style="text-align:center;">도서번호</th>
				<th style="text-align:center;">도서명</th>
				<th style="text-align:center;">대여총계</th>
				<th style="text-align:center;">대여횟수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="rentBook" varStatus="sts">
				<tr>
					<td style="text-align:center;">${rentBook.bookNo}</td>
					<td style="text-align:left;">${rentBook.bookName}</td>
					<td style="text-align:right;">${rentBook.allPrice }</td>
					<td style="text-align:right;">${rentBook.allCount }</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</div>
