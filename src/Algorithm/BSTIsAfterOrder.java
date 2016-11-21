package Algorithm;

/**
 * ����һ������,�ж��Ƿ���һ�ö����������ĺ�����������
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
				break;// �ҵ��������Ļ���λ��
		}
		
		for (int j = i; j < end; j++) {
			if (sequence[j] < sequence[end]) return false;// ���������������������ĺ������
		}
		return IsTreeBST(sequence, start, i - 1) && IsTreeBST(sequence, i, end - 1);// �ݹ��������������
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
