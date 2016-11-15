package Algorithm;

import java.util.Arrays;

/**
 * 1.����ɸѡ�� :
 * 	(1)������ɫ��ɸ��(ʱ�临�Ӷ�O(nlogn))
 * 	(2)ŷ��ɸ�� (ʱ�临�Ӷ�O(n))
 * 
 * 2.�ж�һ�����Ƿ�������:(�����ޱ�����)
 * 
 * 3.����<=n����n���ʵ�������
 * 
 * @author MG
 *
 */
public class Primes {
	
	/**
	 * ����㷨�а�����ɫ������ɸ��(ʱ�临�Ӷ���O(nlogn),�ȴ�ͳ�������ٵĶ�)
	 * 
	 * ����һ���������ǿ��Էֽ�����ɸ������ĳ˻�����ô��������������ֻ֪��2���������ı�����ȥ������ôʣ�µľ��������ˡ�
	 * ����Ҫ����100���ڵ�����������2����������2�ı���ȥ������ʱ3û�б�ȥ��������Ϊ�����������԰�3�ı���ȥ����
	 * 	     �ٵ�5���ٵ�7��7֮���أ���Ϊ8��9��10�ղŶ���ȥ���ˣ���100���ڵ���������϶�����һ������С��10��100�Ŀ�������
	 *    ���ԣ�ȥ����2��3��5��7�ı�����ʣ�µĶ��������ˡ�
	 * �ó������������������벼����������a[i]�����i��������a[i]=true������a[i]=false��
	 * ��ô����i���Ա�ʾ��a[i]=false��
	 * 
	 * @param n
	 */
	public static void sieve(int n){
		boolean[] assist = new boolean[n];
		Arrays.fill(assist, true);
		
		for(int i = 2;i < n;i ++){
			if(assist[i]){
				//ע�����i��ʼ�����ô�1��ʼ
				for(int j = i * i; j < n;j += i){
					assist[j] = false;
				}
			}
		}
	}
	
	/**
	 * ����ŷ��ɸ��,ʱ�临�Ӷ�(O(n) ÿ�������ᱻ�ж�һ��) ���淽���� : 30 ��2 * 15 �ᱻɸ,��3 * 10Ҳ�ᱻɸ,��5 * 6 Ҳ�ᱻɸ(30���ظ�ɸ�˶��)
	 * 	
	 * 	
	 * @param n
	 */
	public static int elur(int n){
		//����Ƿ�Ϊ����
		boolean[] flags = new boolean[n];
		int[] primes = new int[n];
		int primeIndex = 0;
		
		Arrays.fill(flags, true);
		for(int i = 2; i < n; i++){
			if(flags[i]){
				primes[primeIndex ++] = i;
			}
			
			for(int j = 0; j < primeIndex; j++){
				//�ж��Ƿ񳬳���Χ
				if(i * primes[j] > n) break;
				
				flags[i * primes[j]] = false;
				
				//ÿ��������������С�����������˵�(��仰�ܹؼ�)
				if(i % primes[j] == 0) break;
			}
		}
		
		return primeIndex == 0 ? 0 : primeIndex - 1;
	}
	
	/**
	 * �ж�һ�����Ƿ�Ϊ����
	 * 	�����ޱ��ж���
	 * 	
	 * @param n
	 * @return
	 */
	public static boolean isPrime(int n) {
		return true;
	}
	
	/**
	 * ���� b�ܴ�,��a * b % n �Ľ��
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	public static int getAmulBModN(int a, long b, int n) {
		int res = 0;
		while(b != 0){
			if((b & 1) == 1) res = (res + a) % n;
			
			a = (a + a) % n;
			
			b >>= 1;
		}
		
		return res;
	}
	
	/**
	 * b�ܴ�,����a^b % n��ֵ
	 * 
	 * @param a
	 * @param b
	 * @param n
	 * @return
	 */
	public static int getAPowerBModN(int a, long b, int n){
		int res = 1;
		while(b != 0) {
			if((b & 1) == 1) res = getAmulBModN(res, a, n);
			
			a = getAPowerBModN(a, a, n);
			
			b >>= 1;
		}
		
		return res;
	}
	
	/**
	 * ŷ������f(n):����<=n����n���ʵ����ĸ���
	 * f(x) = x(1-1/p1)(1-1/p2)(1-1/p3)(1-1/p4)��(1-1/pn),����p1,p2����pnΪx������������
	 * 
	 * ��m,n����,f(m * n) = f(m) * f(n)
	 * �������ʣ���nΪ����ʱ f(2 * n) = f(n), ֤�����������ơ�
	 * ��nΪ������f(n) = n - 1 
	 * 
	 * @param n
	 * @return
	 */
	public static int getCount(int n){
		int res = n, a = n;
		for(int i = 2; i * i <= n; i++) {
			if(a % i == 0) {
				//��ֹԽ��
				res = res / i * (i - 1);
				while(a % i == 0) a /= i;
			}
		}
		
		//aʣ�µ������Ϊ1�Ϳ϶�Ϊ����
		if(a > 1) res = res / a * (a - 1);
		
		return res;
	}
	
	/**
	 * �õ�1-n��ŷ������ֵ
	 * 
	 * @param n
	 * @return
	 */
	public static int[] getElur(int n){
		int[] values = new int[n + 1];
		values[1] = 1;
		//��ʽ��x*(1 - 1/p1)...�е�x
		for(int i = 2;i <= n; i++) {
			values[i] = i;
		}
		
		for(int i = 2; i <= n; i++){
			//values[i] == i : ֤��iΪ����
			if(values[i] == i){
				//����ÿ������i���������
				for(int j = i; j <= n; j += i){
					//���������Ƿ�ֹԽ��
					values[j] = values[j] / i * (i - 1);
				}
			}
		}
		
		return values;
	} 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getCount(10));
	}
}
