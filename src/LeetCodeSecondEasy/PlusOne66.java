package LeetCodeSecondEasy;


public class PlusOne66 {
	public int[] plusOne(int[] digits) {
		if(digits == null || digits.length == 0){
			return new int[]{};
		}
		int carry = 0;
		int length = digits.length;
		
		digits[length - 1] += 1;
		
        for(int i = length - 1;i >= 0;i --){
        	int temp = digits[i] += carry;
    		digits[i] %= 10;
        	carry = temp / 10;
        }
        
        if(carry == 1){
        	int[] res = new int[length + 1];
        	res[0] = 1;
        	System.arraycopy(digits, 0, res, 1, length);
        	
        	return res;
        }
        
        return digits;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
