package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

public class DiceBImpl implements Dice{
	private int value;
	
	public DiceBImpl() {
		System.out.println(":: " + getClass().getName() + "() 생성자...");
	}
	
	@Override
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	@Override
	public void selectedNumber() {
		// 1~6 중에 임의의 숫자가 리턴되도록....
		value = new Random().nextInt(6) + 1;
	}
}
