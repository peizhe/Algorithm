package LeetCodeSecondEasy;
/**
 * n�Ľ׳�β����0����2 * 5�����ģ�2�������϶�����5�����������Դ���5�ĸ�������β��0�ĸ���
 * 	1.˫��ѭ����ʵ���˷�ʱ��
 * 	2.return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
 * @author MG
 *
 */
public class FactorialTrailingZeroes172 {
	public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(10));
	}

}
