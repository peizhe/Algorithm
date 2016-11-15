package HihoCoder;

import java.util.Scanner;

/**
 * 没啥意义(可以不看)
 * 
 * @author MG
 *
 */
public class TheLastestTime1408 {
	static String ans = "";
	static int best = -1;
	static int[] arr = null;
	static int[] now = null;
	static boolean[] flag = null;
	private static Scanner cin;

	public static void Go(int k) {
		if (k == 4) {
			int h = now[0] * 10 + now[1];
			int m = now[2] * 10 + now[3];
			if (h >= 0 && h <= 23 && m >= 0 && m <= 59 && h * 100 + m > best) {
				best = h * 100 + m;
				ans = "" + now[0] + now[1] + ":" + now[2] + now[3];
			}
			return;
		}
		for (int i = 0; i < 4; i++)
			if (!flag[i]) {
				flag[i] = true;
				now[k] = arr[i];
				Go(k + 1);
				flag[i] = false;
			}
	}

	public static void main(String[] agrs) {
		cin = new Scanner(System.in);
		arr = new int[4];
		now = new int[4];
		for (int i = 0; i < 4; i++)
			arr[i] = cin.nextInt();
		flag = new boolean[4];
		Go(0);
		if (best != -1)
			System.out.println(ans);
		else
			System.out.println("NOT POSSIBLE");
	}
}
