package Leetcode;

/**
 * 数学公式
 * 
 * @author MG
 *
 */
public class ArrangingCoins441 {
	
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
	public static int arrangeCoins(int n) {
		return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(arrangeCoins(1804289383));
	}
}
