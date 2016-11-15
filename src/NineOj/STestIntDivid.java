package NineOj;

//1084：整数拆分
/*思想
 对于奇数n=2k+1：它的拆分的第一项一定是1，考虑去掉这个1，其实就一一对应于
 2k的拆分，因此f(2k+1)=f(2k).

 对于偶数n=2k：考虑有1和没有1的拆分。有1的拆分，与(2k-1)的拆分一一对应，与上面奇数的情况
 理由相同；没有1的拆分，将每项除以2，正好一一对应于k的所有拆分。因此f(2k)=f(2k-1)+f(k).

 需要注意f(n)会很大，不要溢出了。最终结果只要求除以十亿的余数，在int的表示范围内，
 因此不需要大数运算。注意余数的性质：(a+b)%m == (a%m+b%m)%m，所以只要对每个中间
 结果也都取余数，就不会有溢出的问题，且不改变最终输出结果。
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
