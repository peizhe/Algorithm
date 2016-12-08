package NiuKe;

/**
 * 定义函数f(x)为x最大的奇数约数，x为正整数。 例如:f(44) = 11.
 * 现在给出一个N，需要求出 f(1) + f(2) + f(3).......f(N)
 * 例如： N = 7 
 * 
 * f(1) + f(2) + f(3) + f(4) + f(5) + f(6) + f(7) = 1 + 1 + 3 + 1 + 5 + 3 + 7 = 21
 * 
 * 
 * 思路:
 * 因为奇数的最大奇数约数就是自己啊，对于偶数我们只能一直除2直到得到一个奇数即为最大奇数约数
 * 比如1 2 3 4 5 6 7 8 9 10
 * 即n=10 ，此时奇数有1 3 5 7 9 我们把这几个奇数相加然后 n/2
 * 得到第二轮序列序列 1 2 3 4 5 分别对应上次的2 4 6 8 10 五个偶数，这是我们再加1 3 5
 * 
 * 细节问题：
 * 	1.当n为偶数，就有n/2个奇数，根据等差数列求和公式。
 * 	     即为(n / 2) * (n / 2) = 1 + 3 + ... + (n - 1),
 * 	     此时n为偶数，因此 (n / 2) * (n / 2) = ((n + 1) / 2) * ((n + 1) / 2)
 * 
 * 	2.当n为奇数，有(n + 1) / 2个奇数，此时奇数和为((n + 1) / 2) * ((n + 1) / 2) = 1 + 3 + ... + n
 * 	
 * @author Administrator
 *
 */
public class MaxOdd {
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
	
	public static void main(String[] mh) {
		System.out.println(maxOddSum(7));
	}
}
