package Leetcode;
/**
 * 好好想想这个算法，一种思想
 * @author Administrator
 *
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int len = primes.length;
		//存储primes中每个质数的下标（相当于是len个指针，每个指针的下标都是从0开始）
        int[] index = new int[len];
        //存储结果数字
        int[] result = new int[n];
        result[0] = 1;
        
        if(n <= 1){
        	return result[0];
        }
        
        for(int i = 1;i < n;i ++){
        	//下面这段求最小值的代码
        	int min = Integer.MAX_VALUE;
        	for(int j = 0;j < len;j ++){
        		//primes[j]这个质数对应的指针位置为index[j]，拿到index[j]处的result结果
        		min = Math.min(min, primes[j] * result[index[j]]);
        	}
        	result[i] = min;
        	//这里可能会出现重复的结果 14 = 2 * 7 = 7 * 2，则将2 和 7对应的index均加1
        	for(int k = 0;k < len;k ++){
        		//所有符合条件的，都需增加对应prime的index, 避免重复
        		if(min % primes[k] == 0){
        			index[k] ++;
        		}
        	}
        }
        
        return result[n - 1];
    }
}
