package NineOj;

//1085£ºÇóroot(N, k)
import java.io.*;
import java.util.*;

public class TTestRoot {
	public static int change(int n, int k) {
		int sum = n % k;
		int temp = n / k;
		while (temp != 0) {
			n = temp;
			temp = n / k;
			sum = sum + n % k;
		}
		return sum;
	}

	private static int pow(int x, int y) {
		return (new Double(Math.pow(x, y))).intValue();
	}

	public static int root(int n, int k) {
		if (n < k) {
			return n;
		} else {
			int sum = change(n, k);
			return root(sum, k);
		}
	}

	public static void main(String[] mh) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> ls = new ArrayList<String>();

		do {
			String s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ls.add(s);
			}
		} while (true);

		for (int i = 0; i < ls.size(); i++) {
			String[] str = ls.get(i).split(" ");
			int x = Integer.parseInt(str[0]);
			int y = Integer.parseInt(str[1]);
			int k = Integer.parseInt(str[2]);
			System.out.println(root(pow(x, y), k));
		}
	}
}
