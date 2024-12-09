package Top100二刷;

import 代码随想录.链表.ListNode;

public class 删除链表的倒数第N个节点19 {
    public ListNode removeNthFromEnd(ListNode head,int n){
        ListNode dummy=new ListNode(); //增加虚拟节点
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        //fast先走n步
        for (int i=0;i<n;i++){
            fast=fast.next;
        }
        //slow要指向要删除的前一个节点，因此使用fast.next来判断
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        slow.next=slow.next.next;
        return dummy.next;

    }
}
