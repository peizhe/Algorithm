package Algorithm;

//���üӼ��˳�ʵ���������ļӷ�
public class Add {

	public int add(int a, int b) {
		int sum = 0, carry = 0;
		do {
			// ����������򣬾������������(�����ǽ�λ�����)
			sum = a ^ b;
			// ÿһ�ְѵ�ǰ�����н�λ����ǳ�����ֵ��carry
			carry = (a & b) << 1;

			a = sum;
			b = carry;
		} while (b != 0);

		return a;
	}
}
