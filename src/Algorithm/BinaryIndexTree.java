package Algorithm;
/**
 * 
 * 这种思想真的厉害:
 * 	二叉索引树 : RangeSumQueryMutable307
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
		//初始化BinaryIndexTree,填充nodes数组
		for (int i = 0; i < length; i++) {
			update(i, A[i]);
		}
	}

	/**
	 * 更新一个元素，下标范围[0..N-1]
	 * 
	 * @param i
	 * @param v
	 */
	private void update(int i, int v) {
		int delta = v - nums[i];
		//把更改的值更改到nums
		nums[i] = v;
		
		i ++; // 下标范围转换为[1..N]
		while (1 <= i && i <= length) {
			Bitree[i] += delta;
			i += i & (-i);
		}	
	}

	/**
	 * 求前缀和A[0]+...+A[i]
	 * 
	 * @param i
	 * @return
	 */
	private int sum(int i) {
		i ++; // 下标范围转换为[1..N]
		int sum = 0;
		while (i > 0) {
			sum += Bitree[i];
			i -= i & (-i);
		}
		
		return sum;
	}

	/**
	 * 查询区间[L,R]所有元素的和，下标范围[0..N-1]
	 * 
	 * @param L
	 * @param R
	 * @return
	 */
	public int sumRange(int L, int R) {
		return sum(R) - sum(L - 1);
	}

	// 测试
	public static void main(String[] args) {
		int[] x = {2, 1, 3, 4, 5};
		BinaryIndexTree bit = new BinaryIndexTree(x);
		for (int i = 0; i < x.length; i++) {
			System.out.println(bit.sumRange(0, i));
		}
	}
}
