package LeetCodeSecondMedium;

public class ValidPerfectSquare367 {
	public boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        
        int begin = 1, end = num;
        while(begin <= end) {
        	int mid = begin + ((end - begin) >> 1);
        	
        	if(Integer.MAX_VALUE / mid < mid) {
        		end = mid - 1;
        		continue;
        	}
        	
        	int x = mid * mid;
        	if(x == num) return true;
        	else if(x > num) {
        		end = mid - 1;
        	} else {
        		begin = mid + 1;
        	}
        }
        
        return false;
    }
}
