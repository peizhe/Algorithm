package Algorithm;

/**
 * function:弗洛伊德算法计算两点间的最短距离以及这条路径上的点
 * 			Dijkstra算法是计算单点开始到其他点的最短距离
 * @author mh
 * 
 */
public class FloydWarshall {
	private static int[][] path;
	
	public static void floyd(int[][] distance, int n) {
		// 时间复杂度为O(n^3)
		// n代表点的数量，distance[i][j]代表i，j两点的距离（直接相连）
		// distance数组中distance[i][i]为0，如果i，j不连通，distance[i][j]赋值为最大值
		// k代表中间的节点，i代表开始节点，j代表终止节点

		// floyd方法不但可以计算任意两点间的距离，还可以记录两点间最短距离的路径(不需要记录路径，则直接去掉与Path有关的语句)
		for (int k = 0; k < n;k ++) {
			for (int i = 0; i < n;i ++) {
				for (int j = 0; j < n; j++) {
					if (distance[i][k] + distance[k][j] < distance[i][j]) {
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = k;
					}
				}
			}
		}
	}

	//输出i到j的路径
	private static void output(int i, int j) {
		if (i == j)
			return;
		if (path[i][j] == 0)
			System.out.print(j + " ");
		else {
			output(i, path[i][j]);
			output(path[i][j], j);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int u = 0, v = 8;
		int count = 8;
		int[][] dist = new int[count][count];
		floyd(dist,count);
		
		while (u < count && v < count) {
			if (dist[u][v] == Integer.MAX_VALUE) {
				System.out.println("no path!");
			} 
			else {
				System.out.print(u + " ");
				output(u, v);
			}
		}
	}
}
