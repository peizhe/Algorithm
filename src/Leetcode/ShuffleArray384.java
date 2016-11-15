package Leetcode;

import java.util.Random;

public class ShuffleArray384 {
	int[] original;
	private Random random;
	
	public ShuffleArray384(int[] nums){
		original = nums;
		random = new Random();
	}
	
	/** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if(original == null) return null;
    	
    	int len = original.length;
        int[] res = original.clone();
        for(int j = 1;j < len;j ++) {
            int i = random.nextInt(j + 1);
            swap(res, i, j);
        }
        
        return res;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
