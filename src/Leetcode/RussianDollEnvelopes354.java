package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes354 {
	/**
	 * 大神写的更屌的代码
	 * @param envelopes
	 * @return
	 */
	public int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0){
        	return 0;
        }
        int length = envelopes.length;
        
        Arrays.sort(envelopes, new Comparator<int[]>() {

			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				//如果第一个参数相同(宽度)，则按第二个参数(高度)降序排序
				//如果第一个参数不同(宽度)，则按第一个参数(宽度)升序排序
				return o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0];
			}
		});
        
        int[] dp = new int[length];
        
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            
            dp[index] = envelope[1];
            
            if(index == len)
                len ++;
        }
        
        return len;
    }
}
