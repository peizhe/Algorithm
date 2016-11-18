package LeetCodeSecondMedium;

public class IsSubsequence392 {
	public boolean isSubsequence(String t, String s) {
		if(s == null || t == null || s.length() < t.length()) {
			return false;
		} 
		
		if(s.equals(t)) {
			return true;
		}
		
		int begin = 0;
		for(int i = 0; i < t.length(); i++) {
			int index = s.indexOf(t.charAt(i), begin);
			
			if(index != -1) begin = index + 1;
			else return false;
		}
		
		return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
