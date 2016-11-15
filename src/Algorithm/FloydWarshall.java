package Algorithm;

/**
 * function:���������㷨������������̾����Լ�����·���ϵĵ�
 * 			Dijkstra�㷨�Ǽ��㵥�㿪ʼ�����������̾���
 * @author mh
 * 
 */
public class FloydWarshall {
	private static int[][] path;
	
	public static void floyd(int[][] distance, int n) {
		// ʱ�临�Ӷ�ΪO(n^3)
		// n������������distance[i][j]����i��j����ľ��루ֱ��������
		// distance������distance[i][i]Ϊ0�����i��j����ͨ��distance[i][j]��ֵΪ���ֵ
		// k�����м�Ľڵ㣬i����ʼ�ڵ㣬j������ֹ�ڵ�

		// floyd�����������Լ������������ľ��룬�����Լ�¼�������̾����·��(����Ҫ��¼·������ֱ��ȥ����Path�йص����)
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

	//���i��j��·��
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
