<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
  <h2>CUSTOM LOGOUT PAGE</h2>
  
  <form method="post">
   <%-- action속성이 생략되면 이전 매핑주소인 logout이 action속성값이 된다. 동일 매핑주소 구분은 메서드 방식으로 구분한다.이전것은
   get이고 지금것은 post이다. --%>
    <h3>Logout</h3>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <button type="submit" class="btn">로그아웃</button>
  </form>
</body>
</html>