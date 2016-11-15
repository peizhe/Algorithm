package Leetcode;

public class RangeSumQueryMutable307 {
	private int length = 0;
	private int[] nums;
	private int[] Bitree;

	public RangeSumQueryMutable307(int[] A) {
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
    
    public static void main(String[] mh){
    	int[] nums = new int[]{1,3,5};
    	RangeSumQueryMutable307 rs = new RangeSumQueryMutable307(nums);
    	System.out.println(rs.sumRange(0, 2));
    	rs.update(1, 2);
    	System.out.println(rs.sumRange(0, 2));
    }
}
