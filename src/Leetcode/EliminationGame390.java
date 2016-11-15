package Leetcode;

public class EliminationGame390 {
	
	public static int lastRemaining(int n) {
        if(n == 1){
        	return 1;
        }
        
        int begin = 2;
        int end = (n & 1) == 0 ? n : n - 1;
        int interval = 4;
        
        boolean isRToL = true;
        
        while(begin != end){
        	//end��begin�Ƿ����inteval��������
        	boolean flag = (end - begin) % interval == 0;
        	if(isRToL){//right ---> left
        		//���end��begin���inteval������������ͷβ���ƶ�(interval / 2)
        		//����ֻ��end��ǰ�ƶ�(interval / 2)
        		begin = flag ? begin + (interval >> 1) : begin;
        		end -= (interval >> 1);
        	} else {//left ---> right
        		//���end��begin���inteval������������ͷβ���ƶ�(interval / 2)
        		//����ֻ��begin����ƶ�(interval / 2)
        		end = flag ? end - (interval >> 1) : end;
        		begin += (interval >> 1);
        	}
        	
        	isRToL = !isRToL;
        	interval <<= 1;
        }
        
        return begin;
    }
	
	/**
	 * ˼���������ͬ������Ӽ���
	 * @param n
	 * @return
	 */
	public int lastRemainingBetter(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;
        while (remaining > 1) {
            if (left || (remaining & 1) == 1) {
                head += step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }
        return head;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastRemaining(10));
	}

}
