package Top100.链表.前后指针;

import 代码随想录.链表.ListNode;

public class 交换链表中的节点1721 {
    public static void main(String[] args) {

    }
}
class Solution1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy=new ListNode(0,head);
        ListNode fast=dummy;
        ListNode slow=dummy;
        ListNode nodeK=null;
        for (int i=0;i<k;i++){
            fast=fast.next;
        }
        nodeK=fast;
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        int temp=nodeK.val;
        nodeK.val=slow.val;
        slow.val=temp;
        return head;
    }
}
