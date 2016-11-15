package Leetcode;
/**
 * 实践证明，函数的参数不应该写太多,会拖慢时间
 * 
 * @author MG
 *
 */
public class WordSearch79 {
	public boolean exist(char[][] board, String word) {
        if(board == null){
        	return false;
        }
        
        if(word == null || word.length() == 0){
        	return true;
        }
        
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
        	for(int j = 0; j < col; j++){
        		if(backTracking(board, i, j, word, 0))  return true;
        	}
        }
        
        return false;
    }
	
	private boolean backTracking(char[][] board, int currentRow, int currentCol, String word, int position){
		if(position >= word.length()){
			return true;
		}
		
		if(currentRow < 0 || currentRow >= board.length || currentCol < 0 || currentCol >= board[0].length){
			return false;
		}
		
		if(board[currentRow][currentCol] == word.charAt(position)){
			//这个是精髓(把这个字符异或后将  > 256,将和其他字符不同,标记已访问该位置字符)
			board[currentRow][currentCol] ^= 256;
			
			boolean top = backTracking(board, currentRow - 1, currentCol, word, position + 1);
			if(top){
				return true;
			}
			
			boolean down = backTracking(board, currentRow + 1, currentCol, word, position + 1);
			if(down){
				return true;
			}
			
			boolean left = backTracking(board, currentRow, currentCol - 1, word, position + 1);
			if(left){
				return true;
			}
			
			boolean right = backTracking(board, currentRow, currentCol + 1, word, position + 1);
			if(right){
				return true;
			}
			
			board[currentRow][currentCol] ^= 256;
		}
		
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
