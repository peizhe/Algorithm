package Leetcode;
/**
 * û����
 * ������������֮���ˮ������˼��һ��������
 * �������������м��������¼��ǰ�ڶ��ߵ�secHight��Ȼ����������ڶ��ߵ��ȥ��ǰ���������ӣ�ʣ�¾�װˮ�����ˡ�
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
				area += secHight - height[left];//���㵱ǰ�����װ��ˮ������
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
