<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링 MVC 게시판 글수정</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <%-- jsp주석문기호, jQuery CDN방식 --%>
 <script src="../js/board.js"></script>
 <%-- ../는 상대경로로 한단계 상위폴더로 이동 --%> 
</head>
<body>
  <h2>스프링 MVC게시판 수정</h2>
  <form method="post" action="board_edit_ok" onsubmit="return check();" >
  <input type="hidden" name="bno" value="${bc.bno}" />
  <%-- hidden은 웹브라우저상에서는 만들어 지지 않는다. 하지만 bno 네임피라미터이름에 value속성값을 담아서 서버로 전달할 때 유용하게 사용된다.
  웹브라우저 결과창에서 페이지소스 보기하면 노출된다. 그러므로 비번같이 보안상 중요 데이터는 히든으로 전달하면 안된다. --%>
  
  <%--페이징에서 책갈피 기능을 구현하기 위한 히든 page --%>
  <input type="hidden" name="page" value="${page}" />
  
   <label for="writer">글쓴이</label>
   <input type="text" name="writer" id="writer" size="14" placeholder="글쓴이 입력" value="${bc.writer}" />
   <br/>
   
   <label for="title">글제목</label>
   <input type="text" name="title" id="title" size="36" placeholder="글제목 입력" value="${bc.title}" />
   <br/>
   
   <label for="content">글내용</label>
   <textarea name="content" id="content" rows="10" cols="34" placeholder="글내용 입력">${bc.content}</textarea>
   <hr/>
   
   <button type="submit">수정</button>
   <button type="reset" onclick="$('#writer').focus();">취소</button>
   <input type="button" value="목록" onclick="location='/board/board_list?page=${page}';" />
  </form>
</body>
</html>




