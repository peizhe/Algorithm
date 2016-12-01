package LeetCodeSecondMedium;

import Structure.TreeLinkNode;

public class PopulatingNextRightPointersInEachNode116 {
	public void connect(TreeLinkNode root) {
		if(root == null){
			return;
		}
		
		while(root.left != null){
			TreeLinkNode temp = root;
			while(temp != null){
				temp.left.next = temp.right;
				if(temp.next != null){
					temp.right.next = temp.next.left;
				}
				
				temp = temp.next;
			}
			
			root = root.left;
		}
	}
}
