package Leetcode;
/**
 * 运用比特位来作为标志，也是一种思想
 * @author MG
 *
 */
public class MaximumProductofWordLengths {
	
	public static int maxProduct(String[] words) {
		int len = words.length;
		int[] mask = new int[len];
		//预处理
		for(int i = 0;i < len;i ++){
			for(int j = 0;j < words[i].length();j ++){
				//将每个字符串进行处理，使高位对应a，低位对应z
				mask[i] |= (1 << (words[i].charAt(j) - 'a'));
			}
		}
		
		int max = 0;
		for(int i = 0;i < words.length;i ++){
			for(int j = i + 1;j < words.length;j ++){
				//判断mask中第i个和第j个数据进行与的结果，如果结果为0，证明对应位置上的字符不同，则不含相同字符
				if((mask[i] & mask[j]) == 0){
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		
		return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"abcw","baz","foo","bar","xtfn","abcdef"};
		System.out.println(maxProduct(s));
	}
}
