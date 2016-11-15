package NineOj;

//1049 输入字符串s和字符c，要求去掉s中所有的c字符，并输出结果
import java.util.*;
import java.io.*;

public class TTestDeleteChar {
	public static void main(String[] mh) throws IOException {
		String s;
		ArrayList<String> ls = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ls.add(s);
			}

		} while (true);
		for (int i = 0; i < ls.size(); i++) {
			String[] str = ls.get(i).split(" ");
			String[] str1 = str[0].split(str[1]);
			String s1 = "";
			for (int j = 0; j < str1.length; j++) {
				s1 = s1 + str1[j];
			}
			System.out.println(s1);
		}
	}
}
