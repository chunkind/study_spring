package step02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @Auth: K. J. S.
 * @Date: 2022. 3. 12.
 * 비즈니스 로직이 있는 ProductService
 */
public class ProductService {
	private Log log = LogFactory.getLog(getClass());
	
	public void deleteProduct(){
//		System.out.println("상품이 삭제되었습니다.");
		log.info("delete Product..");
	}
	
	public void updateProduct(String id){
//		System.out.println("상품 정보를 수정했습니다..");
		log.info("update Product..");
	}
	
	public void searchProduct(String id){
//		System.out.println(id + " 로 상품을 검색했습니다.");
		log.info("search Product..");
	}
}