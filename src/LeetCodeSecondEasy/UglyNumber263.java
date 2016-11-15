package LeetCodeSecondEasy;

public class UglyNumber263 {
	public boolean isUgly(int num) {
		if(num <= 0){
			return false;
		}
		
        while(num % 2 == 0){
        	num >>= 1;
        }
        
        while(num % 3 == 0){
        	num /= 3;
        }
        
        while(num % 5 == 0){
        	num /= 5;
        }
        
        return num == 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
