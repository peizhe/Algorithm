package LeetCodeSecondEasy;
/**
 * ͳ��һ������������1�ĸ���
 * 	1.ѭ��32�Σ��ж�ÿһλ�ǲ���1��ͳ��1�ĸ���
 *  2.n & (n - 1) ÿ��������һ�����㣬���λ��1������ȥ��ע��n ��= 0��n > 0��������������޷�������
 * @author MG
 *
 */
public class Numberof1Bits191 {
	public static int hammingWeight(int n) {
		int count = 0;
		//ע������Ĳ�����0��������(���ڸ����͸㶨��)
        while(n != 0){
        	n &= n - 1;
        	count ++;
        }
        
        return count;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(2147483647));
	}

}
