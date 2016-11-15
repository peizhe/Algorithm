package LeetCodeSecondMedium;
/**
 * 窍门：
 * 	设数是x：
 * 		x具有奇数个因子的数，则经过x轮后的状态和它开始的状态相同(平方数)
 * 		x具有偶数个因子的数，则经过x轮后的状态与它开始的状态相反(非平方数)
 * @author MG
 *
 */
public class BulbSwitche319 {
	public int bulbSwitch(int n) {
        return n > 0 ? (int)Math.sqrt(n) : 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
