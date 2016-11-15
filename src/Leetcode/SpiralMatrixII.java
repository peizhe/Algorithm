package Leetcode;
/**
 * 这个题和SpiralMatrix思路一模一样
 * @author mh
 *
 */
public class SpiralMatrixII {
	
	public int[][] generateMatrix(int n) {
		if(n < 0){
			return null;
		}
		if(n == 0){
			return new int[0][0];
		}
		int[][] result = new int[n][n];
		int num = 1;
		  
	    int left,top,right,down;  
	    left = top = 0;
	    right = down = result.length - 1;  
	    while(left <= right && top <= down){ 
	    	//left---->right
	        for(int i = left;i <= right;i ++){  
	            result[left][i] = num;
	            num ++;
	        }  
	        
	        //top---->down 
	        for(int j = top + 1;j <= down;j ++){ 
	            result[j][right] = num;
	            num ++;
	        }  
  
        	//right---->left 
            for(int i = right - 1;i >= left;i --){ 
                result[right][i] = num;
                num ++;
            }   
	       
        	//down---->top  
            for(int j = down - 1;j > top;j --){  
                result[j][top] = num;
                num ++;
            }  
	        
	        left ++; 
	        top ++; 
	        right --;
	        down --;  
	    }
	    
	    return result;
    }
}
