package Leetcode;
/**
 * �ж�һ�����Ƿ�Ϊn���ݣ����Բ������²��ԣ�
 * 1.��nΪ�����������������Ϊԭ������ȡ��������
 * 2.������Ϊ ��������Ϊn���ݣ�����Ϊn����
 *
 */

public class PowerOfThree {
	
	public static boolean isPowerOfThree(int n) {
		double ep = Math.pow(10, -10);
        boolean result = false;
        
        double temp = Math.log(n) / Math.log(3);
        
        result = Math.abs(temp - Math.round(temp)) <= ep;
        
        return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfThree(59049));
	}

}
