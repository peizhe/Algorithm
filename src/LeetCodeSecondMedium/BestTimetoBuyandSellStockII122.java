package LeetCodeSecondMedium;

public class BestTimetoBuyandSellStockII122 {
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0 || prices.length == 1) {
			return 0;
		}

		int res = 0, len = prices.length;
		int diff = 0;
		for (int i = 1; i < len; i++) {
			diff = prices[i] - prices[i - 1];
			if (diff > 0) {
				res += diff;
			}
		}

		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = new int[] { 10, 11, 8, 14, 15, 10 };
		System.out.println(maxProfit(prices));
	}

}
