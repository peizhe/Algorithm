package Leetcode;

public class TwoSumIISorted167 {
	public int[] twoSum(int[] numbers, int target) {
		int len = numbers.length;
		int[] res = new int[2];
        int begin = 0,end = len - 1,temp;
        while(begin < end){
        	temp = numbers[begin] + numbers[end];
        	
        	if(temp == target){
        		res[0] = begin + 1;
        		res[1] = end + 1;
        		return res;
        	} else if(temp > target){
        		end --;
        	} else{
        		begin ++;
        	}
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
