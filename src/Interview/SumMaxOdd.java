package Interview;
/**
 * 求前N个数的最大奇约数之和
 * 	1.动态规划(内存消耗大)
 * 	2.奇数相加，每个偶数右移1直到最低位不为0(不消耗内存，时间复杂度不能达到O(n))
 * 	3.很屌的方法(见下面)
 * @author MG
 *
 */
public class SumMaxOdd {
	public static long maxOddSum(int n) {
		if(n < 1) return 0;
		long res = 0;
		for(long i = n; i > 0; i /= 2) {
			if((i & 1) == 1) {
				res += ((i + 1) / 2) * ((i + 1) / 2); 
			} else {
				res += (i / 2) * (i / 2);
			}
		}
		
		return res;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
