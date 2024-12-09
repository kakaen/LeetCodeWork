package Top100.链表.快慢指针;

import 代码随想录.链表.ListNode;

public class 环形链表141 {
    public static void main(String[] args) {

    }
}
class Solution{
    public boolean hasCycle(ListNode head){
        ListNode fast=head,slow=head;
        //快慢指针，如果快指针能追上慢指针则说明
        while (fast!=null&&fast.next!=null){
            if (fast.next==slow) return true;
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}