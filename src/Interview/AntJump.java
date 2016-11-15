package Interview;

/**
 * ��Ŀ��
 * 	�������λ��0�㴦��������ֱ�����������������������Ծ���Ƚ��ر���ǣ�����ÿ����Ծ�ľ����ǰһ����Ծ��һ����λ����һ����Ծ�ľ���Ϊһ����λ��
 *  СB�������ǣ������������Ծ��x������Ҫ�������ٴ���Ծ.
 */
/**
 * ˼·�� 
 * 	��һ�οɴ���� ����1
 * 	�ڶ���������1,3
 * 	������������0,2,4,6
 * 	���Ĵ�������0,2,4,6,8,10
 * 	�����������1,3,5,7,9,11,13,15
 * 	������������1,3,5,7,9,11,13,15,17,19,21
 * 	���ߴ�������0,2,4,6,8,10,12,14,16,18,20,22,24,26,28
 *  ...
 * ÿ�����Ŀɴ��f(n) = f(n - 1) + n, f(n) - 2 * i�Ķ��ɴ
 * 
 * @author MG
 * 
 */
public class AntJump {

	public static int getStepCount(int n) {
		int res;
		n = n > 0 ? n : 0 - n;

		int index = 1;
		int sum = 0;
		while (sum < n) {
			sum += index;
			index ++;
		}
		
		//�������ż��
		if (((sum - n) & 1) == 0) {
			res = index - 1;
		} else {//��������
			//indexΪ����
			if ((index & 1) == 1) {
				res = index;
			} else {
				res = index + 1;
			}
		}
		
		return res;
	}

	public static int getStepCount2(int x) {
		x = x > 0 ? x : 0 - x;
		//�ҵ�����ӽ�x����Сn(���ַ����Ƚό�,��ס)
		int n = (int)Math.sqrt(2 * x);
		if(n * (n + 1) < 2 * x){
			n += 1;
		}
		
		return ((n * (n + 1) / 2 - x) & 1) == 0 ? n : (n & 1) == 0 ? n + 2 : n + 1;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getStepCount2(13));
	}
}
