package Interview;

/**
 * 美团机试题
 * @author MG
 *
 */
public class StepCount {
	public static int count(int x,int y){
		int sum = x + y - 2,min = Math.min(x - 1, y - 1);
		
		int count = 1;
		for(int i = 0;i < min;i ++){
			count *= (sum - i);
		}
		
		int mul = 1;
		for(int j = 2;j <= min;j ++){
			mul *= j;
		}
		
		return count / mul;
	}
}
