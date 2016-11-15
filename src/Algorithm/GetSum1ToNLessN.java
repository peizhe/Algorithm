package Algorithm;

/**
 * 给定一个数n : 求最大的N，要求1 + 2 + 3 + ... + N <= n
 * 
 * @author MG
 * 
 */
public class GetSum1ToNLessN {
	/**
	 * (1 + X) * X = 2n
	 * 	解方程 X = (-b + genhao(b ^ 2 - 4ac)) / 2a
	 * 
	 * If x is the answer, then n coins do fill x rows but don't fill x+1 rows. 
	 * So we have x(x+1)/2 ≤ n < (x+1)((x+1)+1)/2. 
	 * Which, using the other formula, turns into x ≤ (sqrt(8n+1) - 1) / 2 < x+1. 
	 * So we indeed get the right answer by rounding down (sqrt(8n+1) - 1) / 2.
	 * 
	 * @param n
	 * @return
	 */
	public static int getMaxN(int n) {
		return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
	}

	public int getMaxBinarySearch(int n) {
		int lo = 0, hi = n;
		while (lo <= hi) {
			long mid = lo + ((hi - lo) >> 1), a = (1 + mid), b = (2 + mid);
			if (a * mid / 2 <= (long) n && a * b / 2 > (long) n)
				return (int) mid;
			else if (a * mid / 2 > (long) n)
				hi = (int) mid - 1;
			else
				lo = (int) mid + 1;
		}
		
		return lo;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
