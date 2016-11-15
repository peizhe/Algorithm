package Algorithm;
//Ò»°ãµÄ×Ö·û´®Æ¥ÅäËã·¨
public class StringMatch {
	public static int match(String s,String t){
		char[] sch = s.toCharArray();
		char[] tch = t.toCharArray();
		int i,j;
		for(i = 0;i <= sch.length - tch.length;i ++){
			j = 0;
			for(;j < tch.length;j ++){
				if(sch[i + j] != tch[j]){
					break;
				}
			}
			if(j == tch.length){
				return i + 1;
			}
		}

		return -1;
	}
	public static void main(String[] mh){
		String s = "hgasidj";
		String t = "ps";
		System.out.println(match(s,t));
	}
}
