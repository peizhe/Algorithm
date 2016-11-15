package Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes354 {
	/**
	 * ����д�ĸ��ŵĴ���
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
				//�����һ��������ͬ(���)���򰴵ڶ�������(�߶�)��������
				//�����һ��������ͬ(���)���򰴵�һ������(���)��������
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
