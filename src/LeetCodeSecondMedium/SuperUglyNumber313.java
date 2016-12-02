package LeetCodeSecondMedium;

public class SuperUglyNumber313 {
	public int nthSuperUglyNumber(int n, int[] primes) {
		if(n == 1) return 1;
		
		int len = primes.length;
		//�洢primes��ÿ���������±꣨�൱����len��ָ�룬ÿ��ָ����±궼�Ǵ�0��ʼ��
        int[] index = new int[len];
        //�洢�������
        int[] result = new int[n];
        result[0] = 1;
        
        for(int i = 1;i < n;i ++){
        	//�����������Сֵ�Ĵ���
        	int min = Integer.MAX_VALUE;
        	for(int j = 0;j < len;j ++){
        		//primes[j]���������Ӧ��ָ��λ��Ϊindex[j]���õ�index[j]����result���
        		min = Math.min(min, primes[j] * result[index[j]]);
        	}
        	result[i] = min;
        	//������ܻ�����ظ��Ľ�� 14 = 2 * 7 = 7 * 2����2 �� 7��Ӧ��index����1
        	for(int j = 0; j < len; j ++){
        		//���з��������ģ��������Ӷ�Ӧprime��index, �����ظ�
        		if(min % primes[j] == 0) index[j] ++;
        	}
        }
        
        return result[n - 1];
    }
}
