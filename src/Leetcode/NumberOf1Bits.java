package Leetcode;

public class NumberOf1Bits {
	//需要循环32次（32位），比较麻烦
	public int hammingWeight(int n) {
		int result = 0;
		while(0 != n){
			//与运算
			int left = n & 0x1;
			result += left;
			//右移，相当于除以2
			n = n >> 1;
		}
		
		return result;
    }
	/**
	 * n = 0x110100  n-1 = 0x110011  n&(n - 1) = 0x110000 result ++;
	 * n = 0x110000  n-1 = 0x101111  n&(n - 1) = 0x100000 result ++;
	 * n = 0x100000  n-1 = 0x011111  n&(n - 1) = 0x0	  result ++;
	 * @param n
	 * @return
	 */
	//这个方法实在巧妙
	public int hammingWeight1(int n) {
		int result = 0;
		while(0 != n){
			n = n & (n - 1);//每进行一次这样的运算，就会消灭一个1
			result ++;
		}
		
		return result;
    }
}
