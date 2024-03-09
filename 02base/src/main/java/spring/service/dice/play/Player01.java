package spring.service.dice.play;

import spring.service.dice.DiceA;

/*
 *	FileName : Player01.java
 *	�� DiceA �� ������(?, has a :: Association Relationship)�ִ� Player Object 
 *  �� DiceA �� ���, ���� �����ϴ� Method Definition 
 */
public class Player01 {
	
	///Field
	private DiceA diceA = new DiceA();
	private int totalValue;
	
	///Constructor Method
	public Player01() {
	}
	
	///Method (getter/setter)
	public DiceA getDiceA() {
		return diceA;
	}
	public void setDiceA(DiceA diceA) {
		this.diceA = diceA;
	}
	public int getTotalValue() {
		return totalValue;
	}
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count ��ŭ �ֻ����� ������ ���� ���ϴ� ����
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			diceA.selectedNumber();
			System.out.println("::[ "+diceA.getClass().getName()+" ] �� ���õȼ� : "+diceA.getValue());
			totalValue += diceA.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class