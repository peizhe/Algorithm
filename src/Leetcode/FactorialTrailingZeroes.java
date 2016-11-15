package Leetcode;
/**
 * �ֽ�����, ���ҽ��� �����г��� һ�� (2,5)ʱ, �����������һ�� trailing zero.
 * 2�ĸ�����Զ����5������.
 * ����5�ĸ���ʱ, ��򵥵ķ����� SUM(N/5^1,  N/5^2, N/5^3...)
 * @author MG
 *
 */
public class FactorialTrailingZeroes {
	
	public int trailingZeroes(int n) {
		int res = 0;  
        while(n > 0)  
        {  
            res += n/5;  
            n /= 5;  
        }  
        return res; 
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
