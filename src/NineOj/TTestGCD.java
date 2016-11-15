package NineOj;

//1056：最大公约数
import java.io.*;
import java.util.*;

public class TTestGCD {
	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> ls = new ArrayList<String>();
		String s;
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
			int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]), temp;
			temp = a % b;
			while (temp != 0) {
				a = b;
				b = temp;
				temp = a % b;
			}
			System.out.println("最大公约数是：" + b);
		}
	}
}
