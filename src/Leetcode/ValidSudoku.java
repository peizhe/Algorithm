package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {
	
	Map<Integer,Character> map = new HashMap<Integer, Character>();
	public boolean isValidSudoku(char[][] board) {
		boolean result = true;
		
		//每一行
		for(int i = 0;i < 9;i ++){
			initMap();
			for(int j = 0;j < 9;j ++){
				if(board[i][j] != '.'){
					if(map.containsValue(board[i][j])){
						return false;
					}
					else{
						map.put(j, board[i][j]);
					}
				}
			}
		}
		
		//每一列
		for(int i = 0;i < 9;i ++){
			initMap();
			for(int j = 0;j < 9;j ++){
				if(board[j][i] != '.'){
					if(map.containsValue(board[j][i])){
						return false;
					}
					else{
						map.put(j, board[j][i]);
					}
				}
			}
		}
		
		
		//判断每一个9宫格
		for(int k = 0;k < 3;k ++){
			for(int m = 0;m < 3;m ++){
				initMap();
				int count = 0;
				for(int i = 3 * k;i < 3 * k + 3;i ++){
					for(int j = 3 * m;j < 3 * m + 3;j ++){
						if(board[i][j] != '.'){
							if(map.containsValue(board[i][j])){
								return false;
							}
							else{
								map.put(count ++ , board[i][j]);
							}
						}
					}
				}
			}
		}
		
		
		return result;
    }
	
	public void initMap(){
		map = new HashMap<Integer, Character>();
	}
}
