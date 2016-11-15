package LeetCodeSecondEasy;

public class ClimbingStairs70 {
	public static int climbStairs(int n) {
		if(n <= 0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		
		if(n == 2){
			return 2;
		}
		int first = 1;
		int second = 2;
		int temp = 0;
        for(int i = 3;i <= n;i ++){
        	temp = first + second;
        	first = second;
        	second = temp;
        }
        
        return second;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(4));
	}

}
