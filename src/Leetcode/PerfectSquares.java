package Leetcode;
/**
 * �����������һ��˼��(��ס)dp˼��
 */
import java.util.Arrays;

public class PerfectSquares {
	
	public int numSquares(int n) {
		int[] temp = new int[n + 1];
		Arrays.fill(temp,Integer.MAX_VALUE);
		
		for(int i = 0;i * i <= n;i ++){
			temp[i * i] = 1;
		}
		
		for(int i = 1;i <= n;i ++){
			//����������
			for(int j = 0;i + j * j <= n;j ++){
				//��ؼ���һ�д���
				temp[i + j * j] = Math.min(temp[i] + 1, temp[i + j * j]);
			}
		}
		
		return temp[n];
    }
}
