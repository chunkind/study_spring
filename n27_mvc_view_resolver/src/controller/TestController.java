package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
/*
 * ModelAndView에서 View page의 이름을 작성할 것이다.
 * 그러면 해당 컨트롤러가 View page의 물리적인 저장위치를 viewResolver를 통해서 알것이고
 * 그 위치에 있는 해당 뷰페이지를 호출하도록 되어 있다.
 * ::
 * 그런데 우리가 알고있는 InternalResourceViewResolver를 사용하면
 * 물리적인 공간이 오직 하나밖에는 주어지지 않는다.
 * WEB-INF/views/
 * ::
 * 이런 방법은 프로젝트 규모가 조금 커질 경우에는 많은 문제를 야기한다.
 * 클래스의 성격, 기능에 따라서 패키지가 복잡하게 구분되듯이
 * View Page의 성격에 따라서 디렉토리는 어느정도 구분되어 지는 것이 타당하다.
 * ::
 * findBoard()가 수행하고 나서의 결과페이지의 경로 :: webapp>board>result>find_ok.jsp
 * findProduct()가 수행하고 나서의 결과페이지의 경로 :: webapp>product>result>find_ok.jsp
 * findCustomer()가 수행하고 나서의 결과페이지의 경로 :: webapp>Customer>result>find_ok.jsp
 * 
 * register()가 수행하고 나서의 결과페이지의 경로 "" webapp>response>register_result.jsp
 */
public class TestController extends MultiActionController{
	public ModelAndView findBoard(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("findBoard() Call");
		return new ModelAndView("board_result"); //find_ok가 안들어갔다.
	}

	public ModelAndView findProduct(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("findProduct() Call");
		return new ModelAndView("product_result"); //find_ok가 안들어갔다.
	}

	public ModelAndView findCustomer(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("findCustomer() Call");
		return new ModelAndView("customer_result"); //find_ok가 안들어갔다.
	}
	
	public ModelAndView register(HttpServletRequest requset, HttpServletResponse response) {
		System.out.println("register() Call");
		return new ModelAndView("register_result"); //default resolver 방식
	}
}
