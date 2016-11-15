package Leetcode;
/**
 * 迭代的思想，真的是很精髓，自己做出来的，nice
 * @author Administrator
 *
 */
public class CountingBits {
	
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		if(num == 0){
			return result;
		}		
		result[0] = 0;
		result[1] = 1;
		for(int i = 2;i <= num;i ++){
			result[i] = result[i / 2] + result[i % 2];
		}
					
		return result;
    }
}
