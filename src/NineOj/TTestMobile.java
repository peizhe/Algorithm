package NineOj;

//��Ŀ1079���ֻ�����
import java.io.*;
import java.util.*;

public class TTestMobile {
	// �洢26����ĸ��Ӧ�İ�������
	public static int switchChar(int index) {
		int[] a = { 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 4, 1,
				2, 3, 1, 2, 3, 4 };
		return a[index];
	}

	// ����������ɣ�ע��һ��
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
