package LeetCodeSecondMedium;
/**
 * ���ַ���ת���ɶ���������(����Խ��)
 * 	ͦ�ɵķ���
 * @author MG
 *
 */
public class MaximumProductWordLengths318 {
	public int maxProduct(String[] words) {
		if(words == null || words.length < 2){
			return 0;
		}
		int len = words.length;
		int[] mark = new int[len];
		int i = 0,j;
		//�������ַ�����ʼ��Ϊ����������
		for(;i < len;i += 1){
			int size = words[i].length();
			for(j = 0;j < size;j ++){
				mark[i] |= 1 << (words[i].charAt(j) - 'a');
			}
		}
		
		int max = 0;
		for(i = 0;i < len - 1;i += 1){
			for(j = i + 1;j < len;j += 1){
				if((mark[i] & mark[j]) == 0){
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

	}
}
