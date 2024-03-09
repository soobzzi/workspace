package shop.service.user;

public class User {
	
	private String name;
	protected int age;
	String gender;
	public String add;
	public static final String nationality = "대한민국";
	
	
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}


	public User(String name, int age, String gender, String add) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.add = add;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getAdd() {
		return add;
	}


	public void setAdd(String add) {
		this.add = add;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", gender=" + gender + ", add=" + add + "]";
	}

}
