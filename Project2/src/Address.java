import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Address {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress address=InetAddress.getLocalHost();//��ȡ����InetAddressʵ��
		System.out.println("���������"+address.getHostName());
		System.out.println("IP��ַ��"+address.getHostAddress());
		byte[] bytes=address.getAddress();
		System.out.println("�ַ�������ʽ��IP��ַ:"+(Arrays.toString(bytes)));
		for(int i=0;i<bytes.length;i++){
			int s=(bytes[i]&0xFF);
			System.out.print(s+" ");
			System.out.println((Integer.toBinaryString(s)));
		}
		
		System.out.println(address);
		//���ݼ��������ȡInetAddressʵ��
		InetAddress address1=InetAddress.getByName("����");
		System.out.println("���������"+address1.getHostName());
		System.out.println("IP��ַ��"+address1.getHostAddress());

	}

}
