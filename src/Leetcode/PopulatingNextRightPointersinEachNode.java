package Leetcode;

public class PopulatingNextRightPointersinEachNode {
	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
	//���˼������̫ţ����
	public void connect(TreeLinkNode root) {
		if (root == null){
			return;
		}

		//���ѭ��������һ��ı������ڲ�ѭ�����Ƶ�ǰ��ı���
		while (root.left != null) {
			TreeLinkNode tmp = root;
			while (tmp != null) {
				tmp.left.next = tmp.right;
				if (tmp.next != null){
					tmp.right.next = tmp.next.left;
				}	
				tmp = tmp.next;
			}
			root = root.left;
		}
	}
}
