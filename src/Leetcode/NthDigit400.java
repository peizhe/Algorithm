package Leetcode;

public class NthDigit400 {
	
	/**
	 * 
	 * 这种办法真的巧
	 * 
	 * @param n
	 * @return
	 */
	public static int findNthDigitBetter(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		
		return s.charAt((n - 1) % len) - '0';
    }
	
	/**
	 * 这个一种方法，但是超时了
	 * @param n
	 * @return
	 */
	public int findNthDigit(int n) {
        if(n < 10){
        	return n;
        }
        
        StringBuilder sb = new StringBuilder();
        int i = 1;
        while(sb.length() < n){
        	sb.append(i ++);
        }
        
        return sb.charAt(n - 1) - '0';
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findNthDigitBetter(11));
	}

}
