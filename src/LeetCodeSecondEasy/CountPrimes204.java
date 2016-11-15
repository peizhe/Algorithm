package LeetCodeSecondEasy;

/**
 * 统计小于n的素数的个数：
 * 	1.一个一个判断是否为素数(最笨方法)
 * 	2.质数筛选法(记住其中的几个要点！)
 * 	3.质数筛选法升级版
  		若x≧1且n=6x-1或n=6x+1不是素数，那么n一定不是2和3的倍数。
		证明：
			∵n=6x-1或n=6x+1，即n=2(3x)-1或n=2(3x)+1或n=3(2x)-1或n=3(2x)+1。
			∴n一定不是2和3的倍数。
		将筛选法进行改进，只判断6x两侧的数。
 * @author MG
 *
 */
public class CountPrimes204 {
	public static int countPrimesBest(int n) {
		if (n < 3)
            return 0;
            
        boolean[] f = new boolean[n];
        
        //自动略去了除2以外偶数
        int count = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (f[i])
                continue;
            
            for (int j = i * i; j < n; j += 2 * i) {
                if (!f[j]) {
                    -- count;
                    f[j] = true;
                }
            }
        }
        return count;
	}
	
	public static int countPrimesBetter(int n) {
		int i, j, count = 0;
		boolean[] notPrime = new boolean[n + 5];
		int[] increment = new int[]{0, 4, 0, 0, 0, 2}; 
		
	    for (i = 5; i * i < n; i += increment[i % 6]){  
	        for (j = i; i * j <= n; j += increment[j % 6]){  
	            notPrime[i * j] = true;
	        }  
	    }
	    
	    for(boolean b : notPrime){
        	if(!b){
        		count ++;
        	}
        }
	    
	    return count;
	}
	
	public static int countPrimes(int n) {
        if(n < 2){
        	return 0;
        }
        
        //记录是否为素数，素数为False
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        
        int count = 0;
        int i,j;
        //除2以外偶数全为非质数
        for(i = 4;i < n;i += 2){
        	notPrime[i] = true;
        }
        
        for(i = 3;i * i < n;i += 2){
        	if(!notPrime[i]){
        		for(j = i * i;j < n;j += 2 * i){
        			notPrime[j] = true;
                }
        	}
        }
        	
        for(boolean b : notPrime){
        	if(!b){
        		count ++;
        	}
        }
        
        return count;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(13));
	}

}
