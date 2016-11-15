package Algorithm;
/**
 * ͨ�����ֲ��ҵķ�������������һ������x����:
 * 	���� : begin end  ������begin = mid(������������ֵ,��������ѭ��)
 * 		��begin + 1 = endʱ, mid = begin + (end - begin) / 2 = begin(�����������ѭ��)
 * 
 * ��һ�������������ҵ���һ�����ڵ���target����
 * 
 * @author MG
 *
 */
public class FindFirstMoreThanX {
	
	
	/**
	 * ��������
	 * 
	 * �ҵ���һ������X�������±�����ҵ����һ��С��X�������±�
	 * 
	 * @param nums
	 * @param target
	 * @param firstMaxOrLastMin ��������һ����x��������±�(True)�����������һ����xС�������±�(False)
	 * @return
	 */
	private static int findFirstMoreThanX(int[] nums, int target, boolean firstMaxOrLastMin){
		int begin = 0, end = nums.length - 1;
		while(begin < end) {
			int mid = begin + ((end - begin) >> 1);
			if(nums[mid] > target) end = mid;
			else if(nums[mid] < target) begin = mid + 1;
			else return mid;
		}
		
		//Ѱ�ҵ�һ����target�����
		if(firstMaxOrLastMin) return begin == nums.length - 1 ? -1 : begin;
		//Ѱ�����һ����targetС����
		else return begin == 0 ? -1 : begin - 1; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{2,3,5,7,11,12,13,13,17,19,20,24};
		int target = 1;
		System.out.println(findFirstMoreThanX(nums, target, false));
	}

}
