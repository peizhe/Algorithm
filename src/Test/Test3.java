package Test;

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
		x--;
		method();
		System.out.println(x + y + ++x);
		
		System.out.println("abc".startsWith(""));	
	}
}
