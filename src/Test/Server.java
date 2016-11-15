package Test;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
	public static void main(String[] args) throws IOException {
		int port = 12450;
		ServerSocket server = new ServerSocket(port);//����������socket
		System.out.println("�������ɹ�����...");
		while(true){
			Socket connect = server.accept();//�ȴ��ͻ���socket���ӣ�����connectָ���socket
			System.out.println("new connection accepted "+connect.getInetAddress().toString()+":"+
					connect.getPort());
			new SocketThread(connect).start();//�������̴߳����socket
		}
	}
}

class SocketThread extends Thread{

	private Socket soc;
	public SocketThread(Socket soc){
		super();
		this.soc = soc;
	}
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			BufferedReader rec = new BufferedReader(new InputStreamReader(soc.getInputStream()));//��ȡ��������������
			Writer writer = new OutputStreamWriter(soc.getOutputStream());//��ȡ�������������
			while(true){
				String mes = rec.readLine();//��ÿͻ����������Ϣ
				if(mes.equals("bye"))
					break;
				System.out.println(soc.getInetAddress().toString()+":"+soc.getPort()+" says: "
						+mes);
				writer.write(mes+'\n'); //����Ϣ���ظ��ͻ���
				writer.flush();//ˢ��
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			try {
				soc.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally{  		
			System.out.println("connection from "+soc.getInetAddress().toString()+":"+soc.getPort()
					+" is canceled");
			soc=null;
		}
	}
}

