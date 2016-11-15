package NineOj;

//给定两个整数A和B，其表示形式是：从个位开始，每三位数用逗号","隔开。现在请计算A+B的结果，并以正常形式输出。
import java.util.*;
import java.math.*;

public class TTestSumab {
	private static Scanner sc;

	public static void main(String[] mh) {
		sc = new Scanner(System.in);
		String[] str;
		String s1, s2, temps1 = "", temps2 = "";
		BigInteger num1 = null, num2 = null;
		while (sc.hasNext()) {
			s1 = sc.next();
			str = s1.split(",");
			for (int i = 0; i < str.length; i++) {
				temps1 = temps1 + str[i];
			}
			num1 = new BigInteger(temps1);

			s2 = sc.next();
			str = s2.split(",");
			for (int i = 0; i < str.length; i++) {
				temps2 = temps2 + str[i];
			}
			num2 = new BigInteger(temps2);
			System.out.println(num1.add(num2));
		}
	}
}
