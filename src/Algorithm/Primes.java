package Algorithm;

import java.util.Arrays;

/**
 * 1.质数筛选法 :
 * 	(1)埃拉托色尼筛法(时间复杂度O(nlogn))
 * 	(2)欧拉筛法 (时间复杂度O(n))
 * 
 * 2.判断一个数是否是素数:(米勒罗宾测试)
 * 
 * 3.计算<=n的与n互质的数个数
 * 
 * @author MG
 *
 */
public class Primes {
	
	/**
	 * 这个算法叫埃拉托色尼质数筛法(时间复杂度是O(nlogn),比传统方法快速的多)
	 * 
	 * 由于一个合数总是可以分解成若干个质数的乘积，那么如果把质数（最初只知道2是质数）的倍数都去掉，那么剩下的就是质数了。
	 * 例如要查找100以内的质数，首先2是质数，把2的倍数去掉；此时3没有被去掉，可认为是质数，所以把3的倍数去掉；
	 * 	     再到5，再到7，7之后呢，因为8，9，10刚才都被去掉了，而100以内的任意合数肯定都有一个因子小于10（100的开方），
	 *    所以，去掉，2，3，5，7的倍数后剩下的都是质数了。
	 * 用程序可以这样解决，引入布尔类型数组a[i]，如果i是质数，a[i]=true，否则a[i]=false。
	 * 那么划掉i可以表示成a[i]=false。
	 * 
	 * @param n
	 */
	public static void sieve(int n){
		boolean[] assist = new boolean[n];
		Arrays.fill(assist, true);
		
		for(int i = 2;i < n;i ++){
			if(assist[i]){
				//注意这从i开始，不用从1开始
				for(int j = i * i; j < n;j += i){
					assist[j] = false;
				}
			}
		}
	}
	
	/**
	 * 质数欧拉筛法,时间复杂度(O(n) 每个数都会被判断一次) 上面方法中 : 30 在2 * 15 会被筛,在3 * 10也会被筛,在5 * 6 也会被筛(30被重复筛了多次)
	 * 	
	 * 	
	 * @param n
	 */
	public static int elur(int n){
		//标记是否为素数
		boolean[] flags = new boolean[n];
		int[] primes = new int[n];
		int primeIndex = 0;
		
		Arrays.fill(flags, true);
		for(int i = 2; i < n; i++){
			if(flags[i]){
				primes[primeIndex ++] = i;
			}
			
			for(int j = 0; j < primeIndex; j++){
				//判断是否超出范围
				if(i * primes[j] > n) break;
				
				flags[i * primes[j]] = false;
				
				//每个数都是由它最小的质因数过滤掉(这句话很关键)
				if(i % primes[j] == 0) break;
			}
		}
		
		return primeIndex == 0 ? 0 : primeIndex - 1;
	}
	
	/**
	 * 判断一个数是否为素数
	 * 	米勒罗宾判定法
	 * 	
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		return true;
	}
	
	/**
	 * 假设 b很大,求a * b % n 的结果
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	public static int getAmulBModN(int a, long b, int n) {
		int res = 0;
		while(b != 0){
			if((b & 1) == 1) res = (res + a) % n;
			
			a = (a + a) % n;
			
			b >>= 1;
		}
		
		return res;
	}
	
	/**
	 * b很大,计算a^b % n的值
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	public static int getAPowerBModN(int a, long b, int n){
		int res = 1;
		while(b != 0) {
			if((b & 1) == 1) res = getAmulBModN(res, a, n);
			
			a = getAPowerBModN(a, a, n);
			
			b >>= 1;
		}
		
		return res;
	}
	
	/**
	 * 欧拉函数f(n):计算<=n的与n互质的数的个数
	 * f(x) = x(1-1/p1)(1-1/p2)(1-1/p3)(1-1/p4)…(1-1/pn),其中p1,p2……pn为x的所有素因数
	 * 
	 * 若m,n互质,f(m * n) = f(m) * f(n)
	 * 特殊性质：当n为奇数时 f(2 * n) = f(n), 证明与上述类似。
	 * 若n为质数则f(n) = n - 1 
	 * 
	 * @param n
	 * @return
	 */
	public static int getCount(int n){
		int res = n, a = n;
		for(int i = 2; i * i <= n; i++) {
			if(a % i == 0) {
				//防止越界
				res = res / i * (i - 1);
				while(a % i == 0) a /= i;
			}
		}
		
		//a剩下的如果不为1就肯定为质数
		if(a > 1) res = res / a * (a - 1);
		
		return res;
	}
	
	/**
	 * 得到1-n的欧拉函数值
	 * 
	 * @param n
	 * @return
	 */
	public static int[] getElur(int n){
		int[] values = new int[n + 1];
		values[1] = 1;
		//公式中x*(1 - 1/p1)...中的x
		for(int i = 2;i <= n; i++) {
			values[i] = i;
		}
		
		for(int i = 2; i <= n; i++){
			//values[i] == i : 证明i为质数
			if(values[i] == i){
				//后面每个都有i这个质因数
				for(int j = i; j <= n; j += i){
					//先做除法是防止越界
					values[j] = values[j] / i * (i - 1);
				}
			}
		}
		
		return values;
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCount(10));
	}
}
