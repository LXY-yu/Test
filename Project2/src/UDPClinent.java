import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
 * 客户端的实现
 */
public class UDPClinent {
	public static void main(String args[]) throws IOException{
		//1.定义服务器的地址、端口号、数据
		InetAddress address=InetAddress.getByName("localhost");
		int port=8800;
		byte[] data="用户名：admin;密码：123".getBytes();
		//2.创建数据报
		DatagramPacket packet=new DatagramPacket(data,data.length,address,port);
		//3.创建DatagramSocket对象
		DatagramSocket socket=new DatagramSocket();
		//4.向服务器端发送数据报
		socket.send(packet);
				
	}

}
