package Leetcode;

/**
 * 替换递归的思想: (从后向前将  1个数字 + 2个'#' 替换成1个'#')
 * 	top : 记录'#'的个数
 * 	从后向扫描 : 
 * 		如果当前字符是'#': top ++ 
 * 		如果是数字 : top - 2,
 * 			如果top < 0,则返回 false
 * 			如过top >= 0, 然后再加入一个'#',即top ++
 * 
 * @author MG
 * 
 */
public class VerifyPreorderSerializationOfABinaryTree331 {

	public static boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0) {
			return true;
		}
		
		String[] c = preorder.split(",");
		int len = c.length;
		int top = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (c[i].equals("#")) {
				top++;
			} else {
				top -= 2;

				if (top < 0) return false;

				top++;
			}
		}

		return top == 1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}

}
