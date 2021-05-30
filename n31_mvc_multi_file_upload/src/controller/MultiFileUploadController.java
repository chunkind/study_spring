package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MultiFileVO;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class MultiFileUploadController extends MultiActionController{
	private String path;	
	
	public void setPath(String path) {
		this.path = path;
	}
	public ModelAndView multiFileUpload(HttpServletRequest request, 
			HttpServletResponse response, MultiFileVO vo)throws IOException{
		
		//1.업로드된 파일을 받아온다...List로 반환
		List<MultipartFile> files=vo.getFile();
		
		String[ ] nameList=  new String[files.size()];
		
		//2. 파일의 사이즈, 파일의 이름..그리고 특정한 upload 경로로 파일을 이동시킴
		for(int i=0; i<files.size(); i++){
			System.out.println("파일의 사이즈 :: "+files.get(i).getSize());
			System.out.println("파일의 이름 :: "+files.get(i).getOriginalFilename());
			String filename = files.get(i).getOriginalFilename();
			
			nameList[i] = filename;
			
			files.get(i).transferTo(new File(path+filename));
		}
		
		return new ModelAndView("multi_upload_result","uploadfile",nameList);		
	}
	
	//fileDown
	public ModelAndView fileDown(HttpServletRequest request, 
			HttpServletResponse response)throws IOException{
		System.out.println("Download File :: "+request.getParameter("filename"));
		HashMap map = new HashMap();
		map.put("path", path);
		
		return new ModelAndView("downloadView",map);
	}

}