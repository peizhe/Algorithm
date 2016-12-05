package HihoCoder;

public class GasStation {
	private static int[] pos = new int[100010];
	private static double[] temp = new double[100010];

	// n positions
	private static boolean check(double d, int n, int m, int k) {
		if (d == 0) return false;
		
		int next = 0;
		for (int i = 1; i < n; i++) {
			if (pos[i] - pos[i - 1] > 0)
				temp[next++] = (pos[i] - pos[i - 1]);
		}

		//��Ҫ��gas��
		long need = 0;
		for (int i = 0; i < next; i++) {
			//ÿ������Ҫ�ﵽ��������gas֮��ļ����d������Ҫ��Ӷ��ٸ�gas
			double num = Math.ceil(temp[i] / d);
			need += (long)num - 1;
		}

		//���������ӵ�gas��֮��<=k �����ʵ����������gas֮�����Ϊd
		return need <= (long)k;
	}
	
	public static double getMinMax(int[] position, int n, int m, int k) {
		double low = 1e-9, high = 1000000000;
		int limit = 100000;
		for (int i = 0; i < limit; i++) {
			double mid = (low + high) / 2;
			if (check(mid, n, m, k))
				high = mid;
			else
				low = mid;
		}
		
		return low;
	}

	public static void main(String[] args) {
		int[] nums = new int[]{0, 2, 10};
		int n = 3, m = 10, k = 2;
		System.out.println(String.format("%.1f", getMinMax(nums, n, m, k)));
	}

}
