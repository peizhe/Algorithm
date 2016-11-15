package Leetcode;

public class PlusOne {
	public int[] plusOne(int[] digits) {
		int len = digits.length;
		int[] result;
		digits[len - 1] = digits[len - 1] + 1;
		if(digits[len - 1] < 10) {
			return digits;
		}
		
		for(int i = digits.length - 1;i >= 0;i --) {
			int temp = digits[i];
        	if(temp >= 10 && i > 0) {
    		    digits[i] = temp % 10;
    			digits[i - 1] ++;
        	} else{
        		digits[i] = temp;
        	}
        }
		
        if(digits[0] >= 10) {
        	digits[0] = digits[0] % 10;
        	result = new int[len + 1];
        	result[0] = 1;
        	System.arraycopy(digits, 0, result, 1, len);
        	return result;
        }
        else {
        	return digits;
        }
	}
        
	public static void main(String[] mh) {
		int[] a = {1,0};
		int[] res;
		PlusOne po = new PlusOne();
		res = po.plusOne(a);
		for(int i : res) {
			System.out.print(i + " ");
		}
	}
}
