package Algorithm;
/**
 * 随机生成900个1 - 1000之内不重复的数
 */
import java.util.Random;

public class RandomTest {
	public static void main(String[] mh){
		int[] res = new int[1000];
		Random r = new Random();
		for(int i = 0;i < 900;){
			int temp = r.nextInt(999) + 1;
			if(res[temp - 1] == 0){
				res[temp - 1] = temp;
				System.out.println(temp);
				i ++;
			}
		}
	}
}
