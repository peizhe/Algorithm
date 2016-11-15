package Interview;

import java.util.*;

/**
 * HULU 机试题第一题
 * 
 * 	给定一个字符串数组，其中的一些字符串是由数组中的其他两个字符串拼接而成。请找出数组中最长的这样的字符串
 * 
 * 	for example：
 * 		input : test tester testertest testing testingtester
 * 		output: testingtester
 * @author MG
 *
 */
public class StringMatch {

	public static String maxLengthString(List<String> strs){
		if(strs == null || strs.size() <= 0){
			return null;
		}
		
		Set<String> set = new HashSet<String>();
		for(String s : strs){
			set.add(s);
		}
		strs.clear();
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()){
			strs.add(iterator.next());
		}
		
		Collections.sort(strs, new Comparator<String>() {

			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
		
		int size = strs.size();
		for(int i = size - 1;i > 0;i --){
			String tempI = strs.get(i);
			for(int j = 0;j < i;j ++){
				String tempJ = strs.get(j);
				if(tempI.startsWith(tempJ) && set.contains(tempI.substring(tempJ.length()))){
					return strs.get(i);
				}
			}
		}
		
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = new String[]{"test","tester","testertest","testing","testingtester"};
		List<String> list = new ArrayList<String>();
		for(String str : s){
			list.add(str);
		}
		System.out.println(maxLengthString(list));
	}

}
