import java.io.*;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			//1.�����ͻ���socket,ָ����������ַ�Ͷ˿�
			Socket socket=new Socket("localhost",8888);
			//ָ������������ǰ�������ڱ����ϣ����Կ���дlocalhost��Ҳ����дIP��ַ���������Ķ˿ں�Ϊ8888
			//2.��ȡ��������������������Ϣ
			OutputStream os=socket.getOutputStream();//�ֽ������
			PrintWriter pw=new PrintWriter(os);
			pw.write("�û�����tom�����룺456");
			pw.flush();
			socket.shutdownOutput();//�ر������
			//3.��ȡ������������ȡ�������˵���Ӧ��Ϣ
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("���ǿͻ��ˣ���������˵��"+info);
			}
			//4.�ر���Դ
			br.close();
			is.close();
			pw.close();
			os.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
