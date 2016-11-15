package Interview;

public class MaxSum {
	public static int maxSum(int[] a){
		if(a == null || a.length == 0){
			return 0;
		}
		int count = 0,max = Integer.MIN_VALUE;
		int sum = 0,len = a.length;
		int res = Integer.MIN_VALUE;
		
		for(int i = 0;i < len;i ++){
			if(a[i] < 0) 
	            count ++;  
	        if(max < a[i])
	            max = a[i];
	        
			sum += a[i];
			if(sum > res){
				res = sum;
			} 
			
			if(sum < 0){
				sum = 0;
			}
		}
		
		if(count == len){
			return max;
		}
		
		return res;
	}
	
	public static void main(String[] mh){
		int[] a = new int[]{-1,-2,-4};
		System.out.println(maxSum(a));
	}
}
