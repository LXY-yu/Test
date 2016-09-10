import java.util.TreeMap;
 
//import com.linguofeng.model.Student;
public interface StudentDao {
	/**
     * ���ѧ������
     * 
     * @param stuMap
     *            ѧ�����󼯺�
     */
    public void addStu(TreeMap<String, Student> stuMap);
    /**
     * ����ѧ������
     * 
     * @param stuMap
     *            �µ�ѧ�����󼯺�
     */
    public void updateStu(TreeMap<String, Student> stuMap);
    /**
     * ��������ѧ������
     * 
     * @return ����ѧ�����󼯺�
     */
    public TreeMap<String, Student> findAll();
    /**
     * ɾ������ѧ������
     */
    public void delAll();
    /**
     * ����ѧ��ѧ��ɾ��ѧ������
     * 
     * @param num
     */
    public boolean delByNum(String num);
    /**
     * ����ѧ��ѧ�Ų�ѯѧ��������Ϣ
     * 
     * @param num
     * @return
     */
    public Student findByNum(String num);
     
    public void updateByNum(String num,Student student);

}
