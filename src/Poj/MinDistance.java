package Poj;

//最小路径
public class MinDistance {
	public static void main(String[] mh) {
		int max = Integer.MAX_VALUE;
		int num = 6;
		int[][] dist = { { max, 6, 3, max, max, max },
				{ max, max, 2, max, 5, max }, { max, max, max, 3, 4, max },
				{ max, max, max, max, 2, 3 }, { max, max, max, max, max, 5 },
				{ max, max, max, max, max, max } };
		int v0 = 0;
		int[] res = disj(num, dist, v0);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}

	public static int[] disj(int num, int[][] dist, int v0) {
		boolean[] s = new boolean[num];
		int[] prev = new int[num];
		int[] dis = new int[num];// 存储最后的结果，存储v0到各点的距离

		// 初始化
		for (int i = 0; i < num; i++) {
			// 将v0相关联的边全部赋值为dis数组
			dis[i] = dist[v0][i];
			if (dis[i] == Integer.MAX_VALUE) {
				prev[i] = -1;// 如果距离为正无穷，则它不与v0相连
			} else {
				prev[i] = v0;
			}
		}

		s[v0] = true;
		dis[v0] = 0;
		int u = v0;
		// 找到从v0出发最小的权值
		for (int i = 1; i < num; i++) {

			int minDis = Integer.MAX_VALUE;
			// int u = v0;
			for (int j = 0; j < num; j++) {
				if (!s[u] && dis[j] < minDis) {
					minDis = dis[j];
					u = j;// 找到了下一个中间点
				}
			}

			s[u] = true;// 把u加到s中

			for (int j = 0; j < num; j++) {
				// 从u点出发开始进行
				if (!s[j] && dist[u][j] < Integer.MAX_VALUE) {
					if (dis[u] + dist[u][j] < dis[j]) // 在通过新加入的u点路径找到离v0点更短的路径
					{
						dis[j] = dis[u] + dist[u][j]; // 更新dis
						prev[j] = u; // 记录前驱顶点
					}
				}
			}
		}
		return dis;
	}
}
