package kosta.model.impl;

import kosta.model.Customer;

public class CustomerImpl implements Customer{

	@Override
	public void insertCustomer(String info) {
		System.out.println("insertCustomer.." + info);
	}

	@Override
	public void findCustomer(String ssn, String addr) {
		System.out.println("findCustomer.. 1) ssn : " + ssn + ", 2) addr : " + addr);
	}
}

/*
 * form으로 부터 값이 안받아졌거나.. 혹은 잘못된 값을 받은 경우
 * 디비의 비지니스로직 수행결과로 리턴값이 null이 리턴된다.
 * ::
 * 이럴경우
 * target의 Biz()로직이 수행되기 전 어드바이스가 먼저 가로채서 로직을 점검할수 있다.
 * Before Advice / Around Advice
 */