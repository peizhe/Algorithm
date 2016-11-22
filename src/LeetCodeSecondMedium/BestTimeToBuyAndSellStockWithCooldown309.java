package LeetCodeSecondMedium;

public class BestTimeToBuyAndSellStockWithCooldown309 {
	public static int maxProfit(int[] prices) {
	    int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;
	    for (int price : prices) {
	        prevBuy = buy;
	        buy = Math.max(prevSell - price, prevBuy);
	        prevSell = sell;
	        sell = Math.max(prevBuy + price, prevSell);
	    }
	    
	    return sell;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
