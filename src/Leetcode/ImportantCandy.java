package Leetcode;

import java.util.Arrays;


/**
 * 这个方法感觉并没用贪心方法，好好看看
 * @author MG
 *
 */
public class ImportantCandy {
	//别人的思路
	public int candy(int[] ratings) {
		if(ratings == null || ratings.length == 0){
			return 0;
		}
		int res = 0;
        int[] candys = new int[ratings.length];
        Arrays.fill(candys,1);
        
        //正向扫描一遍
        for(int i = 1;i < ratings.length;i ++){
        	if(ratings[i] > ratings[i - 1]){
        		candys[i] = candys[i - 1] + 1;
        	}
        }
        //反向扫描一遍
        for(int i = ratings.length - 2;i >= 0;i --){
        	//第二个条件很重要，因为如果左边糖果数本身就已经比右边多了(candys[i] > candys[i + 1])，
        	//那么改成 cans[i] = cans[i + 1] + 1; 就有可能把 cans[i] 变小
        	if(ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1]){
        		candys[i] = candys[i + 1] + 1;
        	}
        }
        
        for(int i = 0;i < candys.length;i ++){
        	res = res + candys[i];
        }
        return res;
    }
	
	//我的思路
	public int candy1(int[] ratings){
		if(ratings == null || ratings.length == 0){
			return 0;
		}
        int res = 1;
        
        //连续下降序列的开始下标
        int decBegin = 0;
        //连续下降序列的结束下标
        int decEnd = 0;
        //当前孩子拿到的糖数
        int currentCandy = 1;
        //未进入递减序列时的那个孩子分得的糖数
        int preContinuousDecCount = 1;
        
        for(int i = 1;i < ratings.length;i ++){
        	if(ratings[i] < ratings[i - 1]){
        		decEnd ++;
        		//判断连续下降序列的长度是否大于未进入递减序列时的那个孩子分得的糖数
        		int continusDecCount = decEnd - decBegin + 1;
        		//下面这两步很关键额
        		//长度  > preContinuousDecCount,则那个孩子糖数需要修改
        		if(continusDecCount > preContinuousDecCount){
        			res += decEnd - decBegin + 1;
        		}
        		//长度 < preContinuousDecCount,则那个孩子的糖数不需要修改
        		else{
        			res += decEnd - decBegin;
        		}
        		
        		//保证一旦离开递减序列，则candy必须从1计数
        		currentCandy = 1;
        	}
        	
        	else{
        		//如果当前等级大于前一个的等级，则当前人分的糖数比前一个人多1个
        		if(ratings[i] > ratings[i - 1]){
        			currentCandy ++;
        		}
        		//如果当前等级等于前一个的等级，则当前人分的糖为1个
        		else{
            		currentCandy = 1;
        		}
        		//一旦不是递减序列，则将递减的开始和结束下标和当前下标一致
        		decBegin = i;
        		decEnd = decBegin;
        		
        		//未进入递减序列，则将当前的糖数赋值给preContinuousDecCount
        		preContinuousDecCount = currentCandy;
        		
        		res += currentCandy;
        	}
        }
        
        return res;
	}
}
