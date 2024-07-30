<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link rel="stylesheet" type="text/css" href="./css/member.css" />
</head>
<body>
 <%--로그인 이후 화면 --%>
 <div id="Index_wrap">
   <h1 class="title_size">Manager Page</h1>
   
   <h2 class="Index_title">로그인 후 메인화면</h2>
   <table id="Index_t">
    <tr>
     <th><input type="button" value="로그아웃" onclick="location='logout';" /></th>
    </tr>
    
    <tr>
     <th class="idSize">'${id}' 아이디 님으로 로그인 한 "${name}"님 환영합니다!</th>
    </tr>
    
    <tr>
     <th><a href="#">MANAGER 페이지</a></th>
    </tr>
   </table>
 </div>
</body>
</html>

