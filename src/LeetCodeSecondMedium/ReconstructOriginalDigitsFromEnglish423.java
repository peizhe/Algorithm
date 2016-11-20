package LeetCodeSecondMedium;

public class ReconstructOriginalDigitsFromEnglish423 {
	
	public String originalDigits(String s) {
		if(s == null || s.length() == 0) {
			return "";
		}
		
        int[] count = new int[10];
        int len = s.length();
        for(int i = 0; i < len; i++) {
        	char c = s.charAt(i);
        	switch(c) {
        		case 'z' :
        			count[0] ++; //0
        			break;
        		case 'w' :
        			count[2] ++; //2
        			break;
        		case 'u' :
        			count[4] ++; //4
        			break;
        		case 'x' :
        			count[6] ++; //6
        			break;
        		case 'g' :
        			count[8] ++; //8
        			break;
        		case 'o' :
        			count[1] ++; //1 - 0 - 2 - 4
        			break;
        		case 'h' :
        			count[3] ++; //3 - 8
        			break;
        		case 'v' :
        			count[5] ++; //5 - 7
        			break;
        		case 's' :
        			count[7] ++; //7 - 6
        			break;
        		case 'i' :
        			count[9] ++; //9 - 5 - 6 - 8
        			break;
        	}
        }
        
        count[1] -= count[0] + count[2] + count[4];
        count[3] -= count[8];
        count[7] -= count[6];
        count[5] -= count[7];
        count[9] -= count[5] + count[6] + count[8];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
        	for(int j = 0; j < count[i]; j++) {
        		sb.append(i);
        	}
        }
        
        return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
