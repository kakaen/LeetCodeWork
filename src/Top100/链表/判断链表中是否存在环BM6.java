package Top100.链表;

import 代码随想录.链表.ListNode;

public class 判断链表中是否存在环BM6 {
    public static void main(String[] args) {

    }
}
class SolutionBM6{
    public boolean hasCycle(ListNode head){
        ListNode fast=head.next;
        ListNode slow=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow){
                return true;
            }
        }
        return false;
    }
}
