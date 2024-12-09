package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 环形链表II142 {
    public static void main(String[] args) {

    }
}
class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null) return null;
        ListNode slow=head;
        ListNode fast=head.next;
        while (slow!=fast){
            if (fast==null||fast.next==null) return null;
            slow=slow.next;
            fast=fast.next.next;

        }

        return head;
    }
    public ListNode detectCycle2(ListNode head){
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return head;
            } else {
                set.add(head);
            }
            head=head.next;
        }
        return null;
    }
    public ListNode detectCycle3(ListNode head){
        ListNode fast=head,slow=head;
        while (fast!=null){
            slow=slow.next;
            if (fast.next!=null){
                fast=fast.next.next;
            }else {
                return null;
            }
            if (slow==fast){
                ListNode ptr=head;
                while (ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }

        }
        return null;

    }
}
