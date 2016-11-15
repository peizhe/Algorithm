package NineOj;
//1055£ºÊý×éÄæÖÃ
import java.io.*;

public class TTestReverse {
	public static void main(String[] mh) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] ch;
		String s = br.readLine();
		ch = s.toCharArray();
		for(int i = ch.length - 1;i >= 0 ;i --)
		{
			System.out.print(ch[i]);
		}
	}
}
