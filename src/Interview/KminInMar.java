package Interview;

import java.util.Arrays;

public class KminInMar {
	// ±º‰∏¥‘”∂»O(km)
	public static int kmin(int m,int n,int k){
		int[] res = new int[k];
		long[] assist = new long[m + 1];
		Arrays.fill(assist, 1);
		
		for(int i = 0;i < res.length;i ++){
			long temp = Integer.MAX_VALUE;
			int index = 1;
			
			for(int j = 1;j <= m;j ++){
				if(assist[j] * j < temp){
					temp = assist[j] * j;
					index = j;
				}
			}
			
			if(assist[index] < n){
				assist[index] ++;
			}
			else{
				assist[index] = Integer.MAX_VALUE;
			}
			
			res[i] = (int)temp;
		}
				
		return res[k - 1];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 3,n = 4,k = 12;
		System.out.println(kmin(m, n, k));
	}
}
