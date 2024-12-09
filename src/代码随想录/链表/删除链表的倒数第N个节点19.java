package 代码随想录.链表;

public class 删除链表的倒数第N个节点19 {
    public static void main(String[] args) {

    }
}
class Solution19{
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        while (n>0){
            fast=fast.next;
            n--;
        }
        while (fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
       slow.next=slow.next.next;
        return dummy.next;
    }
}
