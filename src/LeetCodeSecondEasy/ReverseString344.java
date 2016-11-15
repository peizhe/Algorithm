package LeetCodeSecondEasy;
/**
 * ������һ��ϸ��(����ֱ�ӽ��ַ�����ת�����ַ�������Ҫ�ٱ���)
 * �����ַ����ķ�ת�����¼���������
 * 	1.ֱ��ת�����ַ����飬�������
 * 	2.ת�����ַ����飬ǰ�󽻻�(���)
 * 	3.ʹ��ջ���ݽṹ
 * @author MG
 *
 */
public class ReverseString344 {
	public static String reverseString(String s) {
		if(s == null || s.trim().equals("")){
			return s;
		}
        char[] ch = s.toCharArray();
        
        int begin = 0,end = ch.length - 1;
        while(begin < end){
        	char temp = ch[begin];
        	ch[begin] = ch[end];
        	ch[end] = temp;
        	
        	begin ++;
        	end --;
        }
        
        //�ܹؼ�����Ȼ�ͳ�ʱ��
        return new String(ch);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "adcvfgb vsds sddsfa bsd    ";
		System.out.println(reverseString(s));
	}
}
