package Leetcode;

/**
 * 
 * 解决办法 :
 * 	1.dfs
 * 	2.dp(mle) : 质数筛选的思想
 * 
 * 2*2^a1  3*2^a2  5*2^a3 7*2^a4......
 * 	无论a1,a2,a3...如何取值，他们的结果永远不相同(永远不相交)
 * 
 * @author MG
 *
 */
public class IntegerReplacement397 {
	public static int integerReplacement(int n) {
        if(n == 1){
        	return 0;
        }
        
        return dfs(n);
    }
	
	private static int dfs(long n){
		if(n == 1){
			return 0;
		}
		
		if((n & 1) == 0){
			return dfs(n >> 1) + 1;
		} else {
			return Math.min(dfs(n + 1), dfs(n - 1)) + 1;
		}
	}
	
	public static void main(String[] mh){
		System.out.println(integerReplacement(10000));
	}
}
