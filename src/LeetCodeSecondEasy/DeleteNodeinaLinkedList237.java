package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * 删除列表中的指定节点，并且有三个条件：
 * 	1.题目指明不会删除最后一个节点
 *  2.不会给出列表的头结点
 *  3.删除节点在链表中存在
 * @author MG
 *
 */
public class DeleteNodeinaLinkedList237 {

	public void deleteNode(ListNode node) {
		if(node == null){
			return;
		}
		
		node.val = node.next.val;
		node.next = node.next.next;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
