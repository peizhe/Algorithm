package LeetCodeSecondMedium;

public class ContainerWithMostWater11 {
	public int maxArea(int[] height) {
		int res = 0, begin = 0, end = height.length - 1;
		
		while(begin < end) {
			res = Math.max(res, Math.min(height[begin], height[end]) * (end - begin));
			if(height[begin] < height[end]) begin ++;
			else end --;
		}
		
        return res;
    }
}
