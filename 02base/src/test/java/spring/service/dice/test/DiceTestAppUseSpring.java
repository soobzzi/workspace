package spring.service.dice.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.dice.play.Player02;
import spring.service.hello.Hello;


public class DiceTestAppUseSpring {

	/// main method
	public static void main(String[] args) {
		
		
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
											("./src/main/resources/config/diceservice.xml") );

		Player02 player01 = (Player02)factory.getBean("player01");
		player01.playDice(3);
		System.out.println("==================");
		System.out.println("선택된 주사위 수의 통합은 : " +player01.getTotalValue());
		System.out.println("==================\n\n");
		
		Player02 player02 = (Player02)factory.getBean("player02");
		player01.playDice(3);
		System.out.println("==================");
		System.out.println("선택된 주사위 수의 통합은 : " +player01.getTotalValue());
		System.out.println("==================\n\n");
		
		Player02 player03 = (Player02)factory.getBean("player03");
		player01.playDice(3);
		System.out.println("==================");
		System.out.println("선택된 주사위 수의 통합은 : " +player01.getTotalValue());
		System.out.println("==================\n\n");
		
		Player02 player04 = (Player02)factory.getBean("player04");
		player01.playDice(3);
		System.out.println("==================");
		System.out.println("선택된 주사위 수의 통합은 : " +player01.getTotalValue());
		System.out.println("==================\n\n");
	}
	
}//end of class