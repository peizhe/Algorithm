package Leetcode;
/**
 * ���ǲ����鷳��˼·�ܼ򵥣���������һȦһȦ����
 */
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();  
		//(left,top)�������Ͻǣ�(right,down)�������½�
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
	        
	        //�����ظ�����
	        if(top != down){  
	        	//right---->left 
	            for(int i = right - 1;i >= left;i --){ 
	            	result.add(matrix[down][i]); 
	            } 
	        }  
	        //�����ظ�����
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
