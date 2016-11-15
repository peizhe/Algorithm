package Leetcode;

public class DecodeWays91 {
	public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0'){
        	return 0;
        }
        
        int len = s.length();
        if(len == 1){
        	return 1;
        }
        
        int[] dp = new int[len];
        dp[0] = 1;
        if(s.charAt(1) == '0'){
        	if ((s.charAt(0) - '0') > 2) return 0;
        	
        	else dp[1] = 1;
        } else {
        	dp[1] = ((s.charAt(0) - '0') * 10 + s.charAt(1) - '0') > 26 ? 1 : 2;
        }
        
        int pre, current, val;
        for(int i = 2;i < len;i ++){
        	pre = s.charAt(i - 1) - '0';
        	current = s.charAt(i) - '0';
        	val = pre * 10 + current;
        	
        	if(current == 0){
        		if(val > 26 || val == 0){
        			return 0;
        		} else {
        			dp[i] = dp[i - 2];
        		}
        	} else {
        		if(pre == 0){
        			dp[i] = dp[i - 1];
        		} else {
        			if(val > 0 && val <= 26){
    	        		dp[i] = dp[i - 2] + dp[i - 1];
    	        	} else {
    	        		dp[i] = dp[i - 1];
    	        	}
        		}
        	}
        }
        
        return dp[len - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numDecodings("10"));
	}

}
