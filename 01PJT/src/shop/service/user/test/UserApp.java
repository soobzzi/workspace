package shop.service.user.test;

import shop.service.user.User;

public class UserApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user = new User("홍길동", 18, "남자", "서울");
		
		System.out.println("이름 :"+user.getName());
		System.out.println(user);
		
		
		
		

	}

}
