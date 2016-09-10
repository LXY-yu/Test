
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static Map<String, Students> stuMap = new HashMap<String, Students>();
	
	public static void welcome(){
		System.out.println("欢迎使用学员通讯录管理系统");
		System.out.println("  制作人：讯腾科技");
		System.out.println();
		System.out.println("1.登录    2.注册    3.找回密码      0.注销");
		System.out.print("请选择");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		switch(a){
		case 1:
			denglu();
			break;
		case 2:case 3:case 0:
			System.out.println("正在开发中");
			break;
		default:
			System.out.println("输入不合规范");
			break;
			
		}
	}


	public static void main(String[] args) {
		
		
		Main.welcome();
		

	}

	private static void denglu() {
		Scanner scan=new Scanner(System.in);
		System.out.println();
		System.out.print("请输入账号:");
		String s1=scan.nextLine();
		System.out.print("请输入密码:");
		String s2=scan.nextLine();
		System.out.println("      1.添加学员");
		System.out.println("      2.显示所有学员");
		System.out.println("      3.查找学员");
		System.out.println("      4.修改学员");
		System.out.println("      5.删除学员");
		System.out.println("      0.退出");
		System.out.print("请选择:");
		int b=scan.nextInt();
		switch(b){
		case 1:
			addStu();
			break;
		case 2:
			showStu();
			break;
		case 3:
			findStu();
			break;
		case 4:
			modifyStu();
			break;
		case 5:
			deleteStu();
			break;
		case 0:
			System.out.println("===================");
			System.out.println("===   欢迎下次使用      ===");
			System.out.println("===================");
			break;
		default:
			System.out.println("输入不合规范");
			break;
		}
		
		
		
	}
	
	/**
	 * 删除学员
	 */
	private static void deleteStu() {
		System.out.println("请输入要删除的学员编号：");
		Scanner scan=new Scanner(System.in);
		String id=scan.nextLine();
		//stuMap.remove(stuMap.get(id));
		Students st=stuMap.get(id);
		if(st==null){
			System.out.println("该ID不存在,请重新输入！");
			deleteStu();
		}else{
			stuMap.remove(id);
			System.out.println("成功删除学生："+st.getName());
		}
		welcome();
	}
	
	/**
	 * 修改学员
	 */
	private static void modifyStu() {
		System.out.println("请输入要修改的学员编号：");
		Scanner scan=new Scanner(System.in);
		String d=scan.nextLine();
		Students st=stuMap.get(d);
		if(st!=null){
			System.out.println("编号");
			String id=scan.nextLine();
			System.out.print("姓名：");
			String name=scan.nextLine();
		
			System.out.print("性别：");
			String sex=scan.nextLine();
			
			System.out.print("年龄：");
			int age=scan.nextInt();
			
			System.out.print("电话：");
			String phonenum=scan.next();
			
			st.setId(id);
			st.setName(name);
			st.setSex(sex);
			st.setAge(age);
			st.setPhonenum(phonenum);
			System.out.println("学员信息修改成功！");
		    System.out.println(st.getId()+"\t"+st.getName()+"\t"+st.getSex()+"\t"+st.getAge()+"\t"+st.getPhonenum());
		}else{
			System.out.println("不存在该学生,请重新输入！");
			modifyStu();
		}
		welcome();
		
		
	}
	
	/**
	 * 查询学生
	 */
	private static void findStu() {
		System.out.println("1.按编号查找");
		System.out.println("2.按姓名查找");
		System.out.println("3.按电话查找");
		System.out.println("4.按年龄查找");
		System.out.print("请输入（1-4）选择查询方式:");
		Scanner scan=new Scanner(System.in);
		int c=scan.nextInt();
		switch(c){
		case 1:
			findStuById();
			break;
		case 2:
			findStuByName();
			break;
		case 3:
			findStuByphonenum();
			break;
		case 4:
			findStuByAge();
			break;
		default:
			System.out.println("输入不合规范");
			break;
		}
		welcome();

	}
	
	/**
	 * 查询学生
	 */
	
	/*
	 * 通过年龄查找
	 */
	private static void findStuByAge() {
		System.out.println("请输入要查询的年龄：");
		Scanner scan=new Scanner(System.in);
		int age=scan.nextInt();
		System.out.println("编号"+"\t姓名"+"\t性别"+"\t年龄"+"\t电话号码");
		Set<String> keySet = stuMap.keySet();
		Iterator<String> it = keySet.iterator();
		  while (it.hasNext()) {
		   String key = it.next();
		   Students value = stuMap.get(key);
		   if(value.getAge()==age){
			   System.out.println(value);
		   }
		  }
		
	}
	
	/*
	 * 通过电话查找
	 */
	private static void findStuByphonenum() {
		System.out.println("请输入要查询的电话：");
		Scanner scan=new Scanner(System.in);
		String phonenum=scan.nextLine();
		System.out.println("编号"+"\t姓名"+"\t性别"+"\t年龄"+"\t电话号码");
		Set<String> keySet = stuMap.keySet();
		Iterator<String> it = keySet.iterator();
		  while (it.hasNext()) {
		   String key = it.next();
		   Students value = stuMap.get(key);
		   if(value.getPhonenum().equals(phonenum)){
			   System.out.println(value);
		   }
		  }
		
	}
	
	/*
	 * 通过姓名查找
	 */
	private static void findStuByName() {
		System.out.println("请输入要查询的姓名：");
		Scanner scan=new Scanner(System.in);
		String name=scan.nextLine();
		System.out.println("编号"+"\t姓名"+"\t性别"+"\t年龄"+"\t电话号码");
		Set<String> keySet = stuMap.keySet();
		Iterator<String> it = keySet.iterator();
		  while (it.hasNext()) {
		   String key = it.next();
		   Students value = stuMap.get(key);
		   if(value.getName().equals(name)){
			   System.out.println(value);
		   }
		  }
		   
		}
	
	/*
	 * 通过ID查找
	 */
	private static void findStuById() {
		System.out.println("请输入要查询的编号：");
		Scanner scan=new Scanner(System.in);
		String id=scan.nextLine();
		System.out.println("编号"+"\t姓名"+"\t性别"+"\t年龄"+"\t电话号码");
		System.out.println(stuMap.get(id));
		
	}


	/**
	 *显示所有学生 
	 */
	private static void showStu() {
		Iterator it=stuMap.values().iterator();
		if (!it.hasNext()) {
            System.out.println("数据库为空");
        }
		System.out.println("编号"+"\t姓名"+"\t性别"+"\t年龄"+"\t电话号码");
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
        welcome();
    }
	
	
	/**
	 * 添加学生
	 */
	private static void addStu() {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("请输入编号：");
		String id=scan.nextLine();
		Students st=stuMap.get(id);
		if(st==null){
			System.out.print("姓名：");
			String name=scan.nextLine();
		
			System.out.print("性别：");
			String sex=scan.nextLine();
			
			System.out.print("年龄：");
			int age=scan.nextInt();
			
			System.out.print("电话：");
			String phonenum=scan.next();//???用nextInt()便出错，问题还未明白
			
			Students student=new Students(id,name,sex,age,phonenum);
		    stuMap.put(student.getId(), student);
		    System.out.println("成功添加学生："+stuMap.get(id).getName());
		}else{
			System.out.println("该学生ID已被占用,请重新输入！");
			addStu();
		}
		System.out.println("是否继续添加？（y/n)");
		String c=scan.next();
		if(c.equals("y")){
			addStu();
		}else{
			welcome();
		}
		
		}
		
		
	

}
