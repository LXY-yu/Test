import java.util.HashSet;
import java.util.Set;

public class Student implements Comparable<Student>{//继承Comparable接口，用于对学生进行排序
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
	public Set<Course> courses;//通过Set来添加课程，Set是Collection的一种，List是有序且可重复的，而Set是无序的且元素不可重叠
	public Student(String id,String name){
		this.id=id;
		this.name=name;
		this.courses=new HashSet<Course>();
	}
	
	@Override
	public int compareTo(Student o) {
		return this.id.compareTo(o.id);//ID为String类型的，所以可以直接用compareTo()进行排序
	}

}
