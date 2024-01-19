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
				<th style="text-align:center;">표지</th>
				<th style="text-align:center;">출판일자</th>
				<th style="text-align:center;">금액</th>
				<th style="text-align:center;">출판사</th>
				<th style="text-align:center;">도서소개</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="book" varStatus="sts">
				<tr>
					<td style="text-align:center;">${book.bookNo}</td>
					<td>${book.bookName}</td>
					<td><img style="width:80px;" src="<c:url value="/resources/images/${book.bookCoverimg}"/>" /></td>
					<td style="text-align:center;"><fmt:formatDate value="${book.bookDate}" pattern="yyyy/MM/dd"/></td>
					<td style="text-align:right;"><fmt:formatNumber value="${book.bookPrice }" pattern="#,###" /></td>
					<td>${book.bookPublisher}</td>
					<td>${book.bookInfo}</td>
				</tr>
			</c:forEach>	
		</tbody>
	</table>
</div>
