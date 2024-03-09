package spring.service.dice.play;

import spring.service.dice.Dice;

/*
 *	FileName : Player01.java
 *	�� DiceA �� ������(?, has a :: Association Relationship)�ִ� Player Object 
 *  �� DiceA �� ���, ���� �����ϴ� Method Definition 
 */
public class Player02 {
	
	///Field
	private Dice dice;
	private int totalValue;
	
	///Constructor Method
	public Player02() {
		System.out.println("::" + getClass().getName()+"����Ʈ ������..");
	}
	
	public Player02(Dice dice) {
		System.out.println("::" + getClass().getName()+"Dice �ν��Ͻ��� ���ڷ� �޴� ������...");
		this.dice = dice;
	}
	
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	public void setDice(Dice dice) {
		this.dice = dice;
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
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] �� ���õȼ� : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}

}//end of class