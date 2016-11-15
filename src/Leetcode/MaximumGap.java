package Leetcode;

public class MaximumGap {
	//桶排序的思想（先将所有数据分装在几个桶中，然后对每个桶进行排序(越快越好，比如计数排序)）
	/**
	 * 假设有N个元素A到B。
	 * 那么最大差值不会小于ceiling[(B - A) / (N - 1)]
	 * 令bucket（桶）的大小len = ceiling[(B - A) / (N - 1)]，则最多会有(B - A) / len + 1个桶
	 * 对于数组中的任意整数K，很容易通过算式loc = (K - A) / len找出其桶的位置，然后维护每一个桶的最大值和最小值
	 * 由于同一个桶内的元素之间的差值至多为len - 1，因此最终答案不会从同一个桶中选择。
	 * 对于每一个非空的桶p，找出下一个非空的桶q，则q.min - p.max可能就是备选答案。返回所有这些可能值
	 */
	public int maximumGap(int[] nums) {
	    int n = nums.length;
	    if(n < 2) {
	    	return 0;
	    }
	    int min = nums[0];
	    int max = nums[0];
	    //找到数组中的最大值和最小值
	    for(int i = 1;i < n;i++){
	        if(min > nums[i]) min = nums[i];
	        if(max < nums[i]) max = nums[i];
	    }

	    int gap = (max - min) / (n - 1);
	    if(gap == 0) {
	    	gap ++;
	    }
	    
	    //如果最大值和最小值的差小于数组长度，则将len = (max - min) / gap + 1 这样减少了不必要的桶
	    int len = (max - min) / gap + 1;
	    //每一个桶维护一个最大值和最小值
	    int[] tmax = new int [len];
	    int[] tmin = new int [len];
	    
	    //填充桶的最大值和最小值
	    for(int i = 0;i < n;i++){
	        int index = (nums[i]- min) / gap;
	        if(nums[i] > tmax[index]) 
	        	tmax[index] = nums[i];
	        if(tmin[index] == 0 || nums[i] < tmin[index]) 
	        	tmin[index] = nums[i];
	    }
	    
	    //寻找相邻的数差别最大值
	    int myMax = 0;
	    for(int i = 0;i < len;i ++){
	        if(myMax < tmin[i] - min) 
	        	myMax = tmin[i] - min;
	        if(tmax[i] != 0) 
	        	min = tmax[i];
	    }
	    
	    return myMax;
	}
}
