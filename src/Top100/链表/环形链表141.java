package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.HashMap;

public class 环形链表141 {
    public static void main(String[] args) {

    }
}
class Solution141 {
    public boolean hasCycle(ListNode head) {
       if (head==null||head.next==null) return false;
       ListNode slow=head;
       ListNode fast=head.next;
       while (slow!=fast){
           if (fast==null||slow==null) return false;
           slow=slow.next;
           fast=fast.next;
       }
       return true;
    }
}
