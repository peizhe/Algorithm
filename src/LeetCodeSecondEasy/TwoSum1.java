package LeetCodeSecondEasy;

import java.util.Arrays;

/**
 * Ѱ����������������Ϊtarget���±�(�������ظ�Ԫ��)�� 1.����ѭ������(ʱ�临�Ӷ�O(n ^ 2),�ռ临�Ӷ�O(1))
 * 2.ʹ��map�洢�±�(��Ϊ����Ԫ�أ�ֵΪ�±�)������ͷβָ��ɨ�裬(ʱ�临�Ӷ�O(nlogn),�ռ临�Ӷ�O(n))
 * 3.���������˼�룬�洢�±�ֵ(ʱ�临�Ӷ�O(n),�ռ临�Ӷ�������Ԫ�طֲ��ܼ�����й�)
 * 4.�����������д��Ҳ�Ǽ��������˼�룬Ч�ʺܸ�(ʱ�临�Ӷ�O(n),�ռ临�Ӷȱȵ���������С�˺ܶ�)
 * 
 * @author MG
 * 
 */
public class TwoSum1 {
	public int[] twoSumBetter(int[] nums, int target) {
		// Since x1 + x2 = target, we can in one loop
		// mark both x1 and x2 in some additional array where we'll keep indices
		// Though to build that array we'd need another loop

		int min = 0, max = 0;
		// first loop to find max and min integers
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				min = nums[i];
				max = min;
			} else {
				if (nums[i] < min)
					min = nums[i];
				if (nums[i] > max)
					max = nums[i];
			}
		}
		// valid range for input integers relative to target
		int sMin = Math.max(min, target - max);
		int sMax = Math.min(max, target - min);

		// array to keep indices of valid input integers
		// initialize with -1
		int size = 1 + sMax - sMin;
		int[] arr = new int[size];
		Arrays.fill(arr, -1);

		// second loop
		int offset = -sMin;
		for (int i = 0; i < nums.length; i++) {
			// Skip if integer is not from a valid range
			if (nums[i] > sMax || nums[i] < sMin)
				continue;
			// if found valid X1 and corresponding element of indices array is
			// still -1
			// then mark its pair X2 = target - X1 in indices array
			if (arr[nums[i] + offset] == -1)
				arr[target - nums[i] + offset] = i;
			else
				return new int[] { arr[nums[i] + offset], i };
		}

		return new int[] { 0, 0 };
	}

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		int len = nums.length;

		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (target == nums[i] + nums[j]) {
					res[0] = i;
					res[1] = j;
					return res;
				}
			}
		}

		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
