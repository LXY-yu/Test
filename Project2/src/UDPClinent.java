import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * �ͻ��˵�ʵ��
 */
public class UDPClinent {
	public static void main(String args[]) throws IOException{
		//1.����������ĵ�ַ���˿ںš�����
		InetAddress address=InetAddress.getByName("localhost");
		int port=8800;
		byte[] data="�û�����admin;���룺123".getBytes();
		//2.�������ݱ�
		DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
		//3.����DatagramSocket����
		DatagramSocket socket=new DatagramSocket();
		//4.��������˷������ݱ�
		socket.send(packet);
				
	}

}
