import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Sever {

	public static void main(String[] args) {
		try {
			//1.����һ����������Socket����SeverSocket��ָ���󶨵Ķ˿ڣ��������˶˿�
			ServerSocket serverSocket=new ServerSocket(8888);
			//2.����accept()������ʼ�������ȴ��ͻ��˵�����
			System.out.println("***�������������ã��ȴ��ͻ��˵�����***");
		    Socket socket=serverSocket.accept();
		    //3.��ȡ������������ȡ�ͻ�����Ϣ
		    InputStream is=socket.getInputStream();//�ֽ�������
			InputStreamReader isr=new InputStreamReader(is);//�ַ�������
			BufferedReader br=new BufferedReader(isr);//���ַ���������ӻ���
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("���Ƿ��������ͻ���˵��"+info);
			}
			socket.shutdownInput();
			//4.��ȡ���������Ӧ�ͻ��˵�����
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);//��װΪ��ӡ��
			pw.write("��ӭ����");
			pw.flush();//����flush()���������
			//5.�ر���Դ
			pw.close();
			os.close();
			br.close();
			isr.close();
			is.close();
			socket.close();
			serverSocket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
