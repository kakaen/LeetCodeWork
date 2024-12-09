package Top100二刷;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import 代码随想录.链表.ListNode;

public class 环形链表II142 {
    public ListNode detectCycle(ListNode head){
        //如果链表无环，则返回null，有环则返回入环的第一个节点
        ListNode fast=head,slow=head;
        while (fast!=null&&fast.next!=null){
            if (fast==slow){
                ListNode ptr=head;
                while (ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
            fast=fast.next.next;
            slow=slow.next;
        }
        return null;
    }
}
