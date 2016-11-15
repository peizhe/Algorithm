package LeetCodeSecondEasy;

public class ReverseInteger7 {
	public int reverse(int x) {
        long res = 0;
        
        while(x != 0){
        	res *= 10 ;
        	res += x % 10;
        	x /= 10;
        }
        
        if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE){
        	return 0;
        }
        
        return (int)res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
