package spring.mvc.model;
/*
 * Mock ::
 * Mock 객체 ::
 * 실제 Project 에서 돌아가는 동일한 코드가 아니라, 
 * 테스트를 위한 가상의 비지니스 로직을 담고 있는 Service class를 말한다.
 * 원래는 Dao도 함께 작성되어야 하지만 지금은 생략하기로 하자.
 */
public class MockService {
	public String register(CarVO carVO){
		System.out.println("자동차 하나 등록함 :: "+carVO);
		return "자동차 등록 성공 :: 모델명 :: "+carVO.getModel();
	}
}
