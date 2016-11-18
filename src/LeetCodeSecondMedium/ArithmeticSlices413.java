package LeetCodeSecondMedium;

public class ArithmeticSlices413 {
	public int numberOfArithmeticSlices(int[] A) {
		if(A == null || A.length == 0) {
			return 0;
		}
		
		int len = A.length;
        int[] diff = new int[len];
        for(int i = 1; i < len; i++) {
        	diff[i] = A[i] - A[i - 1];
        }
        
        int res = 0;
        int begin = 1;
        for(int i = 2; i < len; i++) {
        	if(diff[i] != diff[begin]) {
        		if(i - begin >= 2) res += getCount(i - begin + 1);
        		
        		begin = i;
        	}
        }
        
        if(len - begin >= 2) res += getCount(len - begin + 1);
        
        return res;
    }
	
	/**
	 * 等差数列长度为n时的序列个数
	 * 
	 * @param n
	 * @return
	 */
	private int getCount(int n) {
		return (n - 2) * (n - 1) >> 1;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
