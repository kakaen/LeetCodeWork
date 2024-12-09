package Top100.链表.快慢指针;

import 代码随想录.链表.ListNode;

public class 链表的中间节点876 {
    public static void main(String[] args) {

    }
}
class Soution876{
    public ListNode middleNode(ListNode head){
        //返回中间节点
        ListNode dummy=new ListNode(0,head);
        ListNode slow=dummy;
        ListNode fast=dummy;
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
