package Interview;
/**
 * °Ù¶È»úÊÔ
 * @author MG
 *
 */
public class SubStringCount {
	public static int getCount(String s){
		if(s == null || s.trim().length() == 0){
			return 0;
		}
		
		int[] map = new int[26];
		
		char[] ch = s.toCharArray();
		int len = ch.length;
		int count = 1;
		
		for(int i = 1;i < len;i ++){
			if(ch[i] == ch[i - 1]){
				count += 1;
			} else {
				if(count > map[ch[i - 1] - 'a']){
					map[ch[i - 1] - 'a'] = count;
				}
				count = 1;
			}
			
			if(i == len - 1 && count > map[ch[i] - 'a']){
				map[ch[i] - 'a'] = count;
			}
		}
		
		
		int sum = 0;
		for(int i = 0;i < 26;i ++){
			sum += map[i];
		}
		
		return sum;
	}
	
	public static void main(String[] mh){
		String s = "aaabbaad";
		System.out.println(getCount(s));
	}
}
