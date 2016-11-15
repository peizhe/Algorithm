package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		String serverIp = "127.0.0.1";
		int serverPort = 12450;
		Socket soc = null;
		try{
			soc = new Socket(serverIp,serverPort);
		}catch(Exception e){
			System.out.println("access denied");
			System.exit(0);//结束程序
		}
		new SocketSendThread(soc).start();
		new SocketReceiveThread(soc).start();
	}
}

class SocketReceiveThread extends Thread{

	private Socket soc;
	public SocketReceiveThread(Socket soc){
		super();
		this.soc = soc;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			BufferedReader rec = new BufferedReader(new InputStreamReader(soc.getInputStream()));
			while(true){
				String mes = rec.readLine();
				System.out.println("message from server: "+mes);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("connection break");
			try {
				soc.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}  
	}
}

class SocketSendThread extends Thread{
	private Socket soc;
	public SocketSendThread(Socket soc){
		super();
		this.soc = soc;
	}
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			while(true){
				Writer writer = new OutputStreamWriter(soc.getOutputStream()); 
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String mes = br.readLine();
				writer.write(mes.toString()+'\n'); 
				System.out.println("我输入消息了：" + mes.toString());
				writer.flush();
				if(mes.equals("bye"))
					break;
			} 
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}finally{
			try {
				soc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}



