package LeetCodeSecondEasy;
/**
 * needle��haystack�е�һ�γ��ֵ�λ��
 * 	1.KMP�㷨
 * 	2.��ͳ��һ��һ���ַ����бȽ�
 * 	3.ϵͳ����indexOf(),Ч�ʸߵ��ǲ����㷨�ı���
 * 	4.��ȡÿһ���Ӵ����бȽ�(O(n))
 * @author MG
 *
 */
public class ImplementstrStr28 {
	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null){
			return -1;
		}
        return haystack.indexOf(needle);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
