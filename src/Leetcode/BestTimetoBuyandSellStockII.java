package Leetcode;

public class BestTimetoBuyandSellStockII {
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0 || prices.length == 1){
			return 0;
		}
		int max,min,total = 0;
		max = min = prices[0];
		for(int i = 1;i < prices.length;i ++){
			//����ڶ���۸���ڵ�һ��۸��򽫵ڶ���۸񸳸����ֵ(�ֲ����)
			if(prices[i] > prices[i - 1]){
				max = prices[i];
				//�ж����ֵ�Ƿ������Сֵ�����ڵĻ���������뵽�������У�������ǰ�۸�ֵ����Сֵ(�ֲ���С)
				if(max - min > 0){
					total = total + (max - min);
					min = prices[i];
				}
			}
			//����ڶ���۸񲻴��ڵ�һ��۸��򽫵ڶ���۸񸳸���Сֵ(�ֲ���С)
			else{
				min = prices[i];
			}
			
		}
        return total;
    }
}
