package Leetcode;

public class ReverseInteger {
	public int reverse(int x) {
		String s = x + "";
		char[] ch = s.toCharArray();
		if (ch[0] == '-') {
			String temp = "";
			for (int i = ch.length - 1; i > 0; i--) {
				temp = temp + ch[i];
			}
			return (new Long("-" + temp) < Integer.MIN_VALUE) ? 0
					: new Integer("-" + temp);
		} else {
			String temp = "";
			for (int i = ch.length - 1; i >= 0; i--) {
				temp = temp + ch[i];
			}
			return (new Long(temp) > Integer.MAX_VALUE) ? 0 : new Integer(temp);
		}
	}

	public static void main(String[] mh) {
		ReverseInteger ri = new ReverseInteger();
		System.out.println(ri.reverse(123456));
	}

}
