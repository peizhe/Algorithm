package LeetCodeSecondMedium;

/**
 * 需要覆盖自己设计的栈最好了
 * 
 * @author MG
 *
 */
public class LongestAbsoluteFilePath388 {
	public static int lengthLongestPath(String input) {
		if(input == null || input.length() == 0) return 0;
		
		String[] dirs = input.split("\n");
		int[] stack = new int[dirs.length + 1];
		
		int maxLength = 0;
		for(String dir : dirs){
			//level表示当前文件所在的层数
			int level = dir.lastIndexOf("\t") + 1;
			//dir.length() - level : 总长度去掉\t的个数(\t的个数恰好为level), + 1表示加上"/"
			int currentLen = stack[level + 1] = stack[level] + (dir.length() - level) + 1;
			//currentLen - 1表示去掉最后一个"/"
			if(dir.contains(".")) maxLength = Math.max(maxLength, currentLen - 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] mh) {
		String s = "dir\n    file.txt";
		System.out.println(lengthLongestPath(s));
	}
}
