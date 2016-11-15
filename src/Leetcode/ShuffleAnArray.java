package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * ע��ʹ��Random��������������
 * @author MG
 *
 */
public class ShuffleAnArray {
	int[] original;
	int len;
	List<Integer> temp;
	Random random;
	
    public ShuffleAnArray(int[] nums) {
        len = nums.length;
		original = nums;
		temp = new ArrayList<Integer>();
		random = new Random(); 
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] res = new int[len];
        
		for(int x : original){
			temp.add(x);
		}
		
		int i = 0,rd;
        for(;i < len;i ++){
        	rd = random.nextInt(temp.size());
        	res[i] = temp.remove(rd);
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
