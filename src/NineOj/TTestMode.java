package NineOj;

//1057：众数
import java.io.*;
import java.util.*;

public class TTestMode {
	public static void main(String[] mh) throws IOException {
		int[] sum;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> ls = new ArrayList<String>();
		String s;
		do {
			s = br.readLine();
			if (s.equals("")) {
				break;
			} else {
				ls.add(s);
			}
		} while (true);

		for (int i = 0; i < ls.size(); i++) {
			sum = new int[11];
			for (int k = 1; k < 11; k++) {
				sum[k] = 0;
			}

			String[] str = ls.get(i).split(" ");
			for (int j = 0; j < str.length; j++) {
				sum[Integer.parseInt(str[j])]++;
			}

			int max = sum[1], index = 1;

			for (int j = 2; j < 11; j++) {
				if (sum[j] > max) {
					max = sum[j];
					index = j;
				}
			}
			System.out.println("众数是:" + index);
		}
	}
}
