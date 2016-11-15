package HihoCoder;

import java.util.Scanner;

/**
 * 
 * 求一个数可以被2的幂表示的最少2的幂数
 * 
 * 	例如: 7 = 2 ^ 2 + 2 ^ 1 + 2 ^ 0
 * 		 7 = 2 ^ 3 - 2 ^ 0
 * 	
 * 所以结果是2(2^3 和 2^0)
 * 
 * @author MG
 *
 */
public class PowersOfTwo1410 {

	private static Scanner input;

	public static int getMinCount(int N) {
		int number = 1;
		// 找到第一个比N大的2的幂
		while (N >= number * 2) {
			number *= 2;
		}

		int size = 0;
		while (N != 0 && number != 0) {
			//这个判断写的太屌了
			if (N >= number) {
				if (number * 2 - N > N - number) {//证明N距离number更近(去掉了最高位的1)
					N = N - number;
				} else {
					N = number * 2 - N;
				}

				size++;
			}

			number /= 2;
		}

		return size;
	}

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int N = input.nextInt();
		System.out.println(getMinCount(N));
	}
}
