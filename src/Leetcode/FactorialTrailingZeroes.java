package Leetcode;
/**
 * 分解因子, 当且仅当 因子中出现 一对 (2,5)时, 最后结果会增加一个 trailing zero.
 * 2的个数永远多于5个个数.
 * 计算5的个数时, 最简单的方法是 SUM(N/5^1,  N/5^2, N/5^3...)
 * @author MG
 *
 */
public class FactorialTrailingZeroes {
	
	public int trailingZeroes(int n) {
		int res = 0;  
        while(n > 0)  
        {  
            res += n/5;  
            n /= 5;  
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
