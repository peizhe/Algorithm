package LeetCodeSecondEasy;
/**
 * �ж�һ�����ǲ��ǻ�������
 * 	1.ʹ��ת�����ַ�������ʽ�ٶȱȽ���
 * 	2.������д���������̫ţ��(�Ƚϵ�һ���ֱ�ӱȽ���)
 * @author MG
 *
 */
public class PalindromeNumber9 {
	public boolean isPalindrome(int x) {
		if(x != 0 && x % 10 == 0){
			return false;
		}
		
        int temp = 0;
        while(x > temp){
        	temp = temp * 10 + x % 10;
        	x /= 10;
        }
        
        //��xλ����ż��ʱ�ж�x == temp
        //��xλ��Ϊ����ʱ�ж�x == temp / 10
        return x == temp || x == temp / 10;
    }
}
