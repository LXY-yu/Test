import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Address {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address=InetAddress.getLocalHost();//获取本机InetAddress实例
		System.out.println("计算机名："+address.getHostName());
		System.out.println("IP地址："+address.getHostAddress());
		byte[] bytes=address.getAddress();
		System.out.println("字符数组形式的IP地址:"+(Arrays.toString(bytes)));
		for(int i=0;i<bytes.length;i++){
			int s=(bytes[i]&0xFF);
			System.out.print(s+" ");
			System.out.println((Integer.toBinaryString(s)));
		}
		
		System.out.println(address);
		//根据计算机名获取InetAddress实例
		InetAddress address1=InetAddress.getByName("卡西");
		System.out.println("计算机名："+address1.getHostName());
		System.out.println("IP地址："+address1.getHostAddress());

	}

}
