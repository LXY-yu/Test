
public class Students {
	private String id;//学生编号
	private String name;//学生姓名
	private String sex;//学生性别  man woman
	private int age;//学生年龄
	private String phonenum;//电话号码
	
	public Students(){}


	public Students(String id,String name,String sex,int age,String phonenum){
		this.setId(id);
		this.setName(name);
		this.setSex(sex);
		this.setAge(age);
		this.setPhonenum(phonenum);
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
	public String toString() {
        return  this.id + "\t" + this.name + "\t"
                + this.sex + "\t" + this.age+"\t"+this.phonenum;
    }
	

}
