package LeetCodeSecondEasy;
/**
 * https://en.wikipedia.org/wiki/Digital_root
 * �������⣬������и���ʽ��
 * 	(num - 1) % 9 + 1
 * @author MG
 * 
 */
public class AddDigits258 {
	public int addDigits(int num) {
		if(num == 0){
			return 0;
		}
		
        return (num - 1) % 9 + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}
