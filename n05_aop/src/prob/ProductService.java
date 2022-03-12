package prob;

/*
 * MemberService와 마찬가지로 ProductService도
 * 비지니스 로직(Core Concern)이 들어가 있는 Target 객체이다.
 * 하지만 핵심적인 로직 사이에 부수적인 관심가(Cross Cutting Concern)가
 * 산발적으로 들어있다..그렇기에 Oop의 본질을 흐리고 있다.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProductService {
	private Log log = LogFactory.getLog(getClass());

	public void deleteProduct(){
		System.out.println("상품이 삭제되었습니다.");
		log.info("delete Product..");
	}

	public void updateProduct(String id){
		System.out.println("상품 정보를 수정했습니다..");
		log.info("update Product..");
	}

	public void searchProduct(String id){
		System.out.println(id + " 로 상품을 검색했습니다.");
		log.info("search Product..");
	}
}