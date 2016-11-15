package Leetcode;

public class FirstMissingPositive {
	
	public int firstMissingPositive(int[] nums) {
		return 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FirstMissingPositive f = (FirstMissingPositive)Class.forName("leetcode.FirstMissingPositive").newInstance();
			
			int[] nums = {3};
			System.out.println(f.firstMissingPositive(nums));
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
