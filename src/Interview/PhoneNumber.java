package Interview;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
/**
 * 可以运行，结果正确
 * @author MG
 *
 */
public class PhoneNumber {
	static String[] map = {"EIGHT", "NINE", "ZERO", "ONE", "SECOND", "THREE", "FOUR", "FIVE", "SIX", "SEVERN"};
	//临时结果
	static List<String> res = new ArrayList<String>();
	//最终结果
	static List<List<String>> fin = new ArrayList<List<String>>();
	
	public static String getMinNumber(String number){
		if(number == null || number.trim().length() == 0){
			return null;
		}
		
		Map<String, Integer> m = new Hashtable<String, Integer>();
		for(int i = 0;i < 10;i ++){
			m.put(map[i], i);
		}
		
		char[] array = number.toCharArray();
		//存储number字符个数
		int[] ch = new int[26];
		for(char c : array){
			ch[c - 'A'] ++;
		}
		
		dfs(ch, 0);
		
		StringBuilder sb = new StringBuilder();
		for(String str : fin.get(0)){
			sb.append(m.get(str));
		}
		
		return sb.toString();
	}
	
	private static void dfs(int[] ch,int position){
		if(position > 9 || check(ch) == -1){
			return;
		}
		
		if(check(ch) == 0){
			List<String> temp = new ArrayList<String>(res);
			fin.add(temp);
			return; 
		}
		
		for(int i = position;i < 10;i ++){
			char[] temp = map[i].toCharArray();
			int len = temp.length;
			for(int j = 0;j < len;j ++){
				ch[temp[j] - 'A'] --;
			}
			
			res.add(map[i]);
			dfs(ch, position + 1);
			res.remove(res.size() - 1);
			
			for(int j = 0;j < len;j ++){
				ch[temp[j] - 'A'] ++;
			}
		}
	}
	
	private static int check(int[] ch){
		for(int c : ch){
			if(c < 0){
				return -1;
			}
		}
		
		for(int c : ch){
			if(c > 0){
				return 1;
			}
		}
		
		return 0;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] mh) {
		// TODO Auto-generated method stub
		String s = "ZOENREO";
		System.out.println(getMinNumber(s));
	}

}
