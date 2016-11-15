package Interview;
/**
 * 覆盖的题：
 * 	不太会额！
 * @author MG
 *
 */
public class CheckMemory {

	public static void main(String[] args) {
		
	}

	public static int getMaxInterval(String s, int times){
		if(s == null || s.trim().length() <= 0 || times < 1){
			return 0;
		}			
		
		return 0;
	}
	
	public static int getMax(String s, int len, int times) {

		if (null == s)
			return 0;

		int max = Integer.MIN_VALUE;

		int index = 0;

		int sub = len / times;

		if (sub * times < len)
			sub ++;

		char[] ca = s.toCharArray();

		int start = -1;

		int end = -1;

		for (char c : ca) {

			if (index % sub == 0) {

				if (end - start + 1 > max)
					max = end - start + 1;

				index = 0;
				start = -1;
				end = -1;
			}

			if (c == '1') {
				if (start == -1)
					start = index;

				end = index;
			}

			index ++;
		}

		if (end - start + 1 > max)
			max = end - start + 1;

		return max;
	}
}

