import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student>{//�̳�Comparable�ӿڣ����ڶ�ѧ����������
	public String id;
	public String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	public Set<Course> courses;//ͨ��Set����ӿγ̣�Set��Collection��һ�֣�List�������ҿ��ظ��ģ���Set���������Ԫ�ز����ص�
	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.courses=new HashSet<Course>();
	}
	
	@Override
	public int compareTo(Student o) {
		return this.id.compareTo(o.id);//IDΪString���͵ģ����Կ���ֱ����compareTo()��������
	}

}
