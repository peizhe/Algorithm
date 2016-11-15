package HihoCoder;

/**
 * 欧拉函数f(n):计算<=n的与n互质的数的个数
 * f(x) = x(1-1/p1)(1-1/p2)(1-1/p3)(1-1/p4)…(1-1/pn),其中p1,p2……pn为x的所有素因数
 * 
 * 若m,n互质,f(m * n) = f(m) * f(n)
 * 特殊性质：当n为奇数时 f(2 * n) = f(n), 证明与上述类似。
 * 若n为质数则f(n) = n - 1 
 * 
 * @author MG
 *
 */
public class ElurFunction1298 {
	
	public static int getElur(int L,int R){
        int res = Integer.MAX_VALUE;
        int resIndex = R;
        
		int[] values = new int[R + 1];
		values[1] = 1;
		//公式中x*(1 - 1/p1)...中的x
		for(int i = 2;i <= R; i++) {
			values[i] = i;
		}
		
		for(int i = 2; i <= R; i++){
			//values[i] == i : 证明i为质数
			if(values[i] == i){
				//后面每个都有i这个质因数
				for(int j = i; j <= R; j += i){
					//先做除法是防止越界
					values[j] = values[j] / i * (i - 1);
				}
			}
			
			if(i >= L && values[i] < res){
			    res = values[i];
			    resIndex = i;
			}
		}
		
		return resIndex;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
