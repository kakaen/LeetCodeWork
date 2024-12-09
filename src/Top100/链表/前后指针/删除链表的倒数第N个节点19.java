package Top100.链表.前后指针;

import 代码随想录.链表.ListNode;

public class 删除链表的倒数第N个节点19 {
    public static void main(String[] args) {

    }
}
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode slow=dummy;
        ListNode fast=dummy;
        for (int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
}