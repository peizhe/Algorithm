package Interview;

/**
 * 题目: 一圈僵尸围着猎人，每个僵尸都有一定的攻击力 猎人一次能够击杀3个相邻的僵尸，不够3个僵尸一次性消灭掉，求猎人受到的最低伤害
 * 
 * 	僵尸的攻击力均大于0
 * 
 * 百度机试题
 * 
 * @author MG
 * 
 */
public class FireJS {

	private static int killEnermies(int[] nums, int len) {
		if(len <= 3){
			return 0;
		}
		
		return 0;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[] {3, 4, 2, 2, 1, 4, 1};
		System.out.println(killEnermies(nums, nums.length));
	}

}
