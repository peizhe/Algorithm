package Leetcode;

public class UglyNumber {
	
	public static boolean isUgly(int num) {
        if(num < 1){
        	return false;
        }
        if(num == 1){
        	return true;
        }
        
        while(num % 2 == 0){
        	num = num / 2; 
        }
        if(num == 1){
        	return true;
        }
        
        
        while(num % 3 == 0){
        	num = num / 3;
        }
        if(num == 1){
        	return true;
        }
        
        while(num % 5 == 0){
        	num = num /5;
        }
        if(num == 1){
        	return true;
        }
        
        
        return false;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isUgly(7));
	}

}
