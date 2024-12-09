package Top100二刷;

import 代码随想录.链表.ListNode;

public class 环形链表141 {
    public boolean hasCycle(ListNode head){
        ListNode slow=head,fast=head.next;
        while (fast!=null&&fast.next!=null){
            if (fast==slow) return true;
            fast=fast.next.next;
            slow=slow.next;
        }
        return false;
    }
}
