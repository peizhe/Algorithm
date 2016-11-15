package LeetCodeSecondMedium;

public class CountingBits338 {
	public int[] countBits(int num) {      
        int[] res = new int[num + 1];
        
        res[0] = 0;
        if(num == 0){
        	return res;
        }
        
        res[1] = 1;
        if(num == 1){
        	return res;
        }
        
        for(int i = 2;i <= num;i ++){
        	res[i] = res[i / 2] + res[i % 2];
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
