package Interview;

import java.util.Arrays;

/**
 * ����m > n
 * �ڴ�32M
 * ʱ��1s
 * @author MG
 * 
 */
public class StoneCount {
	public static int[] getPrimes(int n) {
		int[] flags = new int[n];
		Arrays.fill(flags, -1);

		flags[4] = 0;

		for (int i = 2; i < n;i ++) {
			for (int j = 3 * i;j < n; j += i) {
				int temp = flags[j - i] + 1;
				
				if (flags[j] == -1) {
					flags[j] = temp;
				} else if (flags[j] > temp) {
					flags[j] = temp;
				}
			}
		}

		return flags;
	}

	/**
	 * @param args
	 */
	public static void main(String[] mh) {
		// TODO Auto-generated method stub
		long begin = System.currentTimeMillis();
		int[] x = getPrimes(100000);
		long end = System.currentTimeMillis();
		
		System.out.println((end - begin) + "ms" + x.length);
	}

}
