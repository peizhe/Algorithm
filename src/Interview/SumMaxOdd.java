package Interview;
/**
 * ��ǰN�����������Լ��֮��
 * 	1.��̬�滮(�ڴ����Ĵ�)
 * 	2.������ӣ�ÿ��ż������1ֱ�����λ��Ϊ0(�������ڴ棬ʱ�临�ӶȲ��ܴﵽO(n))
 * @author MG
 *
 */
public class SumMaxOdd {
	public int sumMax(int n){
		int[] map = new int[n + 1];
		int sum = 1;
		map[1] = 1;
		
		for(int i = 2;i <= n;i ++){
			if((i & 1) == 0){
				map[i] = map[i / 2];
			} else{
				map[i] = i;
			}
			
			sum += map[i];
		}

		return sum;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
