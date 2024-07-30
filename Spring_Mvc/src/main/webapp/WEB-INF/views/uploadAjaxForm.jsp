<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비동기식 아작스 파일첨부 </title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
 <%-- jsp주석문기호, jQuery CDN방식 --%>
<script>
  $(document).ready(function(){
	  
	  $('#uploadBtn').on('click',function(e){
		 
		  var formData = new FormData();
		  /* 비동기식 아작스를 이용해서 파일 데이터만을 전송. 아작스를 이용하는 첨부파일 처리는 FormData라는 객체를 이용한다.
		  */
		  var inputFiles = $("input[name='uploadFile']");//file 객체를 구함
		  var files = inputFiles[0].files;//첫번째 파일객체에서 첨부한 파일을 배열로 구한다.
		  
		  for(var i=0;i<files.length;i++){
			  formData.append("uploadFile",files[i]);
		  }
		  
		  $.ajax({
			 url:'/uploadAjaxAction', //서버 매핑주소 
			 processData : false,//process 데이터를 컨텐트 타입에 맞게 변환
			 contentType : false, 
			 data : formData, //폼데이터객체 전송
			 type:'POST',//보내는 방식
			 success: function(result){
				 //받아오는 것이 성공시 호출되는 콜백함수
			 }
		  });
	  });
  });
</script>
</head>
<body>
  <h1>upload with Ajax</h1>
  <input type="file" name="uploadFile" multiple />
  <hr>
  <button type="submit" id="uploadBtn">Upload</button>
  <%-- button 태그에서 type 속성을 생략하면 기본값은 submit이다. --%>
</body>
</html>





