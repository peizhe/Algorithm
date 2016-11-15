package NineOj;

//1076£ºNµÄ½×³Ë

import java.io.*;
import java.util.*;
import java.math.*;

public class STestFactorial {

	public static BigInteger Factorial(BigInteger n) {
		if (n.intValue() == 0 || n.intValue() == 1) {
			return new BigInteger("1");// ·µ»Ø1
		}

		return n.multiply(Factorial(n.subtract(new BigInteger("1"))));// n * Factorial()
	}

	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		ArrayList<Long> ls = new ArrayList<Long>();
		do {
			s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ls.add(Long.parseLong(s));
			}
		} while (true);

		for (int i = 0; i < ls.size(); i++) {
			BigInteger b = BigInteger.valueOf(ls.get(i));
			System.out.println(Factorial(b));
		}
	}
}
