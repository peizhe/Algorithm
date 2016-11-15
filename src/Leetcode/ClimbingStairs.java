package Leetcode;

public class ClimbingStairs {
	//(�ݹ�)�˷������ԣ�����ʱ�临�Ӷȸ�
	public static int climbStairs(int n) {
		if(n <= 2){
			return n;
		}
		else{
			return climbStairs(n - 1) + climbStairs(n - 2);
		}
    }
	
	//�ǵݹ�ķ���
	public static int climbStairs1(int n) {
		if(n <= 2){
			return n;
		}
		int result = 0;
		int pre = 1,current = 2;
		for(int i = 3;i <= n;i ++){
			//�������Ƚ���Ҫ
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
