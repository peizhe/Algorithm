package LeetCodeSecondEasy;
/**
 * ������һ�������⣺
 * 	��Ҫ�����4�ľ��裬��Ȼǰ���������˶��ܴ���
 * @author MG
 *
 */
public class NimGame292 {
	public static boolean canWinNim(int n) {
        return n > 0 && !(n % 4 == 0);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(10));
	}
}
