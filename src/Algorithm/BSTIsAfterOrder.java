package Algorithm;

/**
 * 给定一个数组,判断是否是一棵二叉搜索树的后续遍历序列
 * 
 * @author Administrator
 *
 */
public class BSTIsAfterOrder {

	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		return IsTreeBST(sequence, 0, sequence.length - 1);
	}

	public boolean IsTreeBST(int[] sequence, int start, int end) {
		if (end <= start)
			return true;
		int i = start;
		for (; i < end; i++) {
			if (sequence[i] > sequence[end])
				break;// 找到左子树的划分位置
		}
		
		for (int j = i; j < end; j++) {
			if (sequence[j] < sequence[end]) return false;// 不满足条件则不是搜索树的后序遍历
		}
		return IsTreeBST(sequence, start, i - 1) && IsTreeBST(sequence, i, end - 1);// 递归对左右子树处理
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
