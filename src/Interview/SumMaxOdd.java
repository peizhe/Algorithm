package Interview;
/**
 * ��ǰN�����������Լ��֮��
 * 	1.��̬�滮(�ڴ����Ĵ�)
 * 	2.������ӣ�ÿ��ż������1ֱ�����λ��Ϊ0(�������ڴ棬ʱ�临�ӶȲ��ܴﵽO(n))
 * 	3.�܌ŵķ���(������)
 * @author MG
 *
 */
public class SumMaxOdd {
	public static long maxOddSum(int n) {
		if(n < 1) return 0;
		long res = 0;
		for(long i = n; i > 0; i /= 2) {
			if((i & 1) == 1) {
				res += ((i + 1) / 2) * ((i + 1) / 2); 
			} else {
				res += (i / 2) * (i / 2);
			}
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
