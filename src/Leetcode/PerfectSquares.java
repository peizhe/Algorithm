package Leetcode;
/**
 * 处理类似题的一种思想(记住)dp思想
 */
import java.util.Arrays;

public class PerfectSquares {
	
	public int numSquares(int n) {
		int[] temp = new int[n + 1];
		Arrays.fill(temp,Integer.MAX_VALUE);
		
		for(int i = 0;i * i <= n;i ++){
			temp[i * i] = 1;
		}
		
		for(int i = 1;i <= n;i ++){
			//精髓在这里
			for(int j = 0;i + j * j <= n;j ++){
				//最关键的一行代码
				temp[i + j * j] = Math.min(temp[i] + 1, temp[i + j * j]);
			}
		}
		
		return temp[n];
    }
}
