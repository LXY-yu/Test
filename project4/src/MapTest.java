import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class MapTest {
	/**
	 * �����н�ѧ�����Ͷ���
	 * @param args
	 */
	public Map<String,Student>students;
	//���Ͽ�ܷ�ΪCollection��Map��Collection��ΪList��Queue��Set
	//Map<key,value> Map<String,Student>students:˵��students��һ��Map���ͣ�
	//��keyΪString���ͣ�valueΪStudent����
	
	/**
	 * �ڹ������г�ʼ��students����
	 * @param args
	 */
	public MapTest(){
		this.students=new HashMap<String,Student>();
	}
	
	/**
	 * ������ӣ�����ѧ��ID���ж��Ƿ�ռ��
	 * ��δ��ռ�ã�����������������ѧ�����󣬲�����ӵ�students��
	 * @param args
	 */
	public void testPut(){
		Scanner scan=new Scanner(System.in);
		int i=0;
		while(i<3){
			System.out.println("������ѧ��ID��");
			String ID=scan.next();
			//�ж�ID�Ƿ�ռ��
			Student st=students.get(ID);
			if(st==null){
				//��ʾ����ѧ������
				System.out.println("������ѧ��������");
				String name=scan.next();
				//�����µ�ѧ������
				Student newStudent=new Student(ID,name);
				//ͨ������student��put���������ID-ѧ��ӳ��
				students.put(ID, newStudent);
				System.out.println("�ɹ����ѧ����"+students.get(ID).name);
				i++;	
			}else{
				System.out.println("��ѧ��ID�ѱ�ռ�ã�");
				continue;
			}
		}
	}
	
	/**
	 * ����Map��keySet����
	 * @param args
	 */
	public void testKeySet(){
		//ͨ��keySet����������Map�����еġ�������Set����
		Set<String>KeySet=students.keySet();
		//ȡ��students������
		System.out.println("�ܹ��У�"+students.size()+"��ѧ����");
		//����keySet,ȡ��ÿһ�������ڵ���get����ȡ��ÿ������Ӧ��value
		for(String stuId:KeySet){
			Student st=students.get(stuId);
			if(st!=null)
				System.out.println("ѧ����"+st.name);
			}
	}
	
	/**
	 * ����ɾ��Map�е�ӳ��
	 * @param args
	 */
	public void testRemove(){
		Scanner scan=new Scanner(System.in);
		while(true){
			//��ʾ�����ɾ����ѧ����ID
			System.out.println("������Ҫɾ����ѧ����ID");
			String ID=scan.next();
			//�жϸ�ѧ��ID�Ƿ��ж�Ӧ��ѧ������
			Student st=students.get(ID);
			if(st==null){
				System.out.println("��ID������");
				continue;
			}
			students.remove(ID);
			System.out.println("�ɹ�ɾ��ѧ����"+st.name);
			break;
		}
	}
	
	/**
	 * ͨ��entrySet����������Map
	 * @param args
	 */
	public void testEntrySet(){
		//ͨ��entrySet����������Map�����еļ�ֵ��
		Set<Entry<String,Student>>entrySet=students.entrySet();
		for(Entry<String,Student>entry:entrySet){
			System.out.println("ȡ�ü���"+entry.getKey());
			System.out.println("��Ӧ��ֵΪ��"+entry.getValue().name);
		}
	}
	
	/**
	 * ����put�����޸�Map�����е�ӳ��
	 * @param args
	 */
	public void testModify(){
		//��ʾ����Ҫ�޸ĵ�ѧ��ID
		System.out.println("������Ҫ�޸ĵ�ѧ��ID��");
		Scanner scan=new Scanner(System.in);
		while(true){
			String stuID=scan.next();
			//��students�в��Ҹ�ѧ��ID��Ӧ��ѧ������
			Student student=students.get(stuID);
			if(student==null){
				System.out.println("��ID�����ڣ����������룡");
				continue;
			}
			//��ʾ��ǰ��Ӧ��ѧ�����������
			System.out.println("��ǰ��ѧ��ID����Ӧ��ѧ��Ϊ��"+student.name);
			System.out.println("�������µ�ѧ��������");
			String name=scan.next();
			Student newStudent=new Student(stuID,name);
			students.put(stuID, newStudent);
			System.out.println("�޸ĳɹ���");
			break;
		}
	}
	
	/**
	 * ����Map���Ƿ����ĳ��Keyֵ����ĳ��valueֵ
	 * @param args
	 */
	public void testContainsKeyOrValue(){
		System.out.println("������Ҫ��ѯ��ѧ��ID��");
		Scanner scan=new Scanner(System.in);
		String id=scan.next();
		//��Map�У���containsKey()���������ж��Ƿ����ĳ��keyֵ
		System.out.println("�������ѧ��IDΪ��"+id+",��ѧ��ӳ������Ƿ���ڣ�"+students.containsKey(id));
		if(students.containsKey(id))
			System.out.println("��Ӧ��ѧ��Ϊ��"+students.get(id).name);
		System.out.println("������Ҫ��ѯѧ��������");
		String name=scan.next();
		//��containsValue()�������ж��Ƿ����ĳ��valueֵ
		if(students.containsValue(new Student(null,name)))
			System.out.println("��ѧ��ӳ����У�����ѧ����"+name);
		else
			System.out.println("��ѧ��ӳ����в����ڸ�ѧ����");
		
		
		
	}

	public static void main(String[] args) {
		MapTest mt=new MapTest();
		mt.testPut();
		mt.testKeySet();
		//mt.testRemove();
		//mt.testEntrySet();
		//mt.testModify();
		//mt.testEntrySet();
		mt.testContainsKeyOrValue();

	}

}
