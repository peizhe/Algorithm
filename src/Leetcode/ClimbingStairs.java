package Leetcode;

public class ClimbingStairs {
	//(递归)此方法可以，但是时间复杂度高
	public static int climbStairs(int n) {
		if(n <= 2){
			return n;
		}
		else{
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
    }
	
	//非递归的方法
	public static int climbStairs1(int n) {
		if(n <= 2){
			return n;
		}
		int result = 0;
		int pre = 1,current = 2;
		for(int i = 3;i <= n;i ++){
			//这三步比较重要
			result = pre + current;
			pre = current;
			current = result;
		}
		
		return current;
    }
	
	/**
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		System.out.println(climbStairs(4));
	}
}
