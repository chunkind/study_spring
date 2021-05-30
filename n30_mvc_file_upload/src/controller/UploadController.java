package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UpdateDataVO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UploadController extends MultiActionController{
	
	private String path;
	
	
	public void setPath(String path) {
		this.path = path;
	}


	public ModelAndView fileUpload(HttpServletRequest request, 
								HttpServletResponse response, UpdateDataVO vo)
															throws IOException{
		//1. upload된 파일을 받아온다.
		MultipartFile mFile = vo.getUploadFile();
		System.out.println("MultipartFile :: "+mFile);
		
		//2. 업로드된 파일이 있다면...
		//파일의 사이즈
		//파일의 원래이름
		//파일의 ...
		if(mFile.isEmpty()!=true){//업로드 한게 있다면..
			System.out.println("파일의 사이즈 : "+mFile.getSize());
			System.out.println("업로드된 파일명 : "+mFile.getOriginalFilename());
			System.out.println("파일의 파라미터명  : "+mFile.getName());
		}
		//3. upload된 파일을 별도의 경로로 이동시킨다...transfer,copy
		File copyFile = new File(path+mFile.getOriginalFilename());
		mFile.transferTo(copyFile);//원래 업로드한 파일이 해당 경로로 이동
		System.out.println("path :: "+ path);
		return new ModelAndView("upload_result","uploadfile",mFile.getOriginalFilename());
	}
	//fileDown 추가
	public ModelAndView fileDown(HttpServletRequest request, 
			HttpServletResponse response)throws IOException{
		System.out.println("File Download.."+request.getParameter("filename"));
		
		//Map에 Path를 setting...util>DownloadView를 참조해서 작성한다...
		Map map = new HashMap();
		//upload한 파일을 특정 경로로(path) 이동...이걸 다운로드 하는 것이다.
		map.put("path", path);
		
		//BeanNameViewResolver
		/*
		 * ajax-Json, FileDownload
		 */
		return new ModelAndView("downloadView",map);
	}	
}