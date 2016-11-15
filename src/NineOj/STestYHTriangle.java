package NineOj;

//1073：杨辉三角形

import java.util.*;

public class STestYHTriangle {
	private static Scanner sc;

	// 这个函数比较好，看一下
	public static int YH(int n, int k) {
		if (k <= 0 || k > n) {
			return 1;
		}
		return YH(n - 1, k) + YH(n - 1, k - 1);
	}

	public static void main(String[] mh) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i + 2; j++) {
				System.out.print(YH(i, j) + "	");
			}
			System.out.println();
		}
	}
}
