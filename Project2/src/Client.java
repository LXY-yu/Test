import java.io.*;
import java.net.Socket;

public class Client {

	public static void main(String[] args) {
		try {
			//1.创建客户端socket,指定服务器地址和端口
			Socket socket=new Socket("localhost",8888);
			//指定服务器，当前服务器在本机上，所以可以写localhost，也可以写IP地址，服务器的端口号为8888
			//2.获取输出流，向服务器发送消息
			OutputStream os=socket.getOutputStream();//字节输出流
			PrintWriter pw=new PrintWriter(os);
			pw.write("用户名：tom；密码：456");
			pw.flush();
			socket.shutdownOutput();//关闭输出流
			//3.获取输入流，并读取服务器端的响应信息
			InputStream is=socket.getInputStream();
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是客户端，服务器端说："+info);
			}
			//4.关闭资源
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
