package Interview;

import java.util.Arrays;
/**
 * ����ͷ����2��
 * 	�Ժ�Ҫ��������������(���ǵ����⣬���Ծ���������������)
 * @author MG
 *
 */
public class DistributionOfTheTopic {
	public static int spareTopic(int[] topics) {
		int len = topics.length;
		if (len == 0) {
			return 0;
		}

		if (len == 1) {
			return 2;
		}
		
		int count = 1;
		int j = 0;
		Arrays.sort(topics);

		int result = 0;
		for (;j < len - 1;j ++) {
			int distance = topics[j + 1] - topics[j];
			if (distance <= 10) {
				//�ڶ������ȵ�һ������[0,10]
				count ++;
			} else if(distance > 10 && distance <= 20){
				//�ڶ������ȵ�һ������(10,20]
				result += 1;
				j = count == 1 ? j + 1 : j;
				count = 1;
			} else {
				//�ڶ������ȵ�һ������(20,+����)
				result += 3 - count;
				count = 1;
			}
			
			count %= 3;
		}
		
		return result += count == 0 ? 0 : 3 - count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{1,18,23,23,30,40,50,60};
		System.out.println(spareTopic(nums));
	}

}
