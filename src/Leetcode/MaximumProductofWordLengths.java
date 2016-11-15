package Leetcode;
/**
 * ���ñ���λ����Ϊ��־��Ҳ��һ��˼��
 * @author MG
 *
 */
public class MaximumProductofWordLengths {
	
	public static int maxProduct(String[] words) {
		int len = words.length;
		int[] mask = new int[len];
		//Ԥ����
		for(int i = 0;i < len;i ++){
			for(int j = 0;j < words[i].length();j ++){
				//��ÿ���ַ������д���ʹ��λ��Ӧa����λ��Ӧz
				mask[i] |= (1 << (words[i].charAt(j) - 'a'));
			}
		}
		
		int max = 0;
		for(int i = 0;i < words.length;i ++){
			for(int j = i + 1;j < words.length;j ++){
				//�ж�mask�е�i���͵�j�����ݽ�����Ľ����������Ϊ0��֤����Ӧλ���ϵ��ַ���ͬ���򲻺���ͬ�ַ�
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
