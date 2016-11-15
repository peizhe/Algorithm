package Interview;

import java.util.Arrays;
//求解1000以内和为某一个数的数据对数量
public class PrimePairsCount {
	
	//得到小于n的所有质数
	public static boolean[] getPrimes(int n){
		boolean[] flags = new boolean[n];
		Arrays.fill(flags, true);
		
		for(int i = 0;i < n;i += 2){
			flags[i] = false;
		}
		flags[1] = false;
		flags[2] = true;
		
		for(int i = 3;i * i < n;i += 2){
			for(int j = i * i;j < n;j += i){
				flags[j] = false;
			}
		}
				
		return flags;
	}
	
	public static int getPrimesPairs(int n, int target){
		boolean[] flags = getPrimes(n);
		int count = 0;
		int begin = 2, end = n - 1;
		
		while(begin < end){
			while(!flags[begin] && begin < end){
				begin ++;
			}
			
			while(!flags[end] && begin < end){
				end --;
			}
			
			int temp = begin + end;
			if(temp > target){
				end --;
			} else if(temp < target){
				begin ++;
			} else {
				count ++;
				begin ++;
				end --;
			}
		}
		
		return count;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPrimesPairs(20, 20));
	}
}
