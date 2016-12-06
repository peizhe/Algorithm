package LeetCodeSecondMedium;

public class LongestAbsoluteFilePath388 {
	public int lengthLongestPath(String input) {
        if(input == null || input.length() == 0) return 0;
        String[] str = input.split("\n");
        
        return str.length;
    }
	
	private int getMaxLength(String[] dirs, int index, StringBuilder sb) {
		for(int i = 0; i < dirs.length; i++) {
			int lastIndex = dirs[i].lastIndexOf("\t");
			
		}
	}
}
