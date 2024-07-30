<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jstl 코어 태그립 추가 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
<link rel="stylesheet" type="text/css" href="./css/member.css" />
</head>
<body>
 <c:if test="${empty id}"> <%-- 로그인 전 화면 --%>
  <div id="Index_wrap">
     <h1 class="title_size">Index Page for EveryOne!!</h1>
     <span class="login_a"><a href="/login">로그인</a></span>
  </div>
 </c:if>
 
 <%--로그인 이후 화면 --%>
 <c:if test="${!empty id}">
   <div id="Index_wrap">
      
      <h1 class="title_size">Index Page for EventOne!!</h1>
     
     <h2 class="Index_title">로그인 후 메인화면</h2>
     <table id="Index_t">
       <tr>
        <th>
        <input type="button" value="정보수정" ><input type="button" 
        value="로그아웃" onclick="location='logout';" >
        </th>
       </tr>     
       
       <tr>
        <th class="idSize">'${id}' 아이디 님으로 로그인을 한 '${name}' 님
        환영합니다!</th>
       </tr>
       
       <c:if test="${auth == 'ROLE_BASICROLE_MANAGERROLE_ADMIN'}"> <%--권한이 BASIC,MANAGER,
       ADMIN인 경우 --%>
        <tr>
         <th><a href="#">Admin 페이지</a>&nbsp;&nbsp;<a href="#">MANAGER 페이지</a>&nbsp;&nbsp;<a 
         href="#">BASIC 페이지</a></th>
        </tr>
       </c:if>
       
       <c:if test="${auth == 'ROLE_BASICROLE_MANAGER'}">
        <tr>
         <th><a href="#">MANAGER 페이지</a>&nbsp;&nbsp;<a href="#">BASIC 페이지</a></th>
        </tr>
       </c:if>
       
       <c:if test="${auth == 'ROLE_BASICROLE_nullROLE_ADMIN'}">
        <tr>
         <th><a href="#">ADMIN 페이지</a>&nbsp;&nbsp;<a href="#">BASIC 페이지</a></th>
        </tr>
       </c:if>
       
       <c:if test="${auth == 'ROLE_nullROLE_MANAGERROLE_ADMIN'}">
        <tr>
         <th><a href="#">Admin 페이지</a>&nbsp;&nbsp;<a href="#">MANAGER</a></th>
        </tr>
       </c:if>
       
       <c:if test="${auth == 'ROLE_nullROLL_nullROLE_ADMIN' or 
       auth=='ROLE_nullROLE_ADMINROLL_null'}">
         <tr><th><a href="#">Admin 페이지</a></th></tr>
       </c:if>
       
       <c:if test="${auth =='ROLE_nullROLE_MANAGER'}">
        <tr><th><a href="#">MANAGER 페이지</a></th></tr>
       </c:if>
       
       <c:if test="${auth == 'ROLE_BASIC'}">
        <tr>
         <th><a href="#">BASIC 페이지</a></th>
        </tr>
       </c:if>
     </table>
     
   </div>
 </c:if>
</body>
</html>