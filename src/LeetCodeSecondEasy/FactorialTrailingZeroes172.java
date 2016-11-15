package LeetCodeSecondEasy;
/**
 * n的阶乘尾部的0是由2 * 5得来的，2的数量肯定大于5的数量，所以存在5的个数就是尾部0的个数
 * 	1.双层循环的实现浪费时间
 * 	2.return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
 * @author MG
 *
 */
public class FactorialTrailingZeroes172 {
	public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(10));
	}

}
