package spring.service.dice.test;

import spring.service.dice.impl.DiceAImpl;
import spring.service.dice.impl.DiceBImpl;
import spring.service.dice.play.Player02;


public class DiceTestApp02 {
	///Main Method
	public static void main(String[] args){
		
		//생성자를 통한 Dice 주입.
		Player02 player01 = new Player02(new DiceAImpl());
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");

		//setter로 주입
		Player02 player02 = new Player02();
		player02.setDice(new DiceBImpl());
		player02.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player02.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class


/*
 * Player01에 비해서 02는 여러개의 주사위를 던질 수 있도록 interface 기반으로 설계하였다.
 * 그래서, 훨씬 클래스 관계까 유연해졌고 이는 재사용성의 증가로 이어진다.
 * 
 * 하지만, 여기서 문제점 :: 
 * new Player02(new DiceAImpl());
 * setDice(new DiceBImpl());
 * 주입의 통로는 생성자 혹은 setter()이고 이 두개의 통로를 다 사용했다.
 * 하지만 두 곳에서 다 new라는 키워드를 사용했고
 * 이는 소스코드에 구상객체명이 노출된 것이고 재사용성을 떨어뜨리는 요인이다.
 * 즉, 클래스의 연관 관계가 자유롭지 못하다.
 * 
 * ----------------------------------------------------------------------
 * 
 * 객체를 생성하는 주체가 따로 있어야 한다.
 * --> Spring Container / DI Container / DI Framework / IOC Container
 */

