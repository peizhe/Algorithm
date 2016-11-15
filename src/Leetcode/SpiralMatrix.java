package Leetcode;
/**
 * 就是操作麻烦，思路很简单，从外向内一圈一圈访问
 */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();  
		//(left,top)代表左上角，(right,down)代表左下角
	    int left = 0;  
	    int top = 0;  
	    int down = matrix.length - 1;  
	    if(down < 0) {
	    	return result;
	    }  
	    int right = matrix[0].length - 1;  
	    while(left <= right && top <= down){ 
	    	//left---->right
	        for(int i = left;i <= right;i ++){  
	        	result.add(matrix[top][i]); 
	        } 
	        
	        //top---->down 
	        for(int j = top + 1;j <= down;j ++){ 
	        	result.add(matrix[j][right]);
	        }
	        
	        //避免重复访问
	        if(top != down){  
	        	//right---->left 
	            for(int i = right - 1;i >= left;i --){ 
	            	result.add(matrix[down][i]); 
	            } 
	        }  
	        //避免重复访问
	        if(left != right){
	        	//down---->top  
	            for(int j = down - 1;j > top;j --){  
	            	result.add(matrix[j][left]);
	            } 
	        } 
	        
	        left++; 
	        top++; 
	        right--;
	        down--;  
	    }  
	    return result;  
    }
}
