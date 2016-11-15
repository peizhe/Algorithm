package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {

	public static List<Integer> getRow(int rowIndex) {
		rowIndex = rowIndex + 1;
		int[][] temp = new int[rowIndex][rowIndex];
		
		for(int i = 0;i < rowIndex;i ++){
			temp[i][0] = 1;
			temp[i][i] = 1;
		}
		
		for(int i = 2;i < temp.length;i ++){
			for(int j = 1;j < i;j ++){
				temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j];
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		
    	for(int j = 0;j < rowIndex;j ++){
    		result.add(temp[rowIndex - 1][j]);
    	}
        
    	for(int i = 0;i < result.size();i ++){
    		System.out.print(result.get(i) + " ");
    	}
		return result;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getRow(1);
	}

}
