package LeetCodeSecondEasy;
/**
 * �ж�һ�����ǲ���2���ݣ�
 * 	 1.x & (x - 1) ���Ϊ0������2���ݣ������ǣ����ݶ����Ƽ���
 * @author MG
 *
 */
public class PowerofTwo231 {
	public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n - 1) == 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
