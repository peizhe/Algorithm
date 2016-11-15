package LeetCodeSecondMedium;

public class CountNumbersWithUniqueDigits357 {
	public static int countNumbersWithUniqueDigits(int n) {
        
        if(n == 0){
        	return 1;
        } else if(n == 1){
        	return 10;
        } else if(n > 10){
        	n = 10;
        }
        
        int res = 10;
        int single = 9;
        int i = 2;
        while(i <= n){
        	single *=  (11 - i);
        	res += single;
        	i ++;
        }
        
        return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countNumbersWithUniqueDigits(3));
	}

}
