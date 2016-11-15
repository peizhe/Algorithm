package Leetcode;

public class DivideTwoIntegers {
	
	public static int divide(int dividend, int divisor) {
		if(divisor == 0){
			return dividend < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		if(dividend == 0){
			return 0;
		}
		
		if(dividend == Integer.MIN_VALUE && divisor == -1){
			return Integer.MAX_VALUE;
		}
		
		//����ת��ʱ�������������ת����long
		long a = Math.abs((long)dividend);
		long b = Math.abs((long)divisor);
		
		boolean isNeg = (dividend > 0 && divisor < 0) ||
					    (dividend < 0 && divisor > 0);
		int res = 0;
		
		while(a >= b){
			//ÿ�ζ����µõ�һ��shift
			int shift = 0;
			while(a >= (b << shift)){
				shift ++;
			}
			//���������һ��
			shift --;
			
			a -= b << shift;
			
			res += 1 << shift;
		}
		return isNeg ? -res : res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dividend = 10,divisor = 2;
		System.out.println(divide(dividend, divisor));
//		System.out.println(2 >>(-1));
	}
}
