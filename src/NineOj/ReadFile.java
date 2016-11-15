package NineOj;

import java.io.*;

public class ReadFile {
	private static BufferedReader br;

	public static void main(String[] mh) throws Exception {
		br = new BufferedReader(
				new InputStreamReader(
						new FileInputStream(
								"C:\\Users\\Administrator\\Desktop\\基于地磁定位\\数据\\会议室数据\\会议室1顺时针\\3.txt")));
		String s;
		while ((s = br.readLine()) != "") {
			String[] str = s.split(",");
			System.out.println(str[2]);
		}
	}
}
