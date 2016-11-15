package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93 {
	public List<String> restoreIpAddressesBetter(String s) {
		List<String> res = new ArrayList<String>();
		
		if(s == null || s.length() < 4 || s.length() > 12){
			return res;
		}
		
		StringBuilder sb = new StringBuilder();
		for(int a = 1;a < 4; a++){
			for(int b = 1;b < 4; b++){
				for(int c = 1; c < 4; c++){
					for(int d = 1; d < 4; d++){
						if(a + b + c + d == s.length()){
							int n1 = Integer.parseInt(s.substring(0, a));
							int n2 = Integer.parseInt(s.substring(a, a + b));
							int n3 = Integer.parseInt(s.substring(a + b, a + b + c));
							int n4 = Integer.parseInt(s.substring(a + b + c));
							
							if(n1 <= 255 && n2 <= 255 && n3 <= 255 && n4 <= 255){
								sb.append(n1 + ".").append(n2 + ".").append(n3 + ".").append(n4);
								
								if(sb.length() - 3 == s.length()) res.add(sb.toString());
								
								sb.delete(0, sb.length());
							}
						}
					}
				}
			}
		}
		
		return res;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
