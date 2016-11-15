package Leetcode;
//这个方法太巧妙了！
public class BestTimetoBuyandSellStock {
	public int maxProfit(int[] prices) {
        if(prices.length < 2)
        {
        	return 0;
        }
        int maxSal = 0;
        int minprice = prices[0];
        for(int i = 1;i < prices.length;i ++)
        {
        	minprice = Math.min(minprice, prices[i]);
        	maxSal = Math.max(maxSal, prices[i] - minprice);
        }
        return maxSal;
    }
	public static void main(String[] mh){
		int[] a = {5,2,10,8,25,1};
		BestTimetoBuyandSellStock bt = new BestTimetoBuyandSellStock();
		System.out.println(bt.maxProfit(a));
	}
}
