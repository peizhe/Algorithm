package LeetCodeSecondMedium;

/**
 * ��Ҫ�����Լ���Ƶ�ջ�����
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
			//level��ʾ��ǰ�ļ����ڵĲ���
			int level = dir.lastIndexOf("\t") + 1;
			//dir.length() - level : �ܳ���ȥ��\t�ĸ���(\t�ĸ���ǡ��Ϊlevel), + 1��ʾ����"/"
			int currentLen = stack[level + 1] = stack[level] + (dir.length() - level) + 1;
			//currentLen - 1��ʾȥ�����һ��"/"
			if(dir.contains(".")) maxLength = Math.max(maxLength, currentLen - 1);
		}
		
		return maxLength;
	}
	
	public static void main(String[] mh) {
		String s = "dir\n    file.txt";
		System.out.println(lengthLongestPath(s));
	}
}
