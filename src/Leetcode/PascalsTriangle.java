package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
	
	public static List<List<Integer>> generate(int numRows) {
		int[][] temp = new int[numRows][numRows];
		
		for(int i = 0;i < numRows;i ++){
			temp[i][0] = 1;
			temp[i][i] = 1;
		}
		
		for(int i = 2;i < temp.length;i ++){
			for(int j = 1;j < i;j ++){
				temp[i][j] = temp[i - 1][j - 1] + temp[i - 1][j];
			}
		}
		
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tempList = new ArrayList<Integer>();
        for(int i = 0;i < numRows;i ++){
        	for(int j = 0;j <= i;j ++){
        		tempList.add(temp[i][j]);
        	}
        	result.add(tempList);
        	tempList = new ArrayList<Integer>();
        }
        
		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generate(1);
	}
}
