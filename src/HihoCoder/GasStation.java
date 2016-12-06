package HihoCoder;
/**
 * 求相邻车站的最小的最大距离
 * 	(特别经典的一道题，平时也不会这样的题)
 * 
 * 思想:
 * 	1.做一个二分查找，查找的范围是(0, m),注意这里是double类型//m是整个道路的长度
 * 		mid = begin + (end - begin) / 2;
 * 		判断mid是否符合题意,判断方法:
 * 			gasCount +=(long)(每两个gas之间的距离  / mid) - 1: 代表该区间要达到相邻两个gas之间距离是d需要添加的gas数量
 * 		
 * 		如果gasCount <= k ： 证明可以达到相邻gas之间距离为mid, end = mid;
 * 		否则不能达到 : begin = mid
 * 
 * @author Administrator
 *
 */
public class GasStation{
	
	// n positions
	private static boolean check(int[] pos, double d, int m, int k) {
		if (d == 0) return false;
		
		int len = pos.length;
		//存储两个gas之间的距离
		double[] temp = new double[len - 1];
		
		for (int i = 1; i < len; i++) {
			temp[i - 1] = pos[i] - pos[i - 1];
		}

		//需要的gas数
		long need = 0;
		for (int i = 0; i < len - 1; i++) {
			//每个区间要达到相邻两个gas之间的间距是d至少需要添加多少个gas
			double num = Math.ceil(temp[i] / d);
			need += (long)num - 1;
		}

		//如果区间添加的gas数之和<=k 则可以实现相邻两个gas之间距离为d
		return need <= (long)k;
	}
	
	public static double getMinMax(int[] position, int n, int m, int k) {
		double low = 1e-9, high = m;
		//循环次数
		int limit = 100;
		for (int i = 0; i < limit; i++) {
			//mid代表相邻车站之间的距离(查看该距离能不能满足题意)
			double mid = low + (high - low) / 2;
			if (check(position, mid, m, k))
				high = mid;
			else
				low = mid;
		}
		
		return low;
	}

	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int[] nums = new int[]{0, 2, 10};
		int n = 3, m = 10, k = 2;
		System.out.println(String.format("%.1f", getMinMax(nums, n, m, k)));
	}

}
