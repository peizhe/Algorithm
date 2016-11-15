package Leetcode;
/**
 * ��β�����γ�һ������ָ���head��ʼ���ƣ�����len - ��k % len�� - 1���Ⱥ�Ľڵ�Ϊtemp����temp.nextΪ���������
 * @author MG
 *
 */
public class RotateList {

	public ListNode rotateRight(ListNode head, int k) {
		if(head == null || head.next == null || k == 0){
			return head;
		}
		
		int len = 1;
		/*�γ�һ����*/
        ListNode temp = head;
        //�ҵ����һ���ڵ�
        while(temp.next != null){
        	len ++;
        	temp = temp.next;
        }
        temp.next = head;
		
		//ÿ�ƶ����������ԭ����ͬ(k == 0��Ҫ���־ͷ��أ�Ҫ�ǵðѰѻ��Ͽ�)
        k = k % len;

        //���Ƶĳ���
        int rightMoveLength = len - k;
        while(rightMoveLength > 0){
        	temp = temp.next;
        	rightMoveLength --;
        }
        //���ƺ�Ľڵ��next��Ϊ�������ĳ�ʼ�ڵ�
        head = temp.next;
        //���ϻ�
        temp.next = null;
        
        return head;
	}
}

