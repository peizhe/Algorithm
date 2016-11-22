package Leetcode;
/**
 * ״̬����ʹ��:
 * 	̫ţ����
 * @author MG
 *
 */
public class BestTimeBuySellStockCooldown309 {
	/**
	 * The natural states for this problem is the 3 possible transactions : 
	 * 		buy, sell, rest. Here rest means no transaction on that day (aka cooldown).
	 * Then the transaction sequences can end with any of these three states.
	 * For each of them we make an array, buy[n], sell[n] and rest[n].
	 * 
	 * buy[i] means before day i what is the maxProfit for any sequence end with buy.
	 * sell[i] means before day i what is the maxProfit for any sequence end with sell.
	 * rest[i] means before day i what is the maxProfit for any sequence end with rest.
	 * Then we want to deduce the transition functions for buy sell and rest. By definition we have:
	 * 		buy[i]  = max(rest[i - 1] - price, buy[i - 1])
	 * 		sell[i] = max(buy[i - 1] + price, sell[i - 1])
	 * 		rest[i] = max(sell[i - 1], buy[i - 1], rest[i - 1])
	 * 
	 * Where price is the price of day i. All of these are very straightforward. They simply represents :
	 * (1) We have to `rest` before we `buy` 
	 * (2) we have to `buy` before we `sell`
	 * 
	 * One tricky point is how do you make sure you sell before you buy, since from the equations it seems that [buy, rest, buy] is entirely possible.
	 * Well, the answer lies within the fact that buy[i] <= rest[i] which means rest[i] = max(sell[i-1], rest[i-1]). That made sure [buy, rest, buy] is never occurred.
	 * A further observation is that and rest[i] <= sell[i] is also true therefore
	 * 		rest[i] = sell[i-1]
	 * 
	 * Substitute this in to buy[i] we now have 2 functions instead of 3:
	 * 		buy[i] = max(sell[i-2]-price, buy[i-1])
	 * 		sell[i] = max(buy[i-1]+price, sell[i-1])
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfitBetter(int[] prices) {
	    int sell = 0, prevSell = 0, buy = Integer.MIN_VALUE, prevBuy;
	    for (int price : prices) {
	        prevBuy = buy;
	        buy = Math.max(prevSell - price, prevBuy);
	        prevSell = sell;
	        sell = Math.max(prevBuy + price, prevSell);
	    }
	    
	    return sell;
	}
	
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) return 0;
	    int buy = -prices[0], sell = Integer.MIN_VALUE, rest = 0;
	    for (int i = 1; i < prices.length; i++) {
	        int tmp = buy;
	        buy = Math.max(buy, rest - prices[i]);
	        rest = Math.max(rest, sell);
	        sell = tmp + prices[i];
	    }
	    return Math.max(buy, Math.max(sell, rest));
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//[2,1,4,5,2,9,7]
		// TODO Auto-generated method stub
		int[] prices = new int[]{1,7,2,4};
		System.out.println(maxProfitBetter(prices));
	}

}
