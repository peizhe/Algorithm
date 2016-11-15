package Leetcode;
//ע��Z����������Խ�Z����0����26�ı�������Դ�
public class ExcelSheetColumnTitle {
	static char[] mapping = {'Z','A','B','C','D','E','F',
							 'G','H','I','J','K','L','M',
							 'N','O','P','Q','R','S','T',
							 'U','V','W','X','Y'};
	
	public static String convertToTitle(int n) {
		String result = "";
		int shang = n / 26,yushu = n % 26;
		if(yushu == 0){
			result = mapping[0] + result;
			shang --;
		}
		else{
			result = mapping[yushu] + result;
		}
		
		while(shang != 0){
			yushu = shang % 26;
			shang = shang / 26;
			if(yushu == 0){
				result = mapping[0] + result;
				shang --;
			}
			else{
				result = mapping[yushu] + result;
			}
		}
		
		return result;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 701;
		System.out.println(convertToTitle(a));
	}
}
