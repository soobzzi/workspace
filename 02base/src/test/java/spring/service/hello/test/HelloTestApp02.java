package spring.service.hello.test;

import spring.service.hello.Hello;
import spring.service.common.HelloFactory;
/*
 * FileName : HelloTestApp02.java
 * �� Hello Bean ��� Application
 * �� Hello Bean ��  dependency Relation
 * �� [ HelloTestApp01�� �� ]
 * 		- �����  Bean �� hello.properties(meta-data)�� ����
 * 		- instance �� ���� �������� ������, HelloFactory ���� ����,return �Ǵ� instance ���.
 */
public class HelloTestApp02 {
	
	///main method
	public static void main(String[] args) {
		
		// 1. ����� Bean  ������ ����  hello.properties(meta-data)��
		//      parsing, Bean instance�� ������ HelloFactory  instance ����
		HelloFactory helloFactory =	HelloFactory.getInstance();
		
		// 2.  helloFactory instance �� parsing �� resource::meta-data(hello.properties) ����   
		helloFactory.setConfigResource("./src/main/resources/config/hello.properties");
		//helloFactory.setConfigResource("./bin/config/hello.properties");
		
		// 3. helloFactory instance �� ���� instance.one �̸��� ���� Hello instance Request
		// �Ľ��Ϸ�����
		Hello hello = helloFactory.getBean("instance.one");
		
		// 4.  printMessage() ȣ��  
		hello.printMessage();
	}
	
}//end of class


/*
 * [[[[[[ HelloTestApp01 ����� ���� ]]]]]] �� ��
 * 
 * [ ����� ���� :: �ٸ� Bean ��� �� ��� Message ���� ��... ]
 * 
 * 1. new Hello() �� instance ���� 
 * 		-  Hello.class, ���� class �Ǵ� �ٸ� class ����� �� ��� 
 * 			==>  �ٽ� �ڵ� �� ������ ���� ����
 *     [[[[[[ HelloTestApp02 ���� ]]]]]] 
 *     		 : �ٸ� Bean ����� ��� hello.properties �� ������ �����Ѵٸ�....
 * 
 * 2. ����� message �ϵ� �ڵ� 
 *		-  �ٸ� message �� ������� �Ѵٸ� 
 *			==> �ٽ� �ڵ� �� ������ ���� ���� 
 *     [[[[[[ HelloTestApp02 ���� ]]]]]]
 *     		 : HelloTestApp02�� ������
 *			 ==> hello.properties �� Message �� ���� �ҷ��� �� �ִٸ�....
 */