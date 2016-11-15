package LeetCodeSecondMedium;

public class UniqueBinarySearchTrees96 {
	public int numTrees(int n) {
        if(n < 1){
        	return 0;
        }
        
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2;i <= n;i ++){
        	int sum = 0;
        	for(int j = 0;j < i;j ++){
        		sum += res[j] * res[i - 1 - j];
        	}
        	res[i] = sum;
        }
        
        return res[n];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
