<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>
 <h1>동기식(화면전환 있다) 파일첨부 자료실 실습</h1>
 <form method="post" action="uploadFormAction" enctype="multipart/form-data">
  <%-- 
    파일 첨부하는 기능을 만들때 주의사항)
     1.파일 첨부기능을 만들려면 반드시 method="post"방식으로 해야한다.
     2.form태그내에 enctype="multipart/form-data"를 지정해야 한다.
   --%>
   파일첨부:<input type="file" name="uploadFile" multiple />
   <%-- multiple속성을 사용하면 한개파일 또는 다중파일을 동시에 업로드 가능하다. --%>
   <input type="submit" value="파일업로드" />
 </form>
</body>
</html>