package NineOj;

import java.io.*;
import java.util.*;

public class TTestJieTi {
	public static void sum(Long a, Long n) {
		Long sum = a, temp = a;
		for (int i = 1; i < n; i++) {
			temp = temp * 10 + a;
			sum = sum + temp;
		}
		System.out.println(sum);
	}

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
			sum(Long.parseLong(str[0]), Long.parseLong(str[1]));
		}
	}
}
