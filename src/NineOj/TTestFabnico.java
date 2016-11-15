package NineOj;

//1075：斐波那契数列,打印图形

import java.io.*;

public class TTestFabnico {
	public static int Fabnico(int n) {
		if (n == 1 || n == 2) {
			return 1;
		}

		return Fabnico(n - 1) + Fabnico(n - 2);
	}

	public static void main(String[] mh) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println("0" + " ");
		for (int j = 1; j < n; j++) {
			System.out.print("0" + " ");
			for (int i = 1; i < 2 * j + 1; i++) {
				System.out.print(Fabnico(i) + " ");
			}
			System.out.println();
		}
	}
}
