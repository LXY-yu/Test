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
	
	public void testAdd(){//采用的List添加可选的课程
		Course cr1=new Course("1","数据结构");
		coursesToSelect.add(cr1);//0->cr1   List.add()方法是往List中添加元素
		Course temp=(Course) coursesToSelect.get(0);//返回0位置的元素
		//System.out.println("添加了课程："+temp.id+":"+temp.name);
		
		Course cr2=new Course("2","C语言");
		coursesToSelect.add(0,cr2);//0->cr2,1->cr1
		Course temp2=(Course) coursesToSelect.get(0);
		//System.out.println("添加了课程："+temp2.id+":"+temp2.name);
		
		Course cr3=new Course("3","test");
		coursesToSelect.add(2,cr3);//2->cr3,0->cr2,1->cr1
		Course temp3=(Course) coursesToSelect.get(2);
		//System.out.println("添加了课程："+temp3.id+":"+temp3.name);
		/*
		 * List.add(···)方法是往List中添加元素的方法之一
		 * 如果添加的位置超出长度，便会抛出异常
		 * 例如：coursesToSelect.add(4,cr4);
		 */
		
		//List.addAll(···)是往List中添加元素的另一种方法
		Course[] course={new Course("4","离散数学"),new Course("5","汇编语言")};
		coursesToSelect.addAll(Arrays.asList(course));
		Course temp4=(Course) coursesToSelect.get(3);
		Course temp5=(Course) coursesToSelect.get(4);
		//System.out.println("添加了两门课程："+temp4.id+":"+temp4.name+";"+temp5.id+":"+temp5.name);
		
		Course[]course2={new Course("6","高等数学"),new Course("7","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp6=(Course) coursesToSelect.get(2);
		Course temp7=(Course) coursesToSelect.get(3);
		//System.out.println("添加了两门课程："+temp6.id+":"+temp6.name+";"+temp7.id+":"+temp7.name);

		}
	
	/**
	 * 通过for each方法访问集合元素
	 */
	public void testForEach(){
		System.out.println("有如下课程待选（通过for each 访问）：");
		for(Object obj:coursesToSelect){
			Course cr=(Course)obj;
			System.out.println("课程："+cr.id+":"+cr.name);
			
		}
	}
	
	/**
	 * 测试List的contains方法,判断是否存在某个元素
	 * List.contains(...)  返回true或者false
	 * @param args
	 */
	public void testListContains(){
		//取得备选课程序列中的第零个元素
		Course course=coursesToSelect.get(0);
		//打印输出courseToSelect是否包含course对象
		System.out.println("取得课程："+course.name);
		System.out.println("备选课程中是否包含课程："+course.name+","+coursesToSelect.contains(course));
		//创建一个新对象，ID与名称与course对象完全一致
		Course course2=new Course(course.id,course.name);
		System.out.println("取得课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+coursesToSelect.contains(course2));
		//通过indexOf()方法取得某元素的索引位置
		if(coursesToSelect.contains(course2))
			System.out.println("课程："+course2.name+"的索引位置为："+coursesToSelect.indexOf(course2));
	}
	
	/**
	 * 测试Set的contains方法,判断是否存在某个元素
	 * @param args
	 */
	public void testSetContains(){
		//提示输入课程名称
		System.out.println("请输入学生已选的课程名称：");
		Scanner scan=new Scanner(System.in);
		String name=scan.next();
		//创建一个新对象，ID与名称与course对象完全一致
	    Course course2=new Course();
	    course2.name=name;
	    System.out.println("取得课程："+course2.name);
		System.out.println("备选课程中是否包含课程："+course2.name+","+student.courses.contains(course2));//哈希编码
	}
	
	//创建学生对象并选课
	public void creatStudentAndSelectCourse(){
		//创建一个学生对象
		student=new Student("1","小明");
				System.out.println("欢迎学生"+student.name+"选课！");
				//创建一个Scanner对象，用来接收从键盘输入的课程ID
				Scanner scan=new Scanner(System.in);
				for(int i=0;i<3;i++){
					System.out.println("请输入课程ID");
					String courseId=scan.next();
					for(Course cr:coursesToSelect){
						if(cr.id.equals(courseId)){
							student.courses.add(cr);
						}
					}
				}
				//打印输出学生所选的课程
				for(Course cr:student.courses){
					System.out.println("选择了课程："+cr.id+":"+cr.name);
				}
				
		
	}

	public static void main(String[] args) {
		SetTest st=new SetTest();
		
		st.testAdd();
		
		st.testListContains();//取得课程：C语言
                              // 备选课程中是否包含课程：C语言,true
		                      //取得课程：C语言
		                      //备选课程中是否包含课程：C语言,false
		                      //可以发现如果新建一个课程对象，即使与List里原本的一个对象一模一样，也会返回false,
		                      //于是在Course中重写了equals方法，然后就返回了true
		                      //取得课程：C语言
		                      //备选课程中是否包含课程：C语言,true
		                      //取得课程：C语言
		                      //备选课程中是否包含课程：C语言,true
		st.testForEach();
		
		st.creatStudentAndSelectCourse();
		
		st.testSetContains();
		
	}

}
