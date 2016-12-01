package Leetcode;

import Structure.TreeLinkNode;

public class PopulatingNextRightPointersinEachNode {
	
	//这个思想真是太牛叉了
	public void connect(TreeLinkNode root) {
		if (root == null){
			return;
		}

		//外层循环控制下一层的遍历，内层循环控制当前层的遍历
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
