package LeetCodeSecondMedium;

public class TwoSumIIInputArrayIsSorted167 {
	
	public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
        	return new int[]{};
        }
        
        int begin = 0, end = numbers.length - 1;
        while(begin < end) {
        	int temp = numbers[begin] + numbers[end];
        	if(temp == target) {
        		return new int[]{begin, end};
        	} else if(temp > target) {
        		end --;
        	} else {
        		begin ++;
        	}
        }
        
        return new int[]{};
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
