package Leetcode;

/**
 * Solution:
 * 	这道题特点 : 目录给出的格式是完全的dfs(一个目录走到尽头)
 * 	所以可以采用栈的方式(同一级目录中后面目录的计算不会影响前一个目录)
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s =
		 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		 System.out.println(lengthLongestPath(s));
		 
	}

}
