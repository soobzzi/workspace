package mybatismini.service.user.test;

import org.apache.ibatis.session.SqlSession;

import mybatismini.service.domain.User;

public class myBatisMiniTestApp10 {
	
	public static void main(String[] args) throws Exception{
		
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("==");
		
		
		
		User user = new User();
	    user.setUserId("나카나카");
	    user.setUserName("다나카");
	    user.setPassword("1234");
	    user.setSsn("561211293847");
	    user.setPhone("01038273293");
	    user.setAddr("nippon");
	    user.setEmail("danaka@gmail.com");
	    
	    System.out.println(" User :"+ user);
	    
	    System.out.println("1. insertUser ");
	    System.out.println(":: "+ sqlSession.insert("UserMapper.insertUser", user));
	    System.out.println("====================");
	    
		System.out.println("2. findUser ");
		System.out.println(":: "+ sqlSession.selectOne("UserMapper.findUser",user.getUserId()));
		System.out.println("====================");
		
		System.out.println("3. updateUser ");
		System.out.println("before update :: "+sqlSession.selectOne("UserMapper.findUser",user.getUserId()));
		
		user.setEmail("danakanaka@yahoo.com");
		
	    System.out.println(":: "+ sqlSession.update("UserMapper.updateUser", user));
	    System.out.println("====================");
		
		
	
	}

}
