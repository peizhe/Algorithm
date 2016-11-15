package Leetcode;

public class NumberOf1Bits {
	//��Ҫѭ��32�Σ�32λ�����Ƚ��鷳
	public int hammingWeight(int n) {
		int result = 0;
		while(0 != n){
			//������
			int left = n & 0x1;
			result += left;
			//���ƣ��൱�ڳ���2
			n = n >> 1;
		}
		
		return result;
    }
	/**
	 * n = 0x110100  n-1 = 0x110011  n&(n - 1) = 0x110000 result ++;
	 * n = 0x110000  n-1 = 0x101111  n&(n - 1) = 0x100000 result ++;
	 * n = 0x100000  n-1 = 0x011111  n&(n - 1) = 0x0	  result ++;
	 * @param n
	 * @return
	 */
	//�������ʵ������
	public int hammingWeight1(int n) {
		int result = 0;
		while(0 != n){
			n = n & (n - 1);//ÿ����һ�����������㣬�ͻ�����һ��1
			result ++;
		}
		
		return result;
    }
}
