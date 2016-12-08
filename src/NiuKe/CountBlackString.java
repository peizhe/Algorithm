package NiuKe;

public class CountBlackString {

	public static long getBlackString(int n) {
		long[] num = new long[n + 1];
		num[1] = 3;
		num[2] = 9;
		for (int i = 3; i <= n; i++) {
			num[i] = 2 * num[i - 1] + num[i - 2];
		}

		return num[n];
	}
}
