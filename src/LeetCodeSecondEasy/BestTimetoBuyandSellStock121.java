package LeetCodeSecondEasy;
/**
 * 买卖一次股票获得的最大利润
 * 	1.动态规划(维护一个最低价格和最大利润)
 * @author MG
 *
 */
public class BestTimetoBuyandSellStock121 {
	public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
        	return 0;
        }
        
        int length = prices.length;
        int maxProfit = 0;
        int minPrice = prices[0];
        
        for(int i = 1;i < length;i ++){
        	//当前价格
        	int currentPrice = prices[i];
        	//维护一个最低价格
        	minPrice = currentPrice > minPrice ? minPrice : currentPrice;
        	//当前利润
        	int currentProfit = currentPrice - minPrice;
        	//维护一个最大利润
        	maxProfit = currentProfit > maxProfit ? currentProfit : maxProfit;
        }
        
        return maxProfit;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2};
		System.out.println(maxProfit(a));
	}

}
