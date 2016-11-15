package Poj;

//��С·��
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
		int[] dis = new int[num];// �洢���Ľ�����洢v0������ľ���

		// ��ʼ��
		for (int i = 0; i < num; i++) {
			// ��v0������ı�ȫ����ֵΪdis����
			dis[i] = dist[v0][i];
			if (dis[i] == Integer.MAX_VALUE) {
				prev[i] = -1;// �������Ϊ�������������v0����
			} else {
				prev[i] = v0;
			}
		}

		s[v0] = true;
		dis[v0] = 0;
		int u = v0;
		// �ҵ���v0������С��Ȩֵ
		for (int i = 1; i < num; i++) {

			int minDis = Integer.MAX_VALUE;
			// int u = v0;
			for (int j = 0; j < num; j++) {
				if (!s[u] && dis[j] < minDis) {
					minDis = dis[j];
					u = j;// �ҵ�����һ���м��
				}
			}

			s[u] = true;// ��u�ӵ�s��

			for (int j = 0; j < num; j++) {
				// ��u�������ʼ����
				if (!s[j] && dist[u][j] < Integer.MAX_VALUE) {
					if (dis[u] + dist[u][j] < dis[j]) // ��ͨ���¼����u��·���ҵ���v0����̵�·��
					{
						dis[j] = dis[u] + dist[u][j]; // ����dis
						prev[j] = u; // ��¼ǰ������
					}
				}
			}
		}
		return dis;
	}
}
