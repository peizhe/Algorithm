package Algorithm;

//不用加减乘除实现两个数的加法
public class Add {

	public int add(int a, int b) {
		int sum = 0, carry = 0;
		do {
			// 两个数作异或，就是两个数相加(不考虑进位的相加)
			sum = a ^ b;
			// 每一轮把当前的所有进位都标记出来赋值给carry
			carry = (a & b) << 1;

			a = sum;
			b = carry;
		} while (b != 0);

		return a;
	}
}
