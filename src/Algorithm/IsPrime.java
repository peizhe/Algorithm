package Algorithm;
/**
 * function:判断一个数是否为素数
 * 
 * 步长为6的话， 5, 6, 7, 8, 9, 10,是一个循环里要考虑的数，6,8,9,10都可以分解为2*x，或者3*x，
 * 然后步长再加6， 6可以分解为2*3， 所以加起来是2*（x+3），或者3* （x+2），所以都能被2 或 3整除，
 * 只需考虑5 和 7
 * @author Administrator
 *
 */
public class IsPrime {
	public static boolean isPrime(int n){
		if(n <= 3){
			return n > 1;
		}
		
		if(n % 2 == 0 || n % 3 == 0){
			return false;
		}
		
		for(int i = 5;i * i <= n;i += 6){
			if(n % i == 0 || n % (i + 2) == 0){
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] mh){
		System.out.println(isPrime(169));
	}
}
