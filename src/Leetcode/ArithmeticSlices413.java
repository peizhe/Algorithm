package Leetcode;

public class ArithmeticSlices413 {
	public static int numberOfArithmeticSlices(int[] A) {
        if(A == null || A.length == 0){
        	return 0;
        }
		
        int len = A.length;
        
        int[] diff = new int[len];
        diff[0] = 0;
        for(int i = 1;i < len;i ++){
        	diff[i] = A[i] - A[i - 1];
        }
        
        int count = 0;
        int sameLen = 1;
        
        for(int i = 2;i < len;i ++){
        	if(diff[i] == diff[i - 1]){
        		sameLen ++;
        	} else {
        		count += sameLen * (sameLen - 1) >> 1;
        		sameLen = 1;
        	}
        }
        
		return count += sameLen * (sameLen - 1) >> 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] mh) {
		// TODO Auto-generated method stub
		int[] A = new int[]{1,2,3,4,6,8,9,10};
		System.out.println(numberOfArithmeticSlices(A));
	}

}
