package Leetcode;

/**
 * Solution:
 * 	������ص� : Ŀ¼�����ĸ�ʽ����ȫ��dfs(һ��Ŀ¼�ߵ���ͷ)
 * 	���Կ��Բ���ջ�ķ�ʽ(ͬһ��Ŀ¼�к���Ŀ¼�ļ��㲻��Ӱ��ǰһ��Ŀ¼)
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
