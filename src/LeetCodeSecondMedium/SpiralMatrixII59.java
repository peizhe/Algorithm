package LeetCodeSecondMedium;

public class SpiralMatrixII59 {
	public static int[][] generateMatrix(int n) {
        if(n <= 0){
        	return new int[][]{};
        }
        int right = n - 1;
        int top = 0;
        int left = 0;
        int bottom = n - 1;
        int target = 1,max = n * n;
        int[][] res = new int[n][n];
        
        while(target <= max){
        	res[left][top] = target ++;
            //left----->right
            for(int i = left + 1;i <= right;i ++){
            	res[top][i] = target ++;
            }
            
            //top------>bottom
            for(int i = top + 1;i <= bottom;i ++){
            	res[i][right] = target ++;
            }
            
            //right----->left
            for(int i = right - 1;i >= left;i --){
            	res[bottom][i] = target ++;
            }
            
            //bottom---->top
            for(int i = bottom - 1;i > top;i --){
            	res[i][left] = target ++;
            }
            
            top ++;
            bottom --;
            left ++;
            right --;
        }
        
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] res = generateMatrix(5);
		for(int i = 0;i < res.length;i ++){
			for(int j = 0;j < res[i].length;j ++){
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

}
