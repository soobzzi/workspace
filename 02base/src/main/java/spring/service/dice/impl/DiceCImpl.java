package spring.service.dice.impl;

import java.util.Random;

import spring.service.dice.Dice;

/*
 * FileName : DiceC.java
 * �� �ֻ��� Object Modeling
 * �� 1 ~ 6 ���� �����ϰ�  ����
 */
public class DiceCImpl implements Dice{
	
	///Field
	private int value;

	///Constructor
	public DiceCImpl() {
		System.out.println("::"+getClass().getName()+" ������....");
	}

	//Method (getter/setter)
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	//==> �ֻ����� ���� �������� ���� ����
	public void selectedNumber(){
		value = new Random().nextInt(6) + 1;
	}
	
}//end of class