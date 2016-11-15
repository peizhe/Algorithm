package Test;

public class Class1 {
	private static int count = 0;

	static {
		count ++;
	}

	public Class1() {
		count ++;
	}

	public static void main(String[] mh) {
		Class1 o1 = new Class1();
		Class1 o2 = new Class1();
		
		System.out.println(count);
	}
}
