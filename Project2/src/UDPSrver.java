import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*
 * �������ˣ�����UDP���û���¼
 */
public class UDPSrver {
	public static void main(String args[]) throws IOException{
		/*
		 * �������˽��տͻ��˵�����
		 */
		//1.������������DatagramSocket,ָ���˿�
		DatagramSocket socket=new DatagramSocket(8800);
		//2.�������ݱ������ڽ��տͻ��˷��͵�����
		byte[] data=new byte[1024];
		DatagramPacket packet=new DatagramPacket(data,data.length);
		//3.���տͻ��˷��͵�����
		System.out.println("******���������Ѿ��������ȴ��ͻ��˷�������******");
		socket.receive(packet);
		//4.��ȡ����
		String info=new String(data,0,packet.getLength());
		System.out.println("���Ƿ��������ͻ���˵��"+info);
		
	}

}
