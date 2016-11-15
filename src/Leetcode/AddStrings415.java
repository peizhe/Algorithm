package Leetcode;

public class AddStrings415 {
	public static String addStrings(String x, String y) {
		char[] xch = x.toCharArray();
		char[] ych = y.toCharArray();

		for (char x1 : xch) {
			if (x1 < '0' || x1 > '9') {
				return "error";
			}
		}

		for (char y1 : ych) {
			if (y1 < '0' || y1 > '9') {
				return "error";
			}
		}

		int xlen = xch.length, ylen = ych.length;
		int xend = xlen - 1, yend = ylen - 1;
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		while (xend >= 0 || yend >= 0) {
			int xtemp, ytemp;

			xtemp = xend < 0 ? 0 : xch[xend] - '0';
			ytemp = yend < 0 ? 0 : ych[yend] - '0';

			int single = xtemp + ytemp + carry;
			sb.append(single % 10);
			carry = single / 10;

			xend--;
			yend--;
		}

		if(carry == 1){
			sb.append("1");
		}
		
		return sb.reverse().toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "9";
		String t = "1";
		System.out.println(addStrings(s, t));
	}

}
