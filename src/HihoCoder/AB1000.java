package HihoCoder;

import java.util.Scanner;
/**
 * 注意这种读取的方式
 * @author MG
 *
 */
public class AB1000 {

	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while(sc.hasNext()){
			String temp = sc.nextLine();
			int a = Integer.parseInt(temp.split(" ")[0]);
			int b = Integer.parseInt(temp.split(" ")[1]);
			System.out.println(a + b);
		}
	}
}
