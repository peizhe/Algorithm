package LeetCodeSecondEasy;

/**
 * ͳ��С��n�������ĸ�����
 * 	1.һ��һ���ж��Ƿ�Ϊ����(�����)
 * 	2.����ɸѡ��(��ס���еļ���Ҫ�㣡)
 * 	3.����ɸѡ��������
  		��x�R1��n=6x-1��n=6x+1������������ônһ������2��3�ı�����
		֤����
			��n=6x-1��n=6x+1����n=2(3x)-1��n=2(3x)+1��n=3(2x)-1��n=3(2x)+1��
			��nһ������2��3�ı�����
		��ɸѡ�����иĽ���ֻ�ж�6x���������
 * @author MG
 *
 */
public class CountPrimes204 {
	public static int countPrimesBest(int n) {
		if (n < 3)
            return 0;
            
        boolean[] f = new boolean[n];
        
        //�Զ���ȥ�˳�2����ż��
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
        
        //��¼�Ƿ�Ϊ����������ΪFalse
        boolean[] notPrime = new boolean[n];
        notPrime[0] = notPrime[1] = true;
        
        int count = 0;
        int i,j;
        //��2����ż��ȫΪ������
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
