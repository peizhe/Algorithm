package Leetcode;
/**
 * 没看懂
 * 这道题和两个板之间成水量最大的思想一样！！！
 * 这里是两边往中间遍历，记录当前第二高点secHight，然后利用这个第二高点减去当前历经的柱子，剩下就装水容量了。
 * @author MG
 *
 */
public class ImportantTrappingRainWater {
	
	public int trap(int[] height) {
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right){
			if (height[left] < height[right]){
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];//计算当前格的能装雨水的容量
				left++;
			} else {
				secHight = Math.max(height[right], secHight);
				area += secHight-height[right];
				right--;
			}
		}
		return area;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class<?> clazz = Class.forName("leetcode.TrappingRainWater");
			ImportantTrappingRainWater trw = (ImportantTrappingRainWater)clazz.newInstance();
			int[] a = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
			System.out.println(trw.trap(a));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
