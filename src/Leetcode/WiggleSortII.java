package Leetcode;

import java.util.Arrays;

public class WiggleSortII {
	
	public static final String name =  WiggleSortII.class.getName();
	
	public static void main(String[] mh){
		System.out.println(WiggleSortII.name);
	}
	
	
	//ʱ�� O(NlogN) �ռ� O(1)
	public void wiggleSort(int[] nums) {
        // �Ƚ���������
        Arrays.sort(nums);
        // ��������һ��һ�Խ���
        for(int i = 2; i < nums.length; i+=2){
            int tmp = nums[i-1];
            nums[i - 1] = nums[i];
            nums[i] = tmp;
        }
    }
	
	/**
	 * ʱ�� O(N) �ռ� O(1)
	 * ˼·:��Ŀ��ҡ������Ķ����������֣�
	 * ���i��������nums[i] >= nums[i - 1]
	 * ���i��ż����nums[i] <= nums[i - 1]
	 * ��������ֻҪ����һ�����飬�Ѳ����ϵ��������һ�¾����ˡ�
	 * ������˵�����nums[i] > nums[i - 1]�� �򽻻��Ժ�϶���nums[i] <= nums[i - 1]��
	 * @param nums
	 */
	public void wiggleSort1(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            // ��Ҫ���������������ʱnums[i] < nums[i - 1]��ż��ʱnums[i] > nums[i - 1]
            if((i % 2 == 1 && nums[i] < nums[i-1]) || (i % 2 == 0 && nums[i] > nums[i-1])){
                int tmp = nums[i-1];
                nums[i-1] = nums[i];
                nums[i] = tmp;
            }
        }
        
        for(int i = 0;i < nums.length - 1;i ++){
        	if((i & 1) == 0){
        		if(nums[i] >= nums[i + 1]){
        			System.out.println("no result");
        			break;
        		}
        	}
        	else{
        		if(nums[i] <= nums[i + 1]){
        			System.out.println("no res");
        			break;
        		}
        	}
        }
    }
}
