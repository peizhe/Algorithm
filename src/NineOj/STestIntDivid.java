package NineOj;

//1084���������
/*˼��
 ��������n=2k+1�����Ĳ�ֵĵ�һ��һ����1������ȥ�����1����ʵ��һһ��Ӧ��
 2k�Ĳ�֣����f(2k+1)=f(2k).

 ����ż��n=2k��������1��û��1�Ĳ�֡���1�Ĳ�֣���(2k-1)�Ĳ��һһ��Ӧ�����������������
 ������ͬ��û��1�Ĳ�֣���ÿ�����2������һһ��Ӧ��k�����в�֡����f(2k)=f(2k-1)+f(k).

 ��Ҫע��f(n)��ܴ󣬲�Ҫ����ˡ����ս��ֻҪ�����ʮ�ڵ���������int�ı�ʾ��Χ�ڣ�
 ��˲���Ҫ�������㡣ע�����������ʣ�(a+b)%m == (a%m+b%m)%m������ֻҪ��ÿ���м�
 ���Ҳ��ȡ�������Ͳ�������������⣬�Ҳ��ı�������������
 */

import java.io.*;
import java.util.*;

public class STestIntDivid {
	public static int num(int n) {
		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		} else if (n % 2 == 0) {
			return (num(n - 1) % 1000000000 + num(n / 2) % 1000000000) % 1000000000;
		} else {
			return num(n - 1) % 1000000000;
		}
	}

	public static void main(String[] mh) throws IOException {
		ArrayList<String> ls = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		do {
			String s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ls.add(s);
			}
		} while (true);
		for (int i = 0; i < ls.size(); i++) {
			System.out.println(num(Integer.parseInt(ls.get(i))));
		}
	}
}
