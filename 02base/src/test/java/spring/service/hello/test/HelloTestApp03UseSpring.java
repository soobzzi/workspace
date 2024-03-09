package spring.service.hello.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import spring.service.hello.Hello;

/*
 * FileName : HelloTestApp03UseSpring.java
 * �� Hello Bean ����ϴ� Application
 * �� Hello Bean ��  dependency Relation
 * �� Spring Framework ���� �����ϴ� API�� ��� instance ����
 * 		[[[ HelloTestApp02�� �� ]]]
 * 		- hello.properties  ==> hello.xml
 * 		- HelloFactory ==> org.springframework.beans.factory.BeanFactory     
 
	==>	Spring Framework �� �پ��� ��Ÿ������ ��  xml �� �Ϲ������� ����ϸ�,
	  		instance ����, �ʱ�ȭ, ��ü�� ��ȣ ���踦  xml �� ���������� ���. 
	  				
			<bean id="hello" class="spring.services.hello.Hello"/>
			
	==> 	HelloFactory :  Hello Data type �� ���� �ϴ� Factory 
	==> Spring Framework :��� Data Type(Bean/POJO) ���������ϴ� Factory
 */
public class HelloTestApp03UseSpring {

	/// main method
	public static void main(String[] args) {
		
		//1. BeanFactory �� �̿� xml �� ���������� ����� instance ���� ȹ��
		BeanFactory factory =
				new XmlBeanFactory( new FileSystemResource
																	("./src/main/resources/config/hello.xml") );

		//2. Container �� ���� hello �� name �� ���� instance return �ޱ�  
		Hello hello = (Hello)factory.getBean("hello");
		hello.printMessage();
	}
	
}//end of class