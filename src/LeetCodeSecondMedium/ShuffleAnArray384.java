package LeetCodeSecondMedium;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ShuffleAnArray384 {
	private int[] originNumber;
	private Random random;
	private List<Integer> list;
	
	public ShuffleAnArray384(int[] nums) {
        originNumber = nums;
        random = new Random();
        list = new LinkedList<Integer>();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originNumber;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	if(originNumber.length == 0) {
        	return originNumber;
        }
    	
        int[] res = new int[originNumber.length];
        
        for(int x : originNumber) {
        	list.add(x);
        }
        
        for(int i = 0; i < originNumber.length; i++) {
        	int index = random.nextInt(list.size());
        	res[i] = list.remove(index);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
