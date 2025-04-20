package Top100二刷.链表;

import 代码随想录.链表.ListNode;

public class 环形链表II142 {
    public ListNode detectCycle(ListNode head){
        if (head==null) return null;
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast) break;
        }

        if (fast==null||fast.next==null) return null;
        ListNode second=head;
        while (second!=slow){
            second=second.next;
            slow=slow.next;
        }
        return slow;
    }
}
