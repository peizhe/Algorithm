package LeetCodeSecondEasy;

import Structure.ListNode;

/**
 * ɾ���б��е�ָ���ڵ㣬����������������
 * 	1.��Ŀָ������ɾ�����һ���ڵ�
 *  2.��������б��ͷ���
 *  3.ɾ���ڵ��������д���
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
