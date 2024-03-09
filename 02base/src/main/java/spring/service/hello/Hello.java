package spring.service.hello;

/*
 * FileName : Hello.java
 * �� Bean �Ծ� : 
 *      - package / private Field(property) /  getter,setter 
 *      - Default Constructor / �ʿ��� Method definition 
 * �� POJO(Plain Old Java Object)
 *     - Ư�� �Ծ࿡ ���������� �ʴ´� //==> �� �ʿ��� �⺻ API�� ���������� �ʴ´�.
 *     - Ư�� ȯ�濡 ���������� �ʴ´� //==> Ư��ȯ�濡���� ������ �ʴ´�.
 */
public class Hello{
	
	///Field
	private String message = "Container �� �����ΰ�.";
	
	///Constructor Method
	public Hello() {
	}
	public Hello(String message) {
		this.message = message;
	}

	///Method
	//==> getter / setter Method definition
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	//==> message �� ����ϴ� Method  
	public void printMessage() {
		System.out.println("\n"+getClass().getName()+"=>"+message);
	}
	
}//end of class