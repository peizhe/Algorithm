package Leetcode;

public class GuessNumberHigherLower374 {
	public int guessNumber(int n) {
        int begin = 1,end = n,mid,tempRes;
        while(begin < end){
        	mid = begin + (end - begin) / 2;
        	tempRes = guess(mid);
        	if(tempRes == 0){
        		return mid;
        	} else if(tempRes == -1){
        		end = mid - 1;
        	} else{
        		begin = mid + 1;
        	}
        }
        
        return begin;
    }
	
	public int guess(int x){
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
