<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

	<section class="pt-2 pb-4 m-5">
          <div class="container px-4 px-lg-5 mt-3">
            <h3> 게시글 작성</h3>
            <form name="updateForm">            
              <table class="table">
              	<tr>
              		<th>번호</th>
              		<td><input type="text" name="bno" value="${boardInfo.bno}" /></td>
              	</tr>
                <tr>
                  <th>제목</th>
                  <td colspan="2"><input type="text" name="title" class="form-control" value="${boardInfo.title }"></td>
                </tr>
                <tr>
                  <th>내용</th>
                  <td colspan="2"><textarea cols="100" rows="6" name="contents"
                      class="form-control">${boardInfo.contents}</textarea>
                  </td>
                </tr>
                <tr>
                  <th>작성자</th>
                  <td colspan="2"><input type="text" name="writer" class="form-control" value="${boardInfo.writer }"></td>
                </tr>
                <tr>
                	<th>이미지</th>
                	<td colspan="2">
                		<input type="text" name="image" class="form-control" value="${boardInfo.image }" />
                	</td>
                </tr>
                <tr>
                  <td colspan="2" style="text-align:center;">
                    <button type="button" class="btn text-white" style="background-color: #fab3cc; margin : 10px;">수정</button>
                    <button type="button" class="btn text-white" style="background-color: #bbbbbb;" onclick="location.href='boardInfo?bno=${boardInfo.bno}'">수정취소</button>
                  </td>
                </tr>
              </table>
            </form>
          </div>
</section>

<script>
    $('form button:contains(수정)').on('click', modifyBoard);

    function modifyBoard(event) {
      if(!isValid) {
        return;
      }

      const object = getBoardInfo();

    	$.ajax('boardUpdate', {
    			type : 'post',
          // 따로 타입을 application/json형태로 안보내면 쿼리스트링 방식으로 보냄 (@RequestBody를 쓰지않고 단순 커맨드객체 사용)
          //.(만약 서버에서 @RequestBody 어노테이션으로 받는다면 application/json으로 바꾸고, 자바스크립트 객체를 json 문자열로 변환해야함)
          contentType : 'application/json',
          data : JSON.stringify(object) 
    	})
    	.done(result => {
    		window.location.href=`boardInfo?bno=${object.bno}`;
    	})
    	.fail(err => {
    		console.log(err);
    	})
    }

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
    function getBoardInfo() {
      //serializeArray -> ajax를 위해 만들어진 메소드. form태그 내부에있는 input과 value들을 모두 꺼내옴. 
      // 선택자로ㅓ 가져오는 방식보단 form태그 내부의 textarea, select등의 모든 정보를 가지고옴.
      let formAry = $('form[name="updateForm"]').serializeArray(); 
			let objData = {};
			
			// input 태그의 name속성을 이용해 js단에서 emp쪽 객체를 만들어 반환
			$(formAry).each((idx,tag) => {
        console.log(idx,tag);
				objData[tag.name] = tag.value;
			});
			return objData;
    }
</script>