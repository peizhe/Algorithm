package HihoCoder;

import java.util.Scanner;

/**
 * 
 * ��һ�������Ա�2���ݱ�ʾ������2������
 * 
 * 	����: 7 = 2 ^ 2 + 2 ^ 1 + 2 ^ 0
 * 		 7 = 2 ^ 3 - 2 ^ 0
 * 	
 * ���Խ����2(2^3 �� 2^0)
 * 
 * @author MG
 *
 */
public class PowersOfTwo1410 {

	private static Scanner input;

	public static int getMinCount(int N) {
		int number = 1;
		// �ҵ���һ����N���2����
		while (N >= number * 2) {
			number *= 2;
		}

		int size = 0;
		while (N != 0 && number != 0) {
			//����ж�д��̫����
			if (N >= number) {
				if (number * 2 - N > N - number) {//֤��N����number����(ȥ�������λ��1)
					N = N - number;
				} else {
					N = number * 2 - N;
				}

				size++;
			}

			number /= 2;
		}

		return size;
	}

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int N = input.nextInt();
		System.out.println(getMinCount(N));
	}
}
