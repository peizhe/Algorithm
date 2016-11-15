package Leetcode;
/**
 * 翻转整数的二进制时，可以不用先求出二进制再进行翻转，
 * 直接利用移位运算符即可
 * @author MG
 *
 */
public class ReverseBits {
	
	public static int reverseBits(int y) {
		int INT_SIZE = Integer.SIZE;  
		  
        for (int i = 0; i < INT_SIZE / 2; i++) {  
            int j = INT_SIZE - 1 - i;  
  
            int low = (y >> i) & 1;  
            int high = (y >> j) & 1;   
            
            //只有交换位置数不同才交换，这里交换的方式是异或
            if ((high ^ low) == 1) {  
                y  ^= (1 << i | 1 << j);  
            }  
        }  
        return y;
    }
}
