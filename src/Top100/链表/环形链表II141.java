package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.HashSet;
import java.util.Set;

public class 环形链表II141 {
    public boolean hasCycle(ListNode head){
        ListNode node=new ListNode();
        node.next=head;
        ListNode slow=node,fast=node;
        while (fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            fast=fast.next;
            if (slow==fast) return true;
        }
        return false;
    }
    public boolean hasCycle2(ListNode head){
        Set<ListNode> set=new HashSet<>();

        while (head!=null){
            if (set.contains(head)) return true;
            set.add(head);
            head=head.next;
        }
        return false;
    }
}
