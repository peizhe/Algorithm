package Interview;

public class CarStrategyCount {
	public static int getCount(int n){
		if(n < 1){
			return 0;
		}
		
		if(n == 1){
			return 1;
		} 
		
		if(n == 2){
			return 2;
		}
		
		if(n == 3){
			return 4;
		}
		
		int[] x = new int[n];
		x[0] = 1;
		x[1] = 2;
		x[2] = 4;
		
		for(int i = 3;i < n;i ++){
			x[i] = x[i - 1] + x[i - 2] + x[i - 3];
		}
		
		return x[n - 1];
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getCount(3));
	}
}
