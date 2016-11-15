package Note;
/**
 * 
 * 正数的补码与原码相同
 * 负数的补码为对该数的原码除符号位外各位取反，然后在最后一位加1
 * 	例如：
 * 		a: -3的源码(10000011)除符号位取反为: 1111 1100
 * 		b: 加1：1111 1101
 * 		c: 所以-3的补码是：1111 1101
 * 
 * 从补码计算这个数原码：
 * 	正数的补码就是它的原码
 * 	负数的原码计算：-3为例,-3的补码是1111 1101
 * 		原码为```补码除符号位按位取反 + 1```
 * 
 * 例如:
 * 	byte b = 127;
 * 	b = (byte) (b + 1);
 * 	最后b的值是多少？
 * 	127的二进制为: 0111 1111
 * 	127 + 1则为：0111 1111 + 1 = 1000 0000
 * 所以当计算1000 0000的值时，
 * 	a: 最高位为1，所以是负数
 * 	b: 取反加1：0111 1111 + 1 = 1000 0000
 * 	c: 计算1000 0000的值：128
 * 	d: 结果：128的负值，所以为-128，即byte类型的127加1的值为-128
 * 
 * @author MG
 *
 * 题目中一旦给出十六进制的数，它是给的补码的形式(牢记)!!!
 */
public class NumberBinaryEncoding {
	//java 整数4个字节
	static int max = Integer.MAX_VALUE;//十进制表示(2147483647)十六进制表示(Ox7FFFFFFF)
	static int min = Integer.MIN_VALUE;//十进制表示(-2147483648)十六进制表示(Ox80000000)
	
	//当a = 1,b = 0传入时，会产生死循环
	public static int plus(int a, int b){
		while(a + b > 0){
			a += 1;
			b -= 1;
		}
		
		return a + b;
	}
	
	public static void main(String[] mh){
		//整数最大值 + 1结果(Ox7FFFFFF + 1 重点理解上面的补码表示方法)：
		//结果是：-2147483648(Ox80000000)
		int x = max + 1;
		System.out.println(x);
		
		//最小值 - 1结果
		//结果是：2147483647(Ox7FFFFFFF)
		int y = min - 1;
		System.out.println(y);
		
		//最大值  + 最小值(Ox7FFFFFF + Ox80000000)
		//结果是：-1
		int xy = max + min;
		System.out.println(xy);
		
		//a = -2147483648(min) b = -2147483647(min + 1)  a + b = ?
		//结果是：1
		int m = min + (min + 1);
		System.out.println(m);
		
		//a = -2147483648 a + a = ?
		//结果：0
		int n = min + min;
		System.out.println(n);
		
		//a = 2147483647 a + a = ?
		//结果是：-2
		int p = max + max;
		System.out.println(p);
	}
}
