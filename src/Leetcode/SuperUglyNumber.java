package Leetcode;
/**
 * �ú���������㷨��һ��˼��
 * @author Administrator
 *
 */
public class SuperUglyNumber {
	public int nthSuperUglyNumber(int n, int[] primes) {
		int len = primes.length;
		//�洢primes��ÿ���������±꣨�൱����len��ָ�룬ÿ��ָ����±궼�Ǵ�0��ʼ��
        int[] index = new int[len];
        //�洢�������
        int[] result = new int[n];
        result[0] = 1;
        
        if(n <= 1){
        	return result[0];
        }
        
        for(int i = 1;i < n;i ++){
        	//�����������Сֵ�Ĵ���
        	int min = Integer.MAX_VALUE;
        	for(int j = 0;j < len;j ++){
        		//primes[j]���������Ӧ��ָ��λ��Ϊindex[j]���õ�index[j]����result���
        		min = Math.min(min, primes[j] * result[index[j]]);
        	}
        	result[i] = min;
        	//������ܻ�����ظ��Ľ�� 14 = 2 * 7 = 7 * 2����2 �� 7��Ӧ��index����1
        	for(int k = 0;k < len;k ++){
        		//���з��������ģ��������Ӷ�Ӧprime��index, �����ظ�
        		if(min % primes[k] == 0){
        			index[k] ++;
        		}
        	}
        }
        
        return result[n - 1];
    }
}
