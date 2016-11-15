package Algorithm;
/**
 * 
 * ����˼���������:
 * 	���������� : RangeSumQueryMutable307
 * 
 * @author MG
 *
 */
public class BinaryIndexTree {
	private int length = 0;
	private int[] nums;
	private int[] Bitree;

	public BinaryIndexTree(int[] A) {
		length = A.length;
		
		nums = new int[length];
		Bitree = new int[length + 1];
		//��ʼ��BinaryIndexTree,���nodes����
		for (int i = 0; i < length; i++) {
			update(i, A[i]);
		}
	}

	/**
	 * ����һ��Ԫ�أ��±귶Χ[0..N-1]
	 * 
	 * @param i
	 * @param v
	 */
	private void update(int i, int v) {
		int delta = v - nums[i];
		//�Ѹ��ĵ�ֵ���ĵ�nums
		nums[i] = v;
		
		i ++; // �±귶Χת��Ϊ[1..N]
		while (1 <= i && i <= length) {
			Bitree[i] += delta;
			i += i & (-i);
		}	
	}

	/**
	 * ��ǰ׺��A[0]+...+A[i]
	 * 
	 * @param i
	 * @return
	 */
	private int sum(int i) {
		i ++; // �±귶Χת��Ϊ[1..N]
		int sum = 0;
		while (i > 0) {
			sum += Bitree[i];
			i -= i & (-i);
		}
		
		return sum;
	}

	/**
	 * ��ѯ����[L,R]����Ԫ�صĺͣ��±귶Χ[0..N-1]
	 * 
	 * @param L
	 * @param R
	 * @return
	 */
	public int sumRange(int L, int R) {
		return sum(R) - sum(L - 1);
	}

	// ����
	public static void main(String[] args) {
		int[] x = {2, 1, 3, 4, 5};
		BinaryIndexTree bit = new BinaryIndexTree(x);
		for (int i = 0; i < x.length; i++) {
			System.out.println(bit.sumRange(0, i));
		}
	}
}
