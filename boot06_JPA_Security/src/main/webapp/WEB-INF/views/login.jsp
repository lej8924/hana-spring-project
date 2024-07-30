<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 폼</title>
<link rel="stylesheet" type="text/css" href="./css/member.css" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<%-- jquery.com에서 제공하는 최신 jQuery 라이브러리 읽어오는 CDN방식 --%>
<script type="text/javascript">
  function login_check(){
	  if($.trim($('#username').val()) == ''){
		  alert('아이디를 입력하세요!');
		  $('#username').val('').focus();
		  return false;
	  }
	  
	  if($.trim($('#password').val()) == ''){
		  alert('비번을 입력하세요!');
		  $('#password').val('').focus();
		  return false;
	  }
  }//로그인 인증 유효성 검증(Validate)
  
  //비번 공지창
  function pwd_find(){
	  $url = 'pwd_find';//매핑주소 저장
	  window.open($url,'비번검색창','width=400px,height=300px,scrollbars=yes');
	  /* 자바스크립트의 window객체 하위의 open(공지창 경로,공지창이름,공지창속성)메서드를 사용해서 폭이 400픽셀,높이가 300픽셀,스크롤
	  바가 생성되는 새로운 공지창을 만든다.
	  */
  }
</script>
</head>
<body>
  <%--로그인 전 화면 --%>
  <div id="Login_wrap">
   <h2 class="Login_title">로그인 폼</h2>
   <div style="margin:0px 0px 0px 50px;">
     <c:if test="${param.error != null}">
       <h2>Invalid Username or password</h2>
       <h2><c:out value="${param.error}" /></h2>
       <%-- JSTL에서 <c:out value="" />는 값을 출력할 때 사용한다. --%>
     </c:if>
   </div>
   
   <div style="margin:0px 0px 0px 50px;">
     <c:if test="${param.logout != null}">
        <h2>You have been logged out.</h2>
     </c:if>
   </div>
   
   <form method="post" onsubmit="return login_check();">
   <%--form 태그에서 action속성을 생략하면 이전 매핑주소가 action속성값이 된다. 결국 login매핑주소가 action속성값이 된다.
   스프링 시큐리티가 적용되면 post방식으로 보내는 모든 데이터에는 CSRF토큰값이 필요하다. --%>
   <table id="Login_t">
    <tr>
      <th>아이디</th>
      <td><input name="username" id="username" size="14" tabindex="1" placeholder="아이디" /></td>
      <%--tabindex="1"로 지정하면 탭키를 눌렀을 때 첫번째로 포커스를 가진다. input 태그에서 type속성을 생략하면 기본값은 
      text이다.--%>
      <th rowspan="2">
         <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
         <%-- _csrf 속성은 사이트 간 요청 위조를 방지하기 위한 것으로 ,요청을 보내는 URI에서 서버가 가지는 동일한 값과 같은 값을 가지고
         데이터를 전송할 때에만 신뢰하는 방법이다. --%>
         <input type="submit" value="로그인" />
      </th>
    </tr>
    
    <tr>
      <th>비밀번호</th>
      <td><input type="password" name="password" id="password" size="14" tabindex="2" placeholder="비밀번호" /></td>
    </tr>
    
    <%-- remember-me 자동로그인 기능 추가코드 --%>
     <tr>
      <td colspan="2">
      Remember-Me : 
      <input type="checkbox" id="remember-me" name="remember-me" >
      <%-- 스프링 시큐리티에서 자동 로그인 유지 기능을 쿠키를 사용해서 remember-me라는 이름으로 특정 토큰 데이터를
      저장 유지한다.새롭게 추가된 체크박스 네임피라미터 이름을 remember-me로 지정한다. 로그인 화면에서 remember-
      me 체크박스를 체크하고 로그인하면 웹브라우저 상에 remember-me라는 쿠키가 생성된다. 생성된 'remember-me' 쿠키
      는 유효시간이 설정되면 브라우저 내부에 저장한다. 따라서 사용자가 브라우저를 종료하고 다시 브라우저를 실행한 다음
      같은 서버상의 도메인 주소로 접근하면 자동으로 브라우저에 보관된 'remember-me'쿠키는 그대로 가진 상태에서 서버에 접근
      해서 자동 로그인 기능이 유지된다. 물론 로그아웃 하면 브라우저에 저장된 'remember-me' 쿠키는 삭제되어서 자동 로그인
      기능을 유지하지 못한다.
      스프링 시큐리티는 기본적으로 'remember-me'라는 기능을 사용하기 위해서 'Hash-based Token 저장방식' 또는
      'Persistent Token 저장방식'을 사용할 수 있다. 아무런 설정을 하지 않으면 'Hash-based Token'방식을 사용한다.
      --%>
      </td>
     </tr>
   </table>
   <div id="Login_menu">
     <input type="button" value="비번찾기" onclick="pwd_find();" /> <input type="button" value="회원가입"
     onclick="location='member_join';" />
   </div>
   </form>
  </div>
</body>
</html>



