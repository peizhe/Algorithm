package LeetCodeSecondEasy;

public class FirstBadVersion278 {
	public int firstBadVersion(int n) {
        int begin = 0,end = n;
        while(begin < end){
        	int mid = begin + (end - begin) / 2;
        	if(isBadVersion(mid)){
        		end = mid - 1;
        	} else{
        		begin = mid + 1;
        	}
        }
        
        return isBadVersion(begin) ? begin : begin + 1;
    }
	
	private boolean isBadVersion(int version){
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
