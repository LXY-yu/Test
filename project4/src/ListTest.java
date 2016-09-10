import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//��ѡ�γ���
public class ListTest {
	//���ڴ�ű�ѡ�γ̵�List,List�Ǽ��Ͽ��Collection�е�һ��,
	//���Ͽ�ܷ�ΪCollection��Map��Collection��ΪList��Queue��Set
	//List���������Ԫ�ؿ��ظ�����Set���������Ԫ�ز����ظ�
	public List coursesToSelect;
	public ListTest(){
		this.coursesToSelect=new ArrayList();
	}
	
	/*
	 * ���Ԫ��
	 */
	public void testAdd(){
		Course cr1=new Course("1","���ݽṹ");
		coursesToSelect.add(cr1);//0->cr1   List.add()��������List�����Ԫ��
		Course temp=(Course) coursesToSelect.get(0);//����0λ�õ�Ԫ��
		System.out.println("����˿γ̣�"+temp.id+":"+temp.name);
		
		Course cr2=new Course("2","C����");
		coursesToSelect.add(0,cr2);//0->cr2,1->cr1
		Course temp2=(Course) coursesToSelect.get(0);
		System.out.println("����˿γ̣�"+temp2.id+":"+temp2.name);
		
		Course cr3=new Course("3","test");
		coursesToSelect.add(2,cr3);//2->cr3,0->cr2,1->cr1
		Course temp3=(Course) coursesToSelect.get(2);
		System.out.println("����˿γ̣�"+temp3.id+":"+temp3.name);
		/*
		 * List.add(������)��������List�����Ԫ�صķ���֮һ
		 * �����ӵ�λ�ó������ȣ�����׳��쳣
		 * ���磺coursesToSelect.add(4,cr4);
		 */
		
		//List.addAll(������)����List�����Ԫ�ص���һ�ַ���
		Course[] course={new Course("4","��ɢ��ѧ"),new Course("5","�������")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp4=(Course) coursesToSelect.get(3);
		Course temp5=(Course) coursesToSelect.get(4);
		System.out.println("��������ſγ̣�"+temp4.id+":"+temp4.name+";"+temp5.id+":"+temp5.name);
		
		Course[]course2={new Course("6","�ߵ���ѧ"),new Course("7","��ѧӢ��")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp6=(Course) coursesToSelect.get(2);
		Course temp7=(Course) coursesToSelect.get(3);
		System.out.println("��������ſγ̣�"+temp6.id+":"+temp6.name+";"+temp7.id+":"+temp7.name);

		}
	
	/*
	 *ȡ��List�е�Ԫ�صķ���
	 *int size=List.size();
	 */	
	public void testGet(){
			int size=coursesToSelect.size();
			System.out.println("�����¿γ̴�ѡ��");
			for(int i=0;i<size;i++){
				Course cr=(Course) coursesToSelect.get(i);
				System.out.println("�γ�:"+cr.id+":"+cr.name);
			}
	}
	
	/*
	 * ͨ��������������List  Iterator it=List.iterator();
	 * while(it.hasNext()){....}
	 */
	public void testIterator(){
		Iterator it=coursesToSelect.iterator();
		System.out.println("�����¿γ̴�ѡ��ͨ�����������ʣ���");
		while(it.hasNext()){
			Course cr=(Course) it.next();
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
		}
	}
	
	/**
	 * ͨ��for each�������ʼ���Ԫ��
	 */
	public void testForEach(){
		System.out.println("�����¿γ̴�ѡ��ͨ��for each ���ʣ���");
		for(Object obj:coursesToSelect){
			Course cr=(Course)obj;
			System.out.println("�γ̣�"+cr.id+":"+cr.name);
			
		}
	}
	/*
	 * �޸�List�е�Ԫ��     List.set(...)�������޸�
	 *
	 */
	public void testModefy(){
		coursesToSelect.set(4, new Course("7","ë��"));
	}
	/*
	 * ɾ��List�е�Ԫ��
	 * 
	 */
	public void testRemove(){
		Course cr=(Course)coursesToSelect.get(4);
		System.out.println("���ǿγ̣�"+cr.id+":"+cr.name+"  �Ҽ�����ɾ��");
		coursesToSelect.remove(cr);
		System.out.println("�ɹ�ɾ���γ̣�");
		testIterator();
	}
	
	public static void main(String[] args){
		ListTest lt=new ListTest();
		lt.testAdd();
		lt.testGet();
		lt.testIterator();
		lt.testForEach();
		lt.testModefy();
		lt.testIterator();
		lt.testRemove();
	}

}
