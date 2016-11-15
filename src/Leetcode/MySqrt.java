package Leetcode;

public class MySqrt {
	public int mySqrt(int x) {
		int begin = 0;
		int end = x / 2 + 1;
		while (begin <= end) {
			double mid = (begin + end) / 2;
			double temp = mid * mid;
			if (Math.abs(temp - x) <= 0.01) {
				return (int) mid;
			} else if (temp > x) {
				end = (int) mid - 1;
			} else {
				begin = (int) mid + 1;
			}
		}

		return end;
	}

	public static void main(String[] mh) {
		MySqrt mq = new MySqrt();
		System.out.println(mq.mySqrt(4));
	}
}
