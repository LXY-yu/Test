import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
//备选课程类
public class ListTest {
	//用于存放备选课程的List,List是集合框架Collection中的一种,
	//集合框架分为Collection和Map，Collection分为List、Queue、Set
	//List是有序的且元素可重复，而Set是无序的且元素不可重复
	public List coursesToSelect;
	public ListTest(){
		this.coursesToSelect=new ArrayList();
	}
	
	/*
	 * 添加元素
	 */
	public void testAdd(){
		Course cr1=new Course("1","数据结构");
		coursesToSelect.add(cr1);//0->cr1   List.add()方法是往List中添加元素
		Course temp=(Course) coursesToSelect.get(0);//返回0位置的元素
		System.out.println("添加了课程："+temp.id+":"+temp.name);
		
		Course cr2=new Course("2","C语言");
		coursesToSelect.add(0,cr2);//0->cr2,1->cr1
		Course temp2=(Course) coursesToSelect.get(0);
		System.out.println("添加了课程："+temp2.id+":"+temp2.name);
		
		Course cr3=new Course("3","test");
		coursesToSelect.add(2,cr3);//2->cr3,0->cr2,1->cr1
		Course temp3=(Course) coursesToSelect.get(2);
		System.out.println("添加了课程："+temp3.id+":"+temp3.name);
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
		System.out.println("添加了两门课程："+temp4.id+":"+temp4.name+";"+temp5.id+":"+temp5.name);
		
		Course[]course2={new Course("6","高等数学"),new Course("7","大学英语")};
		coursesToSelect.addAll(2,Arrays.asList(course2));
		Course temp6=(Course) coursesToSelect.get(2);
		Course temp7=(Course) coursesToSelect.get(3);
		System.out.println("添加了两门课程："+temp6.id+":"+temp6.name+";"+temp7.id+":"+temp7.name);

		}
	
	/*
	 *取得List中的元素的方法
	 *int size=List.size();
	 */	
	public void testGet(){
			int size=coursesToSelect.size();
			System.out.println("有如下课程待选：");
			for(int i=0;i<size;i++){
				Course cr=(Course) coursesToSelect.get(i);
				System.out.println("课程:"+cr.id+":"+cr.name);
			}
	}
	
	/*
	 * 通过迭代器来遍历List  Iterator it=List.iterator();
	 * while(it.hasNext()){....}
	 */
	public void testIterator(){
		Iterator it=coursesToSelect.iterator();
		System.out.println("有如下课程待选（通过迭代器访问）：");
		while(it.hasNext()){
			Course cr=(Course) it.next();
			System.out.println("课程："+cr.id+":"+cr.name);
		}
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
	/*
	 * 修改List中的元素     List.set(...)方法是修改
	 *
	 */
	public void testModefy(){
		coursesToSelect.set(4, new Course("7","毛概"));
	}
	/*
	 * 删除List中的元素
	 * 
	 */
	public void testRemove(){
		Course cr=(Course)coursesToSelect.get(4);
		System.out.println("我是课程："+cr.id+":"+cr.name+"  我即将被删除");
		coursesToSelect.remove(cr);
		System.out.println("成功删除课程！");
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
