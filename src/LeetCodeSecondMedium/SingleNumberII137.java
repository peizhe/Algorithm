package LeetCodeSecondMedium;
/**
 * ������ֻ��һ��Ԫ�س���1��,����������3�Σ��ҳ�����һ�ε�Ԫ��
 * 	1.����λ������м���
 * 	2.���ŵķ���()
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
