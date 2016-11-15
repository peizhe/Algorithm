package Leetcode;

/**
 * 
 * dp 思想 : 写代码要仔细
 * 
 * @author MG
 * 
 */
public class SuperPow372 {
	
	/**
	 * 夹杂了很多数学公式
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int superPowBetter(int a, int[] b) {
	    if (a % 1337 == 0) return 0;
	    int p = 0;
	    for (int i : b) p = (p * 10 + i) % 1140;
	    if (p == 0) p += 1440;
	    return power(a, p, 1337);
	}
	public int power(int a, int n, int mod) {
	    a %= mod;
	    int ret = 1;
	    while (n != 0) {
	        if ((n & 1) != 0) ret = ret * a % mod;
	        a = a * a % mod;
	        n >>= 1;
	    }
	    return ret;
	}
	
	
	public static final int DES = 1337;

	public static int superPow(int a, int[] b) {
		int len = b.length;

		int[] yushu = new int[len];
		
		//存储a^1 a^10 a^100...%DES 的结果 
		int[] dp = new int[len];
		dp[len - 1] = a % DES;
		for(int i = len - 2;i >= 0; i--){
			int temp = dp[i + 1];
			for(int j = 1;j < 10; j++){
				temp = (temp * dp[i + 1]) % DES;
			}
			dp[i] = temp;
		}
		
		//计算每一位余数
		for (int i = len - 1; i >= 0; i--) {
			if(b[i] == 0){
				yushu[i] = 1;
				continue;
			} 
			
			int temp = 1;
			for(int j = 0;j < b[i]; j++){
				temp = (temp * dp[i]) % DES;
			}
			
			yushu[i] = temp;
		}
		
		int res = 1;
		for(int i : yushu){
			res = (res * i) % DES;
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2147483647;
		int[] b = new int[]{2,0,0};
		System.out.println(superPow(a, b));
	}
}
