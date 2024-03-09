package spring.service.dice.test;

import spring.service.dice.play.Player01;

/*
 * FileName : DiceTestApp01.java
 */
public class DiceTestApp01 {
	
	///Main Method
	public static void main(String[] args){
		
		Player01 player01 = new Player01();
		player01.playDice(3);
		System.out.println("=======================");
		System.out.println("���õ� �ֻ��� ���� ������ : "+player01.getTotalValue());
		System.out.println("=======================");
		
	}
}//end of class

/*
 * [ ����� ����  :: �ٸ� �ֻ����� game �� ���� ��� ]
 * 
 * 		- Player01 �� DiceA�� ������(?, Has A::Association Relation) ����.
 * 			(�ٸ� �ֻ����� ����Ϸ� �ϸ� �ڵ���ü�� �����ؾ� �Ѵ�.)
 * 		- Player01 �� DiceA�� ������ ������ �ִ�. ( ���յ��� ���� :: Coupling )
 * 
 *  ==> Player01 / DiceA, DiceB, DiceC �� ���ѵ����ϸ�...
 *  1. Player �� ����� �ֻ��� ��ü�� ���� �����ʰ�, �ܺη� ���� ����� �ֻ����� �޴´ٸ�... 
 *  	( ���� :: Injection )
 *  2. Player �� �ֻ��� ������ �˰� ������ �ȴ�, ��ü���� DiceA / DiceB / DiceC ��  
 *  	�߿��� ������ �ƴϴ�.
 *      - Polymorphism  : �ϳ��� �������̽��� �پ��� Ȱ��
 *      - Encapsulation : �������̽� �ڷ� �������� ����ڴ� ��ü���� ������ ���ʿ�.
  */