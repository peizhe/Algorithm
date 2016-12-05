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

		//需要的gas数
		long need = 0;
		for (int i = 0; i < next; i++) {
			//每个区间要达到相邻两个gas之间的间距是d至少需要添加多少个gas
			double num = Math.ceil(temp[i] / d);
			need += (long)num - 1;
		}

		//如果区间添加的gas数之和<=k 则可以实现相邻两个gas之间距离为d
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
