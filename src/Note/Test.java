package Note;

import java.util.*;
import java.util.Map.Entry;

public class Test {
	static Map<String, String> map = new TreeMap<String, String>();

	static Map<String, String> mapLink = new LinkedHashMap<String, String>(3,
			0.75f, true);

	public static void main(String[] mh) {
		for (int i = 0; i < 10; i++) {
			mapLink.put(i + "", i + "");
		}
		
		mapLink.get("2");
		mapLink.get("3");
		
		for (Entry<String, String> i : mapLink.entrySet()) {
			System.out.println(i.getKey() + ":" + i.getValue());
		}
	}
}
