package Test;

import java.util.ArrayList;
import java.util.Map;

public class Test3 {
	static int x, y;
	
	static {
		x = 1;
	}

	static void method() {
		System.out.println(x);
		y = x ++ + ++ x;
		System.out.println(x + " " + y);
	}

	public static void main(String[] mh) {
//		x--;
//		method();
//		System.out.println(x + y + ++x);
//		
//		System.out.println("abc".startsWith(""));
		
		
//		short a = 129;
//		byte b = (byte)a;
//		System.out.println(b);
		
		String s = "hello";
		char[] ch = {'h','e','l','l','o'};
		System.out.println(s.equals(ch));
		
	}
}
