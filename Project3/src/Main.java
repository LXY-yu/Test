
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static Map<String, Students> stuMap = new HashMap<String, Students>();
	
	public static void welcome(){
		System.out.println("��ӭʹ��ѧԱͨѶ¼����ϵͳ");
		System.out.println("  �����ˣ�Ѷ�ڿƼ�");
		System.out.println();
		System.out.println("1.��¼    2.ע��    3.�һ�����      0.ע��");
		System.out.print("��ѡ��");
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		switch(a){
		case 1:
			denglu();
			break;
		case 2:case 3:case 0:
			System.out.println("���ڿ�����");
			break;
		default:
			System.out.println("���벻�Ϲ淶");
			break;
			
		}
	}


	public static void main(String[] args) {
		
		
		Main.welcome();
		

	}

	private static void denglu() {
		Scanner scan=new Scanner(System.in);
		System.out.println();
		System.out.print("�������˺�:");
		String s1=scan.nextLine();
		System.out.print("����������:");
		String s2=scan.nextLine();
		System.out.println("      1.���ѧԱ");
		System.out.println("      2.��ʾ����ѧԱ");
		System.out.println("      3.����ѧԱ");
		System.out.println("      4.�޸�ѧԱ");
		System.out.println("      5.ɾ��ѧԱ");
		System.out.println("      0.�˳�");
		System.out.print("��ѡ��:");
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
			System.out.println("===   ��ӭ�´�ʹ��      ===");
			System.out.println("===================");
			break;
		default:
			System.out.println("���벻�Ϲ淶");
			break;
		}
		
		
		
	}
	
	/**
	 * ɾ��ѧԱ
	 */
	private static void deleteStu() {
		System.out.println("������Ҫɾ����ѧԱ��ţ�");
		Scanner scan=new Scanner(System.in);
		String id=scan.nextLine();
		//stuMap.remove(stuMap.get(id));
		Students st=stuMap.get(id);
		if(st==null){
			System.out.println("��ID������,���������룡");
			deleteStu();
		}else{
			stuMap.remove(id);
			System.out.println("�ɹ�ɾ��ѧ����"+st.getName());
		}
		welcome();
	}
	
	/**
	 * �޸�ѧԱ
	 */
	private static void modifyStu() {
		System.out.println("������Ҫ�޸ĵ�ѧԱ��ţ�");
		Scanner scan=new Scanner(System.in);
		String d=scan.nextLine();
		Students st=stuMap.get(d);
		if(st!=null){
			System.out.println("���");
			String id=scan.nextLine();
			System.out.print("������");
			String name=scan.nextLine();
		
			System.out.print("�Ա�");
			String sex=scan.nextLine();
			
			System.out.print("���䣺");
			int age=scan.nextInt();
			
			System.out.print("�绰��");
			String phonenum=scan.next();
			
			st.setId(id);
			st.setName(name);
			st.setSex(sex);
			st.setAge(age);
			st.setPhonenum(phonenum);
			System.out.println("ѧԱ��Ϣ�޸ĳɹ���");
		    System.out.println(st.getId()+"\t"+st.getName()+"\t"+st.getSex()+"\t"+st.getAge()+"\t"+st.getPhonenum());
		}else{
			System.out.println("�����ڸ�ѧ��,���������룡");
			modifyStu();
		}
		welcome();
		
		
	}
	
	/**
	 * ��ѯѧ��
	 */
	private static void findStu() {
		System.out.println("1.����Ų���");
		System.out.println("2.����������");
		System.out.println("3.���绰����");
		System.out.println("4.���������");
		System.out.print("�����루1-4��ѡ���ѯ��ʽ:");
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
			System.out.println("���벻�Ϲ淶");
			break;
		}
		welcome();

	}
	
	/**
	 * ��ѯѧ��
	 */
	
	/*
	 * ͨ���������
	 */
	private static void findStuByAge() {
		System.out.println("������Ҫ��ѯ�����䣺");
		Scanner scan=new Scanner(System.in);
		int age=scan.nextInt();
		System.out.println("���"+"\t����"+"\t�Ա�"+"\t����"+"\t�绰����");
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
	 * ͨ���绰����
	 */
	private static void findStuByphonenum() {
		System.out.println("������Ҫ��ѯ�ĵ绰��");
		Scanner scan=new Scanner(System.in);
		String phonenum=scan.nextLine();
		System.out.println("���"+"\t����"+"\t�Ա�"+"\t����"+"\t�绰����");
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
	 * ͨ����������
	 */
	private static void findStuByName() {
		System.out.println("������Ҫ��ѯ��������");
		Scanner scan=new Scanner(System.in);
		String name=scan.nextLine();
		System.out.println("���"+"\t����"+"\t�Ա�"+"\t����"+"\t�绰����");
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
	 * ͨ��ID����
	 */
	private static void findStuById() {
		System.out.println("������Ҫ��ѯ�ı�ţ�");
		Scanner scan=new Scanner(System.in);
		String id=scan.nextLine();
		System.out.println("���"+"\t����"+"\t�Ա�"+"\t����"+"\t�绰����");
		System.out.println(stuMap.get(id));
		
	}


	/**
	 *��ʾ����ѧ�� 
	 */
	private static void showStu() {
		Iterator it=stuMap.values().iterator();
		if (!it.hasNext()) {
            System.out.println("���ݿ�Ϊ��");
        }
		System.out.println("���"+"\t����"+"\t�Ա�"+"\t����"+"\t�绰����");
        while (it.hasNext()) {
        	System.out.println(it.next());
        }
        welcome();
    }
	
	
	/**
	 * ���ѧ��
	 */
	private static void addStu() {
		
		Scanner scan=new Scanner(System.in);
		System.out.print("�������ţ�");
		String id=scan.nextLine();
		Students st=stuMap.get(id);
		if(st==null){
			System.out.print("������");
			String name=scan.nextLine();
		
			System.out.print("�Ա�");
			String sex=scan.nextLine();
			
			System.out.print("���䣺");
			int age=scan.nextInt();
			
			System.out.print("�绰��");
			String phonenum=scan.next();//???��nextInt()��������⻹δ����
			
			Students student=new Students(id,name,sex,age,phonenum);
		    stuMap.put(student.getId(), student);
		    System.out.println("�ɹ����ѧ����"+stuMap.get(id).getName());
		}else{
			System.out.println("��ѧ��ID�ѱ�ռ��,���������룡");
			addStu();
		}
		System.out.println("�Ƿ������ӣ���y/n)");
		String c=scan.next();
		if(c.equals("y")){
			addStu();
		}else{
			welcome();
		}
		
		}
		
		
	

}
