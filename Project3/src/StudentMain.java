
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeMap;
 
/*import com.linguofeng.dao.StudentDao;
import com.linguofeng.dao.impl.StudentDaoImpl;
import com.linguofeng.model.Student;*/
public class StudentMain {
	static StudentDao dao;
    static BufferedReader br;
    public static void main(String[] args) {
        /** ����ʱ�ж������ļ��Ƿ����,�粻�������½�. */
        File file = new File("student.dat");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
 
        dao = new StudentDaoImpl();
 
        /** ��ÿ���̨������ */
        br = new BufferedReader(new InputStreamReader(System.in));
 
        /** ������ѭ�� */
        while (true) {
            System.out.println(getLine());
            System.out.println("=[0]���˵�\t\t\t\t\t\t=");
            System.out.println("=[1]����ѧ��\t\t\t\t\t\t=");
            System.out.println("=[2]����ѧ��\t\t\t\t\t\t=");
            System.out.println("=[3]ɾ��һ��ѧ��\t\t\t\t\t=");
            System.out.println("=[4]ɾ������ѧ��\t\t\t\t\t=");
            System.out.println("=[5]ѧ���б�\t\t\t\t\t\t=");
            System.out.println("=[6]����ѧ��\t\t\t\t\t\t=");
            System.out.println("=[x]�˳�\t\t\t\t\t\t=");
            System.out.println(getLine());
            System.out.print("��ѡ�����:");
 
            /** ��ÿ���̨��������� */
            String input = getInput();
            if (input.equals("")) {
                input = "x";
            }
            switch (input.charAt(0)) {
                case '2' :
                    addStu();
                    break;
                case 'x' :
                    System.out.println("�˳��ɹ�,��ӭ�ٴ�ʹ��!");
                    System.exit(0);
                    break;
                case '5' :
                    findAll();
                    break;
                case '4' :
                    delAll();
                    break;
                case '3' :
                    delByNum();
                    break;
                case '1' :
                    findByNum();
                    break;
                case '6' :
                    updateByNum();
                    break;
                default :
                    System.out.println("��֧�ֵ�ϵͳָ��,����������!");
                    break;
            }
        }
    }
 
    /**
     * ����ѧ��ѧ�Ų�ѯѧ��������Ϣ
     */
    public static void findByNum() {
        System.out.print("������Ҫ��ѯ��ѧ��ѧ��:");
        while (true) {
            String input = getInput();
            if (dao.findByNum(input) != null) {
                System.out.println(dao.findByNum(input));
                return;
            } else if (input.equals("")) {
                return;
            } else {
                System.out.print("��ѯʧ��,�����ڸ�ѧ��,����������Ҫɾ����ѧ��ѧ��:");
            }
        }
    }
 
    /**
     * ����ѧ��ѧ��ɾ��ѧ������
     */
    public static void delByNum() {
        System.out.println(getLine());
        findAll();/** ��ʾ����ѧ����Ϣ�������ɾ������ */
        System.out.println(getLine());
        System.out.println("����ȡ������ֱ�Ӱ��س�.");
        System.out.print("������Ҫɾ����ѧ��ѧ��:");
        while (true) {
            String input = getInput();
            if (dao.delByNum(input)) {
                System.out.println("ɾ���ɹ�!");
                findAll();
                return;
            } else if (input.equals("")) {
                return;
            } else {
                System.out.print("ɾ��ʧ��,�����ڸ�ѧ��,����������Ҫɾ����ѧ��ѧ��:");
            }
        }
    }
    /**
     * ѧ���б�
     */
    public static void findAll() {
        TreeMap<String, Student> stuMap = dao.findAll();
        Iterator<Student> iterator = stuMap.values().iterator();
        if (!iterator.hasNext()) {
            System.out.println("���ݿ�Ϊ��");
        }
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
 
    /**
     * ɾ������ѧ������
     */
    public static void delAll() {
        while (true) {
            System.out.print("�Ƿ�Ҫɾ������ѧ����Ϣ,ȷ��������YES,��������NO��");
            String input = getInput();
            if (input.equals("YES") || input.equals("yes")) {
                dao.delAll();
                System.out.println("��ճɹ�");
                return;
            } else if (input.equals("NO") || input.equals("no")) {
                return;
            } else {
                System.out.println("��������,����������!");
            }
        }
    }
 
    /**
     * ���ѧ��
     */
    public static void addStu() {
        while (true) {
            System.out.print("������Ҫ���ѧ���ĸ���:");
            String ch = null;
            try {
                ch = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (ch.equals("")) {
                System.out.println("��������,����������!");
            } else {
                int size = Integer.parseInt(ch);
                TreeMap<String, Student> stuMap = new TreeMap<String, Student>();
                for (int i = 0; i < size; i++) {
                    Student student = new Student();
                    try {
                        System.out.print("������� " + (i + 1) + " ��ѧ��������:");
                        student.setName(br.readLine());
                        System.out.print("������� " + (i + 1) + " ��ѧ����ѧ��:");
                        student.setNum(br.readLine());
                        System.out.print("������� " + (i + 1)
                                + " ��ѧ�����Ա�(����:1;Ů��:0):");
                        student.setSex(Integer.parseInt(br.readLine()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    stuMap.put(student.getNum(), student);
                }
                dao.addStu(stuMap);
                findAll();
                return;
            }
        }
    }
 
    public static void updateByNum() {
        findAll();
        System.out.print("������Ҫ�޸ĵ�ѧ��ѧ��:");
        while (true) {
            String input = getInput();
            String num = input;
            Student student = dao.findByNum(num);
            if (student != null) {
                System.out.println(student);
                System.out.println("�粻�޸�ֱ�����հ��س�!");
                System.out.print("������ѧ����������:");
                input = getInput();
                if (!input.equals(""))
                    student.setName(input);
                System.out.print("������ѧ������ѧ��:");
                input = getInput();
                if (!input.equals(""))
                    student.setNum(input);
                System.out.print("������ѧ�����°��Ա�(����:1;Ů��:0):");
                input = getInput();
                if (!input.equals(""))
                    student.setSex(Integer.parseInt(input));
                dao.updateByNum(num, student);
                System.out.println("���³ɹ�,���º������:");
                System.out.println(dao.findByNum(student.getNum()));
                return;
            } else if (input.equals("")) {
                return;
            } else {
                System.out.print("��ѯʧ��,�����ڸ�ѧ��,����������Ҫ�޸ĵ�ѧ��ѧ��:");
            }
        }
    }
 
    public static void addTest() {
        TreeMap<String, Student> stuMap = new TreeMap<String, Student>();
        for (int i = 0; i < 10000; i++) {
            Student student = new Student(i, "A" + i, "NUM" + i, 0);
            stuMap.put(student.getNum(), student);
        }
        dao.addStu(stuMap);
        return;
    }
 
    /**
     * ���===========�ָ��
     * 
     * @return
     */
    public static String getLine() {
        return "=========================================================";
    }
 
    /**
     * ��ÿ���̨����
     * 
     * @return
     */
    public static String getInput() {
        String ch = "";
        try {
            ch = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ch;
    }

}
