package LeetCodeSecondEasy;
/**
 * ����һ�ι�Ʊ��õ��������
 * 	1.��̬�滮(ά��һ����ͼ۸���������)
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
        	//��ǰ�۸�
        	int currentPrice = prices[i];
        	//ά��һ����ͼ۸�
        	minPrice = currentPrice > minPrice ? minPrice : currentPrice;
        	//��ǰ����
        	int currentProfit = currentPrice - minPrice;
        	//ά��һ���������
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
