package HihoCoder;

public class RemoveChar1039 {
	
	public static int getMax(String s) {
		if(s == null || s.length() <= 1) {
			return 2 * s.length();
		}
		
		char[] ch = s.toCharArray();
		int len = ch.length;
		StringBuilder sb = new StringBuilder();
		
		int score = 0;
		sb.append(ch[0]);
		for(int i = 1; i < len; i++) {
			
		}
		
		return 0; 
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
