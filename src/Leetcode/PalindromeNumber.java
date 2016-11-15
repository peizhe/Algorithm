package Leetcode;

public class PalindromeNumber {
	
	
	public static boolean isPalindrome(int x) {
        if(x < 0){
        	return false;
        }
        
        if(x >= 0 && x <= 9){
        	return true;
        }
       
        //div 是找到多少次方
        int div = 1;
        int temp = x / 10;
        while(temp / div > 0){
        	div *= 10;
        }
        
        while(x != 0){
        	int l = x / div;
        	int r = x % 10;
        	
        	if(l != r){
        		return false;
        	}
        	
        	x = (x % div) / 10;
        	div = div / 100;
        }
        
        return true;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(101));
	}
}
