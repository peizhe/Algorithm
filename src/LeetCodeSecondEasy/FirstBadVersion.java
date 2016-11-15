package LeetCodeSecondEasy;

public class FirstBadVersion {
	public int firstBadVersion(int n) {
	    int start = 1, end = n;
	    while (start < end) {
	        int mid = start + (end - start) / 2;
	        if (!isBadVersion(mid)) start = mid + 1;
	        else end = mid;            
	    }        
	    return start;
	}
	
	private boolean isBadVersion(int n){
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
