package Interview;
/**
 * 求前N个数的最大奇约数之和
 * 	1.动态规划(内存消耗大)
 * 	2.奇数相加，每个偶数右移1直到最低位不为0(不消耗内存，时间复杂度不能达到O(n))
 * @author MG
 *
 */
public class SumMaxOdd {
	public int sumMax(int n){
		int[] map = new int[n + 1];
		int sum = 1;
		map[1] = 1;
		
		for(int i = 2;i <= n;i ++){
			if((i & 1) == 0){
				map[i] = map[i / 2];
			} else{
				map[i] = i;
			}
			
			sum += map[i];
		}

		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
