package Algorithm;

public class BigIntegerMul {
	//保存结果,但是无疑浪费了很大的空间
	private static int[] result = new int[10000];

	private static String reverseString(String number) {
		StringBuilder builder = new StringBuilder();
		int i, length = number.length();
		for (i = length - 1; i >= 0; i--)
			builder.append(number.charAt(i));
		return builder.toString();
	}
	
	public static String multiply(String a, String b) {
		String num1 = reverseString(a);
		String num2 = reverseString(b);

		int i, j, length1 = num1.length(), length2 = num2.length(), high = 0;
		for (i = 0; i < length1; i++) {
			int c = 0;
			for (j = 0; j < length2; j++) {
				int temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + c + result[i + j];
				result[i + j] = temp % 10;
				c = temp / 10;
			}
			
			while (c > 0) {
				int temp = result[i + j] + c;
				result[i + j] = temp % 10;
				c = temp / 10;
				j++;
			}
			
			if (j + i - 1 > high)
				high = j + i - 1;
		}

		while (high >= 0 && result[high] == 0)
			high--;
		
		if (high < 0)
			return "0";
		else {
			StringBuilder builder = new StringBuilder();
			for (i = high; i >= 0; i--)
				builder.append(result[i]);
			
			return builder.toString();
		}
	}
}
