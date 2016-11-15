package Leetcode;

/**
 * Created by MG on 2016/3/7.
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = getSize(head);
        if(length == n){
            return head.next;
        }

        ListNode tempHead = head;
        for(int i = 1;i < length - n;i ++){
            tempHead = tempHead.next;
        }

        tempHead.next = tempHead.next.next;

        return head;
    }

    public int getSize(ListNode head){
        int length = 0;
        while(head != null){
            length ++;
            head = head.next;
        }

        return length;
    }
}
