package spring.service.dice.play;

import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import spring.service.dice.Dice;


/*
 *	어플리케이션 객체간의 연관관계 형성은 DI개념의 핵심이며 이러한 객체간의 연관을 Wiring 이라 한다.
 *	Spring Framework에서 제공하는 Wiring을 xml의 선언적 방식과 bean Definition 방법을 통해서 이해하자
 *  
 */
public class MultiPlayer {
	
	///Field
	private Dice dice;
	private List<Dice> diceList;
	private Dice[ ] diceArray;
	private Set<Dice> diceSet;
	private Map<String,Dice> diceMap;
	private Properties diceProperties;
	private Calendar currentDate = Calendar.getInstance();
	
	
	///Constructor Method
	public MultiPlayer() {
		System.out.println("::"+getClass().getName()+" 디폴트 생성자");
	}
	
	public MultiPlayer(Dice dice) {
		System.out.println("::"+getClass().getName()+" dice 인스턴스를 인자로 받는 생성자...");
		this.dice = dice;
	}
	///Method (getter/setter)

	public Dice getDice() {
		return dice;
	}

	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public List<Dice> getDiceList() {
		return diceList;
	}

	public void setDiceList(List<Dice> diceList) {
		this.diceList = diceList;
	}

	public Dice[] getDiceArray() {
		return diceArray;
	}

	public void setDiceArray(Dice[] diceArray) {
		this.diceArray = diceArray;
	}

	public Set<Dice> getDiceSet() {
		return diceSet;
	}

	public void setDiceSet(Set<Dice> diceSet) {
		this.diceSet = diceSet;
	}

	public Map<String, Dice> getDiceMap() {
		return diceMap;
	}

	public void setDiceMap(Map<String, Dice> diceMap) {
		this.diceMap = diceMap;
	}

	public Properties getDiceProperties() {
		return diceProperties;
	}

	public void setDiceProperties(Properties diceProperties) {
		this.diceProperties = diceProperties;
	}

	public Calendar getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Calendar currentDate) {
		this.currentDate = currentDate;
	}
	

}//end of class



