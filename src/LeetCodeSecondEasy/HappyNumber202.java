package LeetCodeSecondEasy;
/**
 * 这个题关键在于6这个数怎么得来的:
 * 	 这个题网友写的挺精髓的！运用到了一些数学的结论！
 *  通过这道题的内层循环书写，以后类似的要这样书写代码
 * @author MG
 *
 */
public class HappyNumber202 {
	public boolean isHappy(int n) {
        while(n > 6){
        	int next = 0;
        	while(n > 0){
        		next += (n % 10) * (n % 10);
        		n /= 10;
        	}
        	n = next;
        }
        
        return n == 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
