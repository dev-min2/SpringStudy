<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<section class="">
	<div class="container">
		<h3 style="text-align:center;">도서 등록</h3>
		<form action="bookInsert" method="post">
            <table class="table">
				<tr>
					<th>도서번호</th>
					<td colspan="2"><input type="text" name="bookNo" class="form-control" value="${bookNo}" readonly></td>
                </tr>
                <tr>
					<th>도서명</th>
					<td><input type="text" name="bookName" class="form-control"></td>
                </tr>
                <tr>
                  	<th>도서표지</th>
                  	<td colspan="2"><input type="text" name="bookCoverimg" class="form-control"></td>
                </tr>
                <tr>
                	<th>출판일자</th>
                	<td colspan="2"><input type="text" name="bookDate" class="form-control" /></td>
                </tr>
                <tr>
                	<th>금액</th>
                	<td colspan="2"><input type="text" name="bookPrice" class="form-control" /></td>
                </tr>
                <tr>
                	<th>출판사</th>
                	<td colspan="2"><input type="text" name="bookPublisher" class="form-control" /></td>
                </tr>
                <tr>
                	<th>도서소개</th>
                	<td colspan="2">
                		<textarea cols="100" rows="6" name="bookInfo"class="form-control"></textarea>
                  	</td>
                </tr>
                <tr>
                  <td colspan="2" style="text-align:center;">
                    <button type="submit" class="btn text-white" style="background-color: #fab3cc; margin : 10px;">등록</button>
                    <button type="button" class="btn text-white" style="background-color: #bbbbbb;" onclick="location.href='bookList'">작성취소</button>
                  </td>
                </tr>
			</table>
		</form>
	</div>
</section>

<script>
$('form').on('submit', function(event) {
	event.preventDefault();
	
	if(!isValid()) {
		return;
	}
	event.target.submit();
});

function isValid() {
	const bookName = $('input[name="bookName"]');
	if(bookName.val().length <= 0) {
		alert('도서명이 입력되지 않았습니다.');
		bookName.focus();
		return false;
	}
	return true;
}
</script>