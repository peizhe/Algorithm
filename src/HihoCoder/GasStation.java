package HihoCoder;
/**
 * �����ڳ�վ����С��������
 * 	(�ر𾭵��һ���⣬ƽʱҲ������������)
 * 
 * ˼��:
 * 	1.��һ�����ֲ��ң����ҵķ�Χ��(0, m),ע��������double����//m��������·�ĳ���
 * 		mid = begin + (end - begin) / 2;
 * 		�ж�mid�Ƿ��������,�жϷ���:
 * 			gasCount +=(long)(ÿ����gas֮��ľ���  / mid) - 1: ���������Ҫ�ﵽ��������gas֮�������d��Ҫ��ӵ�gas����
 * 		
 * 		���gasCount <= k �� ֤�����Դﵽ����gas֮�����Ϊmid, end = mid;
 * 		�����ܴﵽ : begin = mid
 * 
 * @author Administrator
 *
 */
public class GasStation{
	
	// n positions
	private static boolean check(int[] pos, double d, int m, int k) {
		if (d == 0) return false;
		
		int len = pos.length;
		//�洢����gas֮��ľ���
		double[] temp = new double[len - 1];
		
		for (int i = 1; i < len; i++) {
			temp[i - 1] = pos[i] - pos[i - 1];
		}

		//��Ҫ��gas��
		long need = 0;
		for (int i = 0; i < len - 1; i++) {
			//ÿ������Ҫ�ﵽ��������gas֮��ļ����d������Ҫ��Ӷ��ٸ�gas
			double num = Math.ceil(temp[i] / d);
			need += (long)num - 1;
		}

		//���������ӵ�gas��֮��<=k �����ʵ����������gas֮�����Ϊd
		return need <= (long)k;
	}
	
	public static double getMinMax(int[] position, int n, int m, int k) {
		double low = 1e-9, high = m;
		//ѭ������
		int limit = 100;
		for (int i = 0; i < limit; i++) {
			//mid�������ڳ�վ֮��ľ���(�鿴�þ����ܲ�����������)
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
