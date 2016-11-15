package LeetCodeSecondMedium;

public class UniquePaths62 {
	//虽然快但是结果不准确(如果要求必须O(n),则先填充一个质数数组)
	public static int uniquePaths(int x, int y) {
		double sum = x + y - 2,min = Math.min(x - 1, y - 1);
		
		double count = 1;
		for(int i = 1;i <= min;i ++){
			count *= (sum - i + 1) / (min - i + 1);
		}
		
		return (int)count;
    }
	
	public static int uniquePaths2(int x, int y) {
		if(x < 1 || y < 1){
			return 0;
		}
		int[][] map = new int[x][y];
		
		for(int i = 0;i < x;i ++){
			map[i][0] = 1;
		}
		
		for(int i = 0;i < y;i ++){
			map[0][i] = 1;
		}
		
		for(int i = 1;i < x;i ++){
			for(int j = 1;j < y;j ++){
				map[i][j] = map[i - 1][j] + map[i][j - 1];
			}
		}
		
		return map[x - 1][y - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(9,8));
	}

}
