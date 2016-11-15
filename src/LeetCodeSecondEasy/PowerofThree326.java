package LeetCodeSecondEasy;

public class PowerofThree326 {
	public boolean isPowerOfThree(int n) {
		boolean flag = (int)(Math.log10(n) / Math.log10(3)) == Math.log10(n) / Math.log10(3);
        return n > 0 && flag;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
