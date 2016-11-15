package LeetCodeSecondEasy;
/**
 * 统计一个数二进制中1的个数
 * 	1.循环32次，判断每一位是不是1，统计1的个数
 *  2.n & (n - 1) 每进行这样一次运算，最低位的1将被消去（注意n ！= 0与n > 0的区别，尤其对于无符号数）
 * @author MG
 *
 */
public class Numberof1Bits191 {
	public static int hammingWeight(int n) {
		int count = 0;
		//注意这里的不等于0控制条件(对于负数就搞定了)
        while(n != 0){
        	n &= n - 1;
        	count ++;
        }
        
        return count;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(hammingWeight(2147483647));
	}

}
