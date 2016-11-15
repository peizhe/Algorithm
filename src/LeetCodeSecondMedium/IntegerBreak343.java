package LeetCodeSecondMedium;
/**
 * 数学规律：
 * 	当n < 8时：
 * 		分解成2的幂乘积最大
 * 	当n >= 8时：
 * 		分解成3的幂乘积最大
 * @author MG
 *
 */
public class IntegerBreak343 {
	
	public static int integerBreak(int n) {
		if(n <= 1){
			return 0;
		} else if(n < 8){
			int temp = n / 2;
        	return (n & 1) == 0 ? temp * temp : temp * (temp + 1);
        }
		
		int res = 1;
		
		while(n >= 3){
			res *= 3;
			n -= 3;
		}
		
		return n == 2 ? res * 2 : n == 1 ? res / 3 * 4 : res;	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(integerBreak(11));
	}

}
