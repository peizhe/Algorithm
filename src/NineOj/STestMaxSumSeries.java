package NineOj;

import java.io.*;
import java.util.*;

public class STestMaxSumSeries {

	public static long maxSubSum1(long[] a) {
		long maxSum = Long.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				long thisSum = 0L;
				for (int k = i; k <= j; k++) {
					thisSum = thisSum + a[k];
				}
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

	public static long maxSubSum2(long[] a) {
		long maxSum = Long.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			long thisSum = 0L;
			for (int j = i; j < a.length; j++) {
				thisSum = thisSum + a[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}

	public static long maxSubSum3(long[] a, int left, int right) {
		if (left == right) {
			if (a[left] > 0) {
				return a[left];
			} else
				return 0L;
		}
		int centre = (right + left) / 2;
		long maxLeftSum = maxSubSum3(a, left, centre);
		long maxRightSum = maxSubSum3(a, centre + 1, right);

		long maxLeftBorderSum = Long.MIN_VALUE, leftBorderSum = 0;
		for (int i = centre; i >= left; i--) {
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		long maxRightBorderSum = Long.MIN_VALUE, rightBorderSum = 0;
		for (int j = centre + 1; j <= right; j++) {
			rightBorderSum += a[j];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}
		return Math.max(Math.max(maxLeftSum, maxRightSum),
				(maxLeftBorderSum + maxRightBorderSum));
	}

	// 复杂度O(n) 求不出最大序列的位置
	public static long maxSubSum4(long[] array) {
		long maxSum = Long.MIN_VALUE, thisSum = 0;
		for (int j = 0; j < array.length; j++) {
			thisSum += array[j];

			if (thisSum > maxSum) {
				maxSum = thisSum;
			}
			if (thisSum < 0) {
				thisSum = 0;
			}
		}
		return maxSum;
	}

	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		ArrayList<ArrayList<String>> ls = new ArrayList<ArrayList<String>>();
		do {
			s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(s);
				String s1;
				s1 = br.readLine();
				temp.add(s1);
				ls.add(temp);
			}
		} while (true);
		
		for (int i = 0; i < ls.size(); i++) {
			String[] str = ls.get(i).get(1).split(" ");
			long[] a = new long[str.length];
			for (int j = 0; j < str.length; j++) {
				a[j] = Long.parseLong(str[j]);
			}
			long result = maxSubSum3(a, 0, a.length - 1);
			System.out.println(result);
		}
	}
}
