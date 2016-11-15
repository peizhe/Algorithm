package LeetCodeSecondEasy;
/**
 * 判断一个数是不是回文数：
 * 	1.使用转换成字符串的形式速度比较慢
 * 	2.下面所写方法，真的太牛了(比较到一半就直接比较了)
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
        
        //当x位数是偶数时判断x == temp
        //当x位数为奇数时判断x == temp / 10
        return x == temp || x == temp / 10;
    }
}
