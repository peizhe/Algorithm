package LeetCodeSecondEasy;
/**
 * 这里有一个细节(可以直接将字符数组转换成字符串，不要再遍历)
 * 对于字符串的反转有如下几个方法：
 * 	1.直接转换成字符数组，倒序输出
 * 	2.转化成字符数组，前后交换(最快)
 * 	3.使用栈数据结构
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
        
        //很关键，不然就超时了
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
