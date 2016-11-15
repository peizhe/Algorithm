package Leetcode;
/**
 * dp��˼�룬��LeetCode�е�PerfectSquares�����ƣ���Ҫ�޸�һ�£�������һ����Ŀ��
 */
import java.util.Arrays;

public class CoinChange {
	
	public int coinChange(int[] coins, int amount) {
		if(amount == 0){
			return 0;
		}
		
		Arrays.sort(coins);
		if(amount < coins[0]){
			return -1;
		}
		
		int[] assist = new int[amount + 1];
		Arrays.fill(assist, Integer.MAX_VALUE);
		for(int i = 0;i < coins.length && coins[i] < assist.length;i ++){
			assist[coins[i]] = 1;
		}
		
		for(int i = 1;i <= amount;i ++){
			if(assist[i] == Integer.MAX_VALUE){
				continue;
			}
			//ע��������ж���������Щ�˾ʹ���
			for(int j = 0;j < coins.length && i + coins[j] <= amount;j ++){
				assist[i + coins[j]] = Math.min(assist[i]  + 1, assist[i + coins[j]]);
			}
		}
		
		return assist[amount] == Integer.MAX_VALUE ? -1 : assist[amount];
    }
}
