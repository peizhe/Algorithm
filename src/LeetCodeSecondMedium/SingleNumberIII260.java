package LeetCodeSecondMedium;
/**
 * res = x ^ -x;结果为x的二进制表示中最低不为0的那一位
 * 	当x为奇数时：res = -2；
 * 		-3 ^ 3 = -2,-1 ^ 1 = -2
 * 	当x为偶数时：res = -(x的因数中最大的2的幂的2倍)
 * 		-2 ^ 2 = -4,-6 ^ 6 = -4,-12 ^ 12 = -8;
 * @author MG
 *
 */
public class SingleNumberIII260 {
	public int[] singleNumber(int[] nums) {
		if(nums == null || nums.length < 2){
			return new int[2];
		}
		int[] res = new int[2];
		
        int xor = 0;
        for(int n : nums){
        	xor ^= n;
        }
        
        int finalDiffBit = xor & -xor;
        int a = 0,b = 0;
        for(int n : nums){
        	if((n & finalDiffBit) == 0){
        		a ^= n;
        	} else{
        		b ^= n;
        	}
        }
        
        res[0] = a;
        res[1] = b;
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
