package LeetCodeSecondEasy;
/**
 * �����ؼ�����6�������ô������:
 * 	 ���������д��ͦ����ģ����õ���һЩ��ѧ�Ľ��ۣ�
 *  ͨ���������ڲ�ѭ����д���Ժ����Ƶ�Ҫ������д����
 * @author MG
 *
 */
public class HappyNumber202 {
	public boolean isHappy(int n) {
        while(n > 6){
        	int next = 0;
        	while(n > 0){
        		next += (n % 10) * (n % 10);
        		n /= 10;
        	}
        	n = next;
        }
        
        return n == 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
