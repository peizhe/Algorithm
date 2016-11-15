package Leetcode;
/**
 * ʵ��֤���������Ĳ�����Ӧ��д̫��,������ʱ��
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
			//����Ǿ���(������ַ�����  > 256,���������ַ���ͬ,����ѷ��ʸ�λ���ַ�)
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
