package LeetCodeSecondEasy;
/**
 * 这算是一道智力题：
 * 	主要是这个4的精髓，当然前提是两个人都很聪明
 * @author MG
 *
 */
public class NimGame292 {
	public static boolean canWinNim(int n) {
        return n > 0 && !(n % 4 == 0);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(canWinNim(10));
	}
}
