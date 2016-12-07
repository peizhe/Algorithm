package NiuKe;

import java.util.Scanner;
/**
 * 6 和 8 能组成 > 10的任意偶数
 * 
 * @author Administrator
 *
 */
public class BuyApples {
	public static int getMinPackage(int n) {
		if(n < 6 || (n & 1) == 1 || n == 10) return 0;
		
		if(n % 8 == 0) return n / 8;
		
		return 1 + n / 8;
	}
	
	public static void main(String[] mh) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = getMinPackage(n);
		System.out.println(res == 0 ? -1 : res);
		
	}
}
