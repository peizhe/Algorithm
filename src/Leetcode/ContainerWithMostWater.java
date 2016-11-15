package Leetcode;

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
        int result = 0;
        for(int i = 0;i < height.length - 1;i ++){
        	for(int j = i + 1;j < height.length;j ++){
        		int width = Math.min(height[i], height[j]);
        		int area = (j - i) * width;
        		
        		if(area > result){
        			result = area;
        		}
        	}
        }
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
