package Leetcode;
/**
 * 数列的计算：
 * 	需要依赖数学公式，列出前几项会更加容易解决问题
 * @author MG
 *
 */
public class RotateFunction396 {
	public static int maxRotateFunction(int[] A) {
		if(A == null || A.length == 0){
			return 0;
		}
		int len = A.length;
		int f0 = 0,sum = 0;
		
		for(int i = 0;i < len;i ++){
			f0 += i * A[i];
			sum += A[i];
		}
		
		int res = f0;
		for(int i = 1;i < len;i ++){
			int ftemp = f0 + sum - len * A[len - i];
			
			res = ftemp > res ? ftemp : res;
			
			f0 = ftemp;
		}
		
		return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{4,3,2,6};
		System.out.println(maxRotateFunction(A));
	}
}
