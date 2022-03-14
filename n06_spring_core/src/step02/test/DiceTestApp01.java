package step02.test;

import step02.play.Player01;

/*
 * FileName : DiceTestApp01.java
 * ㅇ DiceA / Player01 Test 하는 Application 
 */
public class DiceTestApp01 {
	//Main Method
	public static void main(String[] args){
		Player01 player01 = new Player01();
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("선택된 주사위 수의 통합은 : "+player01.getTotalValue());
		System.out.println("=======================");
	}
}