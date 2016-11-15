package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 	先算术运算，后移位运算，最后位运算。
 * 
 * 	1、除了最高位（左边第一位），格雷码的位元完全上下对称（看下面列表）。比如第一个格雷码与最后一个格雷码对称（除了第一位），第二个格雷码与倒数第二个对称，以此类推。
 * 	2、最小的重复单元是 0 , 1。
 *			0 00
 *			0 01
 *			0 11
 *			0 10
 *			1 10
 *			1 11
 *			1 01
 *			1 00
 * 
 * 	在实现的时候，我们完全可以利用递归，在每一层前面加上0或者1，然后就可以列出所有的格雷码。
 * 	第一步：产生 0, 1 两个字符串。
 * 	第二步：在第一步的基础上，每一个字符串都加上0和1，但是每次只能加一个，所以得做两次。这样就变成了 00,01,11,10 （注意对称）。
 * 	第三步：在第二步的基础上，再给每个字符串都加上0和1，同样，每次只能加一个，这样就变成了 000,001,011,010,110,111,101,100。
 * 
 * 	
 * 	G:格雷码  B:二进位码
 * 	G(N) = B(n+1) XOR B(n)
 * 
 *  格雷码转二进位数:
 *  	二进位码第n位 = 二进位码第（n+1）位时异或格雷码第n位。因为二进位码和格雷码皆有相同位数，所以二进位码可从最高位的左边位元取0，以进行计算。
 *  	例如：格雷码0111，为4位数，所以其所转为之二进位码也必为4位数，因此可取转成之二进位码第五位为0，即 0 b3 b2 b1 b0。
 *  	0 xor 0 = 0，所以b3 = 0
 *  	0 xor 1 = 1，所以b2 = 1
 *  	1 xor 1 = 0，所以b1 = 0
 *  	0 xor 1 = 1，所以b0 = 1
 *  	因此所转换为之二进位码为0101
 * 
 * @author MG
 *
 */
public class GrayCode89 {
	public static List<Integer> grayCode(int n) {
		if(n < 0){
			return new ArrayList<Integer>();
		}
		List<Integer> res = new ArrayList<Integer>();
		res.add(0);
		
		for(int i = 0;i < n;i ++){
			int size = res.size();
			List<Integer> temp = new ArrayList<Integer>(); 
			for(int j = size - 1;j >= 0;j --){	
				temp.add((1 << i) + res.get(j));
			}
			
			res.addAll(temp);
		}
		
		return res;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = grayCode(0);
		for(int x : res){
			System.out.print(x + " ");
		}
	}

}
