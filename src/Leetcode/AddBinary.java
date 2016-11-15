package Leetcode;

public class AddBinary {
	/**
	 * ���ⳤ�ȵľ�����
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String addBinary1(String a, String b) {
		String result = "";
		StringBuffer sba = new StringBuffer(a);
		StringBuffer sbb = new StringBuffer(b);

		char[] ach = sba.reverse().toString().toCharArray();
		char[] bch = sbb.reverse().toString().toCharArray();
		// ����һ���µ����飬���ڴ洢������
		int len = Math.max(ach.length, bch.length);
		int[] resultch = new int[len];

		int i = 0, j = 0;
		// ��λ��־
		int carryBit = 0;
		while (i < ach.length || j < bch.length) {
			// a�ַ������
			if (i == ach.length) {
				for (int k = j; k < bch.length; k++) {
					resultch[k] = bch[k] - '0' + carryBit;
					if (resultch[k] >= 2) {
						resultch[k] = resultch[k] - 2;
						carryBit = 1;
					} else {
						carryBit = 0;
					}
				}
				break;
			}

			// b�ַ������
			if (j == bch.length) {
				for (int k = i; k < ach.length; k++) {
					resultch[k] = ach[k] - '0' + carryBit;
					if (resultch[k] >= 2) {
						resultch[k] = resultch[k] - 2;
						carryBit = 1;
					} else {
						carryBit = 0;
					}
				}
				break;
			}

			int temp = 0;
			temp = (ach[i] - '0') + (bch[j] - '0') + carryBit;
			// ��λʹ�ú�����Ϊ0
			carryBit = 0;
			if (temp >= 2) {
				carryBit = 1;
				temp = temp - 2;
			}
			resultch[i] = temp;

			i++;
			j++;
		}

		if (carryBit == 1) {
			result = "1";
		}

		for (int k = resultch.length - 1; k >= 0; k--) {
			result = result + resultch[k];
		}

		return result;
	}

	public static void main(String[] args) {
		String a = "1010", b = "1011";
		System.out.println(addBinary1(a, b));
	}
}
