package Leetcode;

public class MaximumGap {
	//Ͱ�����˼�루�Ƚ��������ݷ�װ�ڼ���Ͱ�У�Ȼ���ÿ��Ͱ��������(Խ��Խ�ã������������)��
	/**
	 * ������N��Ԫ��A��B��
	 * ��ô����ֵ����С��ceiling[(B - A) / (N - 1)]
	 * ��bucket��Ͱ���Ĵ�Сlen = ceiling[(B - A) / (N - 1)]����������(B - A) / len + 1��Ͱ
	 * ���������е���������K��������ͨ����ʽloc = (K - A) / len�ҳ���Ͱ��λ�ã�Ȼ��ά��ÿһ��Ͱ�����ֵ����Сֵ
	 * ����ͬһ��Ͱ�ڵ�Ԫ��֮��Ĳ�ֵ����Ϊlen - 1��������մ𰸲����ͬһ��Ͱ��ѡ��
	 * ����ÿһ���ǿյ�Ͱp���ҳ���һ���ǿյ�Ͱq����q.min - p.max���ܾ��Ǳ�ѡ�𰸡�����������Щ����ֵ
	 */
	public int maximumGap(int[] nums) {
	    int n = nums.length;
	    if(n < 2) {
	    	return 0;
	    }
	    int min = nums[0];
	    int max = nums[0];
	    //�ҵ������е����ֵ����Сֵ
	    for(int i = 1;i < n;i++){
	        if(min > nums[i]) min = nums[i];
	        if(max < nums[i]) max = nums[i];
	    }

	    int gap = (max - min) / (n - 1);
	    if(gap == 0) {
	    	gap ++;
	    }
	    
	    //������ֵ����Сֵ�Ĳ�С�����鳤�ȣ���len = (max - min) / gap + 1 ���������˲���Ҫ��Ͱ
	    int len = (max - min) / gap + 1;
	    //ÿһ��Ͱά��һ�����ֵ����Сֵ
	    int[] tmax = new int [len];
	    int[] tmin = new int [len];
	    
	    //���Ͱ�����ֵ����Сֵ
	    for(int i = 0;i < n;i++){
	        int index = (nums[i]- min) / gap;
	        if(nums[i] > tmax[index]) 
	        	tmax[index] = nums[i];
	        if(tmin[index] == 0 || nums[i] < tmin[index]) 
	        	tmin[index] = nums[i];
	    }
	    
	    //Ѱ�����ڵ���������ֵ
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
