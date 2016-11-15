package LeetCodeSecondEasy;
/**
 * needle在haystack中第一次出现的位置
 * 	1.KMP算法
 * 	2.传统的一个一个字符进行比较
 * 	3.系统函数indexOf(),效率高但是不是算法的本质
 * 	4.截取每一个子串进行比较(O(n))
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
