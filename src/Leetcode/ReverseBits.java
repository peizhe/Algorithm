package Leetcode;
/**
 * ��ת�����Ķ�����ʱ�����Բ���������������ٽ��з�ת��
 * ֱ��������λ���������
 * @author MG
 *
 */
public class ReverseBits {
	
	public static int reverseBits(int y) {
		int INT_SIZE = Integer.SIZE;  
		  
        for (int i = 0; i < INT_SIZE / 2; i++) {  
            int j = INT_SIZE - 1 - i;  
  
            int low = (y >> i) & 1;  
            int high = (y >> j) & 1;   
            
            //ֻ�н���λ������ͬ�Ž��������ｻ���ķ�ʽ�����
            if ((high ^ low) == 1) {  
                y  ^= (1 << i | 1 << j);  
            }  
        }  
        return y;
    }
}
