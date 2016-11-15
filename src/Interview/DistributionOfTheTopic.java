package Interview;

import java.util.Arrays;
/**
 * 今日头条第2题
 * 	以后要善于做这样的题(覆盖的问题，机试经常碰到这样的题)
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
				//第二个数比第一个数大[0,10]
				count ++;
			} else if(distance > 10 && distance <= 20){
				//第二个数比第一个数大(10,20]
				result += 1;
				j = count == 1 ? j + 1 : j;
				count = 1;
			} else {
				//第二个数比第一个数大(20,+无穷)
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
