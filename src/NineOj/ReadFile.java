package NineOj;

import java.io.*;

public class ReadFile {
	private static BufferedReader br;

	public static void main(String[] mh) throws Exception {
		br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"C:\\Users\\Administrator\\Desktop\\���ڵشŶ�λ\\����\\����������\\������1˳ʱ��\\3.txt")));
		String s;
		while ((s = br.readLine()) != "") {
			String[] str = s.split(",");
			System.out.println(str[2]);
		}
	}
}
