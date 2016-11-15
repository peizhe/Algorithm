package LeetCodeSecondMedium;
/**
 * 数组中只有一个元素出现1次,其他都出现3次，找出出现一次的元素
 * 	1.根据位运算进行计算
 * 	2.更屌的方法()
 * @author MG
 *
 */
public class SingleNumberII137 {
	public int singleNumber(int[] A) {
		if(A == null || A.length < 1){
			return -1;
		}
		
		int len = A.length;
		int res = 0;
		int[] map = new int[32];
		for(int i = 0;i < 32;i ++){
			for(int j = 0;j < len;j ++){
				map[i] += (A[j] >> i) & 1;
			}
			map[i] %= 3;
			
			res |= map[i] << i;
		}
		
		return res;
	}
	
	public int singleNumberBetter(int[] A) {
	    int ones = 0, twos = 0;
	    for(int i = 0; i < A.length; i++){
	        ones = (ones ^ A[i]) & ~twos;
	        twos = (twos ^ A[i]) & ~ones;
	    }
	    
	    return ones;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
