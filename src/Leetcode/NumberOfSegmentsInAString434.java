package Leetcode;

public class NumberOfSegmentsInAString434 {
	public static int countSegments(String s) {
		if(s == null || s.trim().length() == 0) return 0;
		int count = 0;
		
		String[] str = s.trim().split(" ");
		
		for(String c : str) {
			count += c.equals("") ? 0 : 1;
		}
		
        return count;
    }
	
	public static void main(String[] mh) {
		System.out.println(countSegments(", , , ,        a, eaefa"));
	}
}
