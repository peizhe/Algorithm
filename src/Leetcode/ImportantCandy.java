package Leetcode;

import java.util.Arrays;


/**
 * ��������о���û��̰�ķ������úÿ���
 * @author MG
 *
 */
public class ImportantCandy {
	//���˵�˼·
	public int candy(int[] ratings) {
		if(ratings == null || ratings.length == 0){
			return 0;
		}
		int res = 0;
        int[] candys = new int[ratings.length];
        Arrays.fill(candys,1);
        
        //����ɨ��һ��
        for(int i = 1;i < ratings.length;i ++){
        	if(ratings[i] > ratings[i - 1]){
        		candys[i] = candys[i - 1] + 1;
        	}
        }
        //����ɨ��һ��
        for(int i = ratings.length - 2;i >= 0;i --){
        	//�ڶ�����������Ҫ����Ϊ�������ǹ���������Ѿ����ұ߶���(candys[i] > candys[i + 1])��
        	//��ô�ĳ� cans[i] = cans[i + 1] + 1; ���п��ܰ� cans[i] ��С
        	if(ratings[i] > ratings[i + 1] && candys[i] <= candys[i + 1]){
        		candys[i] = candys[i + 1] + 1;
        	}
        }
        
        for(int i = 0;i < candys.length;i ++){
        	res = res + candys[i];
        }
        return res;
    }
	
	//�ҵ�˼·
	public int candy1(int[] ratings){
		if(ratings == null || ratings.length == 0){
			return 0;
		}
        int res = 1;
        
        //�����½����еĿ�ʼ�±�
        int decBegin = 0;
        //�����½����еĽ����±�
        int decEnd = 0;
        //��ǰ�����õ�������
        int currentCandy = 1;
        //δ����ݼ�����ʱ���Ǹ����ӷֵõ�����
        int preContinuousDecCount = 1;
        
        for(int i = 1;i < ratings.length;i ++){
        	if(ratings[i] < ratings[i - 1]){
        		decEnd ++;
        		//�ж������½����еĳ����Ƿ����δ����ݼ�����ʱ���Ǹ����ӷֵõ�����
        		int continusDecCount = decEnd - decBegin + 1;
        		//�����������ܹؼ���
        		//����  > preContinuousDecCount,���Ǹ�����������Ҫ�޸�
        		if(continusDecCount > preContinuousDecCount){
        			res += decEnd - decBegin + 1;
        		}
        		//���� < preContinuousDecCount,���Ǹ����ӵ���������Ҫ�޸�
        		else{
        			res += decEnd - decBegin;
        		}
        		
        		//��֤һ���뿪�ݼ����У���candy�����1����
        		currentCandy = 1;
        	}
        	
        	else{
        		//�����ǰ�ȼ�����ǰһ���ĵȼ�����ǰ�˷ֵ�������ǰһ���˶�1��
        		if(ratings[i] > ratings[i - 1]){
        			currentCandy ++;
        		}
        		//�����ǰ�ȼ�����ǰһ���ĵȼ�����ǰ�˷ֵ���Ϊ1��
        		else{
            		currentCandy = 1;
        		}
        		//һ�����ǵݼ����У��򽫵ݼ��Ŀ�ʼ�ͽ����±�͵�ǰ�±�һ��
        		decBegin = i;
        		decEnd = decBegin;
        		
        		//δ����ݼ����У��򽫵�ǰ��������ֵ��preContinuousDecCount
        		preContinuousDecCount = currentCandy;
        		
        		res += currentCandy;
        	}
        }
        
        return res;
	}
}
