package Algorithm;
/**
 * function:�ж�һ�����Ƿ�Ϊ����
 * 
 * ����Ϊ6�Ļ��� 5, 6, 7, 8, 9, 10,��һ��ѭ����Ҫ���ǵ�����6,8,9,10�����Էֽ�Ϊ2*x������3*x��
 * Ȼ�󲽳��ټ�6�� 6���Էֽ�Ϊ2*3�� ���Լ�������2*��x+3��������3* ��x+2�������Զ��ܱ�2 �� 3������
 * ֻ�迼��5 �� 7
 * @author Administrator
 *
 */
public class IsPrime {
	public static boolean isPrime(int n){
		if(n <= 3){
			return n > 1;
		}
		
		if(n % 2 == 0 || n % 3 == 0){
			return false;
		}
		
		for(int i = 5;i * i <= n;i += 6){
			if(n % i == 0 || n % (i + 2) == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] mh){
		System.out.println(isPrime(169));
	}
}
