/**
 * test.js
 */

function test_check(){
	
	if($.trim($('#test_title').val()) == ''){
		alert('제목을 입력하세요!');
		$('#test_title').val('').focus();
		return false;
	}
	
	if($.trim($('#test_cont').val()) == ''){
		alert('내용을 입력하세요!');
		$('#test_cont').val('');//입력필드 초기화
		$('#test_cont').focus();//입력필드 포커스 이동
		return false;
	}
}