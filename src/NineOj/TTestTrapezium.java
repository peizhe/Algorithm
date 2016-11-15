package NineOj;

//1065：输出梯形

import java.io.*;

public class TTestTrapezium {
	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int h = Integer.parseInt(s), temp1, temp2;
		temp1 = h;
		temp2 = h;
		for (int i = 0; i < h; i++) {
			// 输出前面的空格
			for (int k = 2 * temp1 - 2; k > 0; k--) {
				System.out.print(" ");
			}
			temp1--;

			// 输出星号
			for (int j = 0; j < temp2; j++) {
				System.out.print("*");
			}
			temp2 = temp2 + 2;
			System.out.println();
		}
	}
}
