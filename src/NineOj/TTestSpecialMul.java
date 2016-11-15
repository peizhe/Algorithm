package NineOj;

//1083£∫Ãÿ ‚≥À∑®
import java.io.*;
import java.util.*;

public class TTestSpecialMul {
	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> ls = new ArrayList<String>();

		do {
			String s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ls.add(s);
			}
		} while (true);

		for (int i = 0; i < ls.size(); i++) {
			String[] str = ls.get(i).split(" ");
			int sum = 0;
			for (int j = 0; j < str[0].length(); j++) {
				for (int k = 0; k < str[1].length(); k++) {
					sum = sum + (str[0].charAt(j) - '0')
							* (str[1].charAt(k) - '0');
				}
			}
			System.out.println(sum);
		}
	}
}
