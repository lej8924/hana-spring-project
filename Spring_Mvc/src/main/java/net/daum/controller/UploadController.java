package net.daum.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import net.daum.service.Test2Service;
import net.daum.vo.Test2VO;

@Controller
public class UploadController {
	
	@Autowired
	private Test2Service test2Service;

	//동기식 파일첨부 뷰페이지
	@GetMapping("/uploadForm")
	public void uploadForm() {
		//리턴 타입이 없는 void형이면 매핑주소인 uploadForm이 뷰페이지 파일명이 된다.
	}//uploadForm()
	
	@PostMapping("/uploadFormAction")
	public void uploadFormAction(MultipartFile[] uploadFile, HttpServletRequest request) {
		/* uploadFile 매개변수명과 input type="file"의 네임피라미터 이름이 같아야 한다. 
		 */
		String uploadFolder = request.getSession().getServletContext().getRealPath("upload");//첨부된 실제 이진파일이 업로드
		//될 실제 upload경로를 구함
		System.out.println("실제 업로드 경로 : "+uploadFolder);
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("========================>");
			System.out.println("upload file name :"+ multipartFile.getOriginalFilename());
			System.out.println("upload file size :"+ multipartFile.getSize());
			
			File saveFile = new File(uploadFolder, multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile);//upload폴더에 실제첨부된 파일 업로드 함
			}catch(Exception e) {e.printStackTrace();}
		}//향상된 확장 for
		
	}//uploadFormAction()
	
	//비동기식 파일첨부 뷰페이지
	@RequestMapping(value="/uploadAjax",method=RequestMethod.GET) //get으로 접근하는 매핑주소 처리
	public ModelAndView uploadAjax() {
		return new ModelAndView("uploadAjaxForm");//뷰페이지 경로가 /WEB-INF/views/uploadAjaxForm.jsp
	}//uploadAjax()
	
	@RequestMapping(value="/uploadAjaxAction", method=RequestMethod.POST) //post로 접근하는 매핑주소 처리
	public void uploadAjaxAction(MultipartFile[] uploadFile, HttpServletRequest request) {
		
		System.out.println("\n ====================> upload Ajax post.....");
		String uploadFolder=request.getSession().getServletContext().getRealPath("upload");
		
		for(MultipartFile multipartFile : uploadFile) {
			System.out.println("\n =======================> \n");
			System.out.println("Upload File Name : "+ multipartFile.getOriginalFilename());
			System.out.println("Upload File Size : "+ multipartFile.getSize());
			
			String uploadFileName = multipartFile.getOriginalFilename();//첨부된 파일명을 구함
			uploadFileName = uploadFileName.substring(uploadFileName.lastIndexOf("\\")+1);
			/* 인터넷 익스플로워인 경우는 첨부파일 전체 경로가 전송된다. 경로구분 '\'를 lastIndexOf()메서드에 의해서 맨 오른쪽에부터 찾아서
			 * 가장 먼저 나오는 '\'의 위치번호를 맨왼쪽 0부터 시작해서 구한다.
			 * 결국 마지막 경로구분 '\' 이후 부터 마지막 문자까지 구하면 실제 첨부 원본파일명을 구함.
			 */
			System.out.println("only file name : "+uploadFileName);
			
			File saveFile = new File(uploadFolder , uploadFileName);
			
			try {
				multipartFile.transferTo(saveFile);
			}catch(Exception e) {e.printStackTrace();}
		}//for
	}//uploadAjaxAction()
	
	/* 문제 */
	@GetMapping("/test_write")
	public String test_write() {
		/* 문제1) tbl_test테이블을 설계한다.
		 *       컬럼명    데이터타입        제약조건    설명
		 *       test_no  number(38)     기본키     번호
		 *       test_title varchar2(200) not null 제목
		 *       test_cont  varchar2(4000) not null 내용
		 *       
		 *       1부터 시작하고, 1씩증가하고,nocache,nocycle옵션을 가진 test_no_seq 시퀀스를 생성한다. 이 시퀀스를 생성해서
		 *       test_no컬럼 번호 레코드 저장값 용도로 활용한다.
		 *       
		 *  문제2) net.daum.vo패캐지에 TestVO.java 데이터 저장빈 클래스를 만들고, mybatis-config.xml에서 객체 별칭이름을 test로 등록
		 *  한다.
		 *  매퍼태그 test.xml를 만든다. net.daum.dao패키지에 TestDAO.java인터페이스를 만들고 이를 구현 상속한 TestDAOImpl.java를 만든
		 *  다. net.daum.service패키지에 TestService.java 인터페이스를 만들고,이를 구현한 TestServiceImpl.java를 만든다.
		 *  
		 *  문제3)뷰페이지 경로가 /WEB-INF/views/test/test_write.jsp 뷰페이지 파일명을 만들고, 제목 과 내용입력폼을 만들고 유효성 검증
		 *  처리를 한다. 폼태그 action저장 매핑주소는 test_ok로 한다.
		 *  저장메서드는 test_insert(vo)로 하고, test.xml의 유일아이디명은 test_in으로 한다. 저장되는 부분을 만들면 된다.
		 */
		return "test/test_write";
	}//test_write
	
	//저장
	@PostMapping("/test_ok2")
	public ModelAndView test_ok2(Test2VO tvo) {
		/* test_write.jsp의 네임피라미터 이름과 Test2VO.java의 변수명을 같게 하면 Test2VO의 매개변수 명 tvo에 제목과 내용이 저장되어 있
		 * 다.
		 */
		
		this.test2Service.insert_test(tvo);
		return null;
	}//test_ok2()
}



































