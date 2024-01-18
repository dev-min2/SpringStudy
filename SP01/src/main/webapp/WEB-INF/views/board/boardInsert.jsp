<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<section class="pt-2 pb-4 m-5">
          <div class="container px-4 px-lg-5 mt-3">
            <h3> 게시글 작성</h3>
            <form action="boardInsert" method="post">
              <table class="table">
                <tr>
                  <th>제목</th>
                  <td colspan="2"><input type="text" name="title" class="form-control"></td>
                </tr>
                <tr>
                  <th>내용</th>
                  <td colspan="2"><textarea cols="100" rows="6" name="contents"
                      class="form-control"></textarea>
                  </td>
                </tr>
                <tr>
                  <th>작성자</th>
                  <td colspan="2"><input type="text" name="writer" class="form-control"></td>
                </tr>
                <tr>
                	<th>이미지</th>
                	<td colspan="2">
                		<input type="text" name="image" class="form-control" />
                	</td>
                </tr>
                <tr>
                  <td colspan="2" style="text-align:center;">
                    <button type="submit" class="btn text-white" style="background-color: #fab3cc; margin : 10px;">등록</button>
                    <button type="button" class="btn text-white" style="background-color: #bbbbbb;" onclick="location.href='boardList'">작성취소</button>
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
			return false;
		}
		event.target.submit();
	});
	
	function isValid() {
		const title = $('input[name="title"]');
		if(title.val().length <= 0) {
			alert('제목 입력해주세요.');
			title.focus();
			return false;
		}
		
		const contents = $('textarea[name="contents"]');
		if(contents.val().length <= 0) {
			alert('내용 입력해주세요.');
			contents.focus();
			return false;
		}
		
		const writer = $('input[name="writer"]');
		if(writer.val().length <= 0) {
			alert('작성자 입력해주세요.');
			writer.focus();
			return false;
		}
		
		return true;
	}
</script>
        