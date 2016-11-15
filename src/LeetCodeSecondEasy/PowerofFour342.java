package LeetCodeSecondEasy;

public class PowerofFour342 {
	public boolean isPowerOfFour(int num) {
        return num > 0 && (num & num - 1) == 0 && (num & 0x55555555) != 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
