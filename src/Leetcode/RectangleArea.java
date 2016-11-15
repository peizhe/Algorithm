package Leetcode;

public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int result = 0;
		int total = (D - B) * (C - A) + (H - F) * (G - E);
		int x1 = Math.max(A, E), y1 = Math.max(B, F), x2 = Math.min(C, G), y2 = Math
				.min(D, H);
		if (x2 <= x1 || y2 <= y1) {
			return total;
		}
		result = total - (x2 - x1) * (y2 - y1);
		return result;
	}

	public static void main(String[] mh) {
		RectangleArea ra = new RectangleArea();
		System.out.println(ra.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
	}
}
