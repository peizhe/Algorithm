package NiuKe;

/**
 * 
 * 
 * @author Administrator
 *
 */
public class JumpFloor {
	
	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * @param target
	 * @return
	 */
	public static int JumpFloorI(int target) {
        if(target <= 0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else {
            int res = 0, first = 1, second = 2;
            for(int i = 3; i <= target; i++) {
                res = first + second;
                first = second;
                second = res;
            }
            
            return res;
        }
    }
	
	/**
	 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * @param target
	 * @return
	 */
	public static int JumpFloorII(int target) {
        if(target <= 0) return 0;
        else if(target == 1) return 1;
        else if(target == 2) return 2;
        else {
            int res = 0, sum = 3;
            for(int i = 3; i <= target; i++) {
                res = sum + 1;
                sum += res;
            }
            
            return res;
        }
    }
	
	public static void main(String[] mh){
		
	}
}
