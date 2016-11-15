package Leetcode;

public class BestTimetoBuyandSellStockII {
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0 || prices.length == 1){
			return 0;
		}
		int max,min,total = 0;
		max = min = prices[0];
		for(int i = 1;i < prices.length;i ++){
			//如果第二天价格大于第一天价格，则将第二天价格赋给最大值(局部最大)
			if(prices[i] > prices[i - 1]){
				max = prices[i];
				//判断最大值是否大于最小值，大于的话则将利润加入到总利润中，并将当前价格赋值给最小值(局部最小)
				if(max - min > 0){
					total = total + (max - min);
					min = prices[i];
				}
			}
			//如果第二天价格不大于第一天价格，则将第二天价格赋给最小值(局部最小)
			else{
				min = prices[i];
			}
			
		}
        return total;
    }
}
