package Interview;
/**
 * 类似的题都可以这样做(前提是钱的数量是无限的)
 * @author MG
 *
 */
public class CountMoney {
	private static int count(int n) {
		int[] money = {100, 50, 20, 10, 5, 1};
		int res = 0, len = money.length;
		
		for (int i = 0; i < len;i ++) {
			res += singleCount(n, money, i, len);
		}
		
		return res;
	}

	private static int singleCount(int target, int[] money, int current, int len) {

		if (target < money[current])
			return 0;
		
		if (target == money[current])
			return 1;
		
		else {
			int m = 0;
			for (int j = current;j < len;j ++) {
				m += singleCount(target - money[current], money, j, len);
			}
			
			return m;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(10));
	}

}
