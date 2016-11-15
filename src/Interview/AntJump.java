package Interview;

/**
 * 题目：
 * 	蚂蚱最初位于0点处，可以在直线上向正向或反向两个方向跳跃。比较特别的是，蚂蚱每次跳跃的距离比前一次跳跃多一个单位，第一次跳跃的距离为一个单位。
 *  小B的问题是，如果让蚂蚱跳跃到x处，需要经过多少次跳跃.
 */
/**
 * 思路： 
 * 	第一次可达的是 正负1
 * 	第二次是正负1,3
 * 	第三次是正负0,2,4,6
 * 	第四次是正负0,2,4,6,8,10
 * 	第五次是正负1,3,5,7,9,11,13,15
 * 	第六次是正负1,3,5,7,9,11,13,15,17,19,21
 * 	第七次是正负0,2,4,6,8,10,12,14,16,18,20,22,24,26,28
 *  ...
 * 每次最大的可达点f(n) = f(n - 1) + n, f(n) - 2 * i的都可达。
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
		
		//如果差是偶数
		if (((sum - n) & 1) == 0) {
			res = index - 1;
		} else {//差是奇数
			//index为奇数
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
		//找到和最接近x的最小n(这种方法比较屌,记住)
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
