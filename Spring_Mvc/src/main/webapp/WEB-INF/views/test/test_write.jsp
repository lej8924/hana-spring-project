<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<script type="text/javascript" src="./js/jquery-3.7.1.min.js"></script>
<%--jQuery 라이브러리를 로컬 컴에서 불러오기 --%>
<script src="./js/test.js"></script>
</head>
<body>
<h2>제목과 내용 입력폼</h2>
<form method="post" action="test_ok2" onsubmit="return test_check();">
 <label for="test_title">제목</label>
 <input name="test_title" id="test_title" size="36" placeholder="제목을 입력" /><br/><br/>
 <%-- input 태그에서 type속성을 생략하면 text이다. --%>
 <label for="test_cont">내용</label>
 <textarea name="test_cont" id="test_cont" rows="10" cols="34" placeholder="내용을 입력"></textarea>
 <hr/>
 <button>저장</button> <%--button태그에서 type속성을 생략하면 기본값은 submit이다. --%>
 <button type="reset" onclick="$('#test_title').focus();">취소</button>
</form>
</body>
</html>