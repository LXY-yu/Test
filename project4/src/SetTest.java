import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SetTest {
	public List<Course>coursesToSelect;//List
	
	public Student student;
	
	public SetTest(){
		coursesToSelect=new ArrayList<Course>();
		
	}
	
	public void testAdd(){//���õ�List��ӿ�ѡ�Ŀγ�
		Course cr1=new Course("1","���ݽṹ");
		coursesToSelect.add(cr1);//0->cr1   List.add()��������List�����Ԫ��
		Course temp=(Course) coursesToSelect.get(0);//����0λ�õ�Ԫ��
		//System.out.println("����˿γ̣�"+temp.id+":"+temp.name);
		
		Course cr2=new Course("2","C����");
		coursesToSelect.add(0,cr2);//0->cr2,1->cr1
		Course temp2=(Course) coursesToSelect.get(0);
		//System.out.println("����˿γ̣�"+temp2.id+":"+temp2.name);
		
		Course cr3=new Course("3","test");
		coursesToSelect.add(2,cr3);//2->cr3,0->cr2,1->cr1
		Course temp3=(Course) coursesToSelect.get(2);
		//System.out.println("����˿γ̣�"+temp3.id+":"+temp3.name);
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
		//System.out.println("��������ſγ̣�"+temp4.id+":"+temp4.name+";"+temp5.id+":"+temp5.name);
		
		Course[]course2={new Course("6","�ߵ���ѧ"),new Course("7","��ѧӢ��")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp6=(Course) coursesToSelect.get(2);
		Course temp7=(Course) coursesToSelect.get(3);
		//System.out.println("��������ſγ̣�"+temp6.id+":"+temp6.name+";"+temp7.id+":"+temp7.name);

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
	
	/**
	 * ����List��contains����,�ж��Ƿ����ĳ��Ԫ��
	 * List.contains(...)  ����true����false
	 * @param args
	 */
	public void testListContains(){
		//ȡ�ñ�ѡ�γ������еĵ����Ԫ��
		Course course=coursesToSelect.get(0);
		//��ӡ���courseToSelect�Ƿ����course����
		System.out.println("ȡ�ÿγ̣�"+course.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�"+course.name+","+coursesToSelect.contains(course));
		//����һ���¶���ID��������course������ȫһ��
		Course course2=new Course(course.id,course.name);
		System.out.println("ȡ�ÿγ̣�"+course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�"+course2.name+","+coursesToSelect.contains(course2));
		//ͨ��indexOf()����ȡ��ĳԪ�ص�����λ��
		if(coursesToSelect.contains(course2))
			System.out.println("�γ̣�"+course2.name+"������λ��Ϊ��"+coursesToSelect.indexOf(course2));
	}
	
	/**
	 * ����Set��contains����,�ж��Ƿ����ĳ��Ԫ��
	 * @param args
	 */
	public void testSetContains(){
		//��ʾ����γ�����
		System.out.println("������ѧ����ѡ�Ŀγ����ƣ�");
		Scanner scan=new Scanner(System.in);
		String name=scan.next();
		//����һ���¶���ID��������course������ȫһ��
	    Course course2=new Course();
	    course2.name=name;
	    System.out.println("ȡ�ÿγ̣�"+course2.name);
		System.out.println("��ѡ�γ����Ƿ�����γ̣�"+course2.name+","+student.courses.contains(course2));//��ϣ����
	}
	
	//����ѧ������ѡ��
	public void creatStudentAndSelectCourse(){
		//����һ��ѧ������
		student=new Student("1","С��");
				System.out.println("��ӭѧ��"+student.name+"ѡ�Σ�");
				//����һ��Scanner�����������մӼ�������Ŀγ�ID
				Scanner scan=new Scanner(System.in);
				for(int i=0;i<3;i++){
					System.out.println("������γ�ID");
					String courseId=scan.next();
					for(Course cr:coursesToSelect){
						if(cr.id.equals(courseId)){
							student.courses.add(cr);
						}
					}
				}
				//��ӡ���ѧ����ѡ�Ŀγ�
				for(Course cr:student.courses){
					System.out.println("ѡ���˿γ̣�"+cr.id+":"+cr.name);
				}
				
		
	}

	public static void main(String[] args) {
		SetTest st=new SetTest();
		
		st.testAdd();
		
		st.testListContains();//ȡ�ÿγ̣�C����
                              // ��ѡ�γ����Ƿ�����γ̣�C����,true
		                      //ȡ�ÿγ̣�C����
		                      //��ѡ�γ����Ƿ�����γ̣�C����,false
		                      //���Է�������½�һ���γ̶��󣬼�ʹ��List��ԭ����һ������һģһ����Ҳ�᷵��false,
		                      //������Course����д��equals������Ȼ��ͷ�����true
		                      //ȡ�ÿγ̣�C����
		                      //��ѡ�γ����Ƿ�����γ̣�C����,true
		                      //ȡ�ÿγ̣�C����
		                      //��ѡ�γ����Ƿ�����γ̣�C����,true
		st.testForEach();
		
		st.creatStudentAndSelectCourse();
		
		st.testSetContains();
		
	}

}
