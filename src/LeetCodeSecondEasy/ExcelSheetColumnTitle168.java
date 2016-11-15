package LeetCodeSecondEasy;

public class ExcelSheetColumnTitle168 {
	char[] map = new char[]{
    		'Z','A','B','C','D','E','F','G','H',
    		'I','J','K','L','M','N','O','P','Q',
    		'R','S','T','U','V','W','X','Y'
    };
	
	public String convertToTitle(int n) {
        String result = "";
        int yushu = n % 26;
        int shang = n / 26;
        
        if(yushu == 0){
        	shang --;
        }
        result = map[yushu] + result;
        
        while(shang != 0){
			yushu = shang % 26;
			shang = shang / 26;
			if(yushu == 0){
				shang --;
			}
			result = map[yushu] + result;
		}
		
		return result;
    }
}
