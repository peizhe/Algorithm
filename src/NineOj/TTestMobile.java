package NineOj;

//题目1079：手机键盘
import java.io.*;
import java.util.*;

public class TTestMobile {
	// 存储26个字母对应的按键次数
	public static int switchChar(int index) {
		int[] a = { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1,
				2, 3, 1, 2, 3, 4 };
		return a[index];
	}

	// 这个方法很巧，注意一下
	public static boolean judge(char a1, char b1) {
		return a1 - b1 == switchChar(a1 - 'a') - switchChar(b1 - 'a');
	}

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
			char[] ch = ls.get(i).toCharArray();
			int sum = switchChar(ch[0] - 'a');
			for (int j = 1; j < ch.length; j++) {
				sum = sum + switchChar(ch[j] - 'a');
				if (judge(ch[j - 1], ch[j])) {
					sum = sum + 2;
				}
			}
			System.out.println(sum);
		}
	}
}
