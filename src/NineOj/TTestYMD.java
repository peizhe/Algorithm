package NineOj;

//1070：今年的第几天？
import java.util.*;

public class TTestYMD {
	private static Scanner sc;

	// 判断是否是闰年
	public static boolean IsLeapYear(int year) {
		if (year % 400 == 0 || (year % 100 != 0 && year % 4 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	// 每个月的天数
	public static int monthSum(int year, int month) {
		boolean b = IsLeapYear(year);
		int days = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 2:
			if (b) {
				days = 29;
			} else {
				days = 28;
			}
		}
		return days;
	}

	public static void main(String[] mh) {
		sc = new Scanner(System.in);
		int year = sc.nextInt(), month = sc.nextInt(), day = sc.nextInt(), sum = 0;
		for (int i = 1; i < month; i++) {
			sum = sum + monthSum(year, i);
		}
		sum = sum + day;
		System.out.println(sum);
	}
}
