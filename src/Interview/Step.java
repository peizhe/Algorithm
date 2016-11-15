package Interview;

public class Step {
	public static void main(String[] mh){
		
		int[] nums = new int[32];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 4;
		for(int i = 3;i < nums.length;i ++){
			nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
		}
		
		System.out.println(nums[31]);
		
	}
}
