package Top100.链表;

import 代码随想录.链表.ListNode;

public class 删除链表的倒数第N个节点19 {
    public static void main(String[] args) {

    }
}
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slow=new ListNode(-1);
        slow.next=head;
        head=slow;
        ListNode fast=head;
        while (n!=0){
            fast=fast.next;
            n--;
        }
        //使slow指向倒数n+1个节点
        while (fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return head.next;
    }
}