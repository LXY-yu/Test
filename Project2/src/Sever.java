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
			//1.创建一个服务器端Socket，即SeverSocket，指定绑定的端口，并监听此端口
			ServerSocket serverSocket=new ServerSocket(8888);
			//2.调用accept()方法开始监听，等待客户端的连接
			System.out.println("***服务器即将启用，等待客户端的连接***");
		    Socket socket=serverSocket.accept();
		    //3.获取数据流，并读取客户端信息
		    InputStream is=socket.getInputStream();//字节输入流
			InputStreamReader isr=new InputStreamReader(is);//字符输入流
			BufferedReader br=new BufferedReader(isr);//将字符输入流添加缓冲
			String info=null;
			while((info=br.readLine())!=null){
				System.out.println("我是服务器，客户端说："+info);
			}
			socket.shutdownInput();
			//4.获取输出流，响应客户端的请求
			OutputStream os=socket.getOutputStream();
			PrintWriter pw=new PrintWriter(os);//包装为打印流
			pw.write("欢迎您！");
			pw.flush();//调用flush()将缓冲输出
			//5.关闭资源
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
