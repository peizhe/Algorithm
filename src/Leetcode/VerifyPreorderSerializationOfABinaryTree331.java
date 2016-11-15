package Leetcode;

/**
 * �滻�ݹ��˼��: (�Ӻ���ǰ��  1������ + 2��'#' �滻��1��'#')
 * 	top : ��¼'#'�ĸ���
 * 	�Ӻ���ɨ�� : 
 * 		�����ǰ�ַ���'#': top ++ 
 * 		��������� : top - 2,
 * 			���top < 0,�򷵻� false
 * 			���top >= 0, Ȼ���ټ���һ��'#',��top ++
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
