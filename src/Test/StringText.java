package Test;

public class StringText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		StringBuffer sb = new StringBuffer("Hello ");

		changeData(sb);

		System.out.println("sb = " + sb);
	}

	public static void changeData(StringBuffer strBuf) {

		strBuf = new StringBuffer("Hi");

		strBuf.append("World!");

	}
}
