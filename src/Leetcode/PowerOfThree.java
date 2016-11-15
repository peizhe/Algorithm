package Leetcode;
/**
 * 判断一个数是否为n的幂，可以采用如下策略：
 * 1.以n为底数，以输入的数字为原数进行取对数运算
 * 2.如果结果为 整数，则为n的幂，否则不为n的幂
 *
 */

public class PowerOfThree {
	
	public static boolean isPowerOfThree(int n) {
		double ep = Math.pow(10, -10);
        boolean result = false;
        
        double temp = Math.log(n) / Math.log(3);
        
        result = Math.abs(temp - Math.round(temp)) <= ep;
        
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfThree(59049));
	}

}
