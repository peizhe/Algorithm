package LeetCodeSecondEasy;

/**
 * 同样的思想，要想办法把代码精简，是效率更高
 * @author MG
 *
 */
public class RangeSumQueryImmutable303 {
	int[] sum;
	public RangeSumQueryImmutable303(int[] nums) {
		if(nums == null || nums.length == 0){
			return;
		}
		
        sum = new int[nums.length + 1];
        int index = 0;
        for(int i : nums){
        	sum[index + 1] = sum[index ++] + i;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
