import java.io.*;
/*import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;*/
import java.util.Iterator;
import java.util.TreeMap;
 
/*import com.linguofeng.dao.StudentDao;
import com.linguofeng.model.Student;*/
public class StudentDaoImpl implements StudentDao{
	private static final String file = "student.dat"; 
    /**
     * ���ѧ��
     */
    @Override
    public void addStu(TreeMap<String, Student> stuMap) {
        /** ��ԭ��������Ҳ����ȥ */
        Iterator<Student> iterator = findAll().values().iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            stuMap.put(student.getNum(), student);
        }
 
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            Iterator<Student> it = stuMap.values().iterator();
            while (it.hasNext()) {
                out.writeObject(it.next());
            }
            out.writeObject(null);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * ��������ѧ������
     */
    @Override
    public TreeMap<String, Student> findAll() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        TreeMap<String, Student> stuMap = null;
        try {
            fis = new FileInputStream(file);
            in = new ObjectInputStream(fis);
            Student student = null;
            stuMap = new TreeMap<String, Student>();
            while ((student = (Student) (in.readObject())) != null) {
                stuMap.put(student.getNum(), student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return stuMap;
    }
    /**
     * ɾ������ѧ������
     */
    @Override
    public void delAll() {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            out.writeObject(null);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    /**
     * ����ѧ������
     */
    @Override
    public void updateStu(TreeMap<String, Student> stuMap) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(file);
            out = new ObjectOutputStream(fos);
            Iterator<Student> it = stuMap.values().iterator();
            while (it.hasNext()) {
                out.writeObject(it.next());
            }
            out.writeObject(null);
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
 
    @Override
    public boolean delByNum(String num) {
        boolean flag = false;
        TreeMap<String, Student> stuMap = findAll();
        if (stuMap.remove(num) != null) {
            updateStu(stuMap);
            flag = true;
        }
        return flag;
    }
 
    @Override
    public Student findByNum(String num) {
        return findAll().get(num);
    }
 
    @Override
    public void updateByNum(String num, Student student) {
        TreeMap<String, Student> stuMap = findAll();
        stuMap.get(num).setId(student.getId());
        stuMap.get(num).setName(student.getName());
        stuMap.get(num).setNum(student.getNum());
        stuMap.get(num).setSex(student.getSex());
        updateStu(stuMap);
    }

}
