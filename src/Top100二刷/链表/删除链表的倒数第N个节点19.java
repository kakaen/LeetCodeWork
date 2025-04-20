package Top100二刷.链表;

import 代码随想录.链表.ListNode;

public class 删除链表的倒数第N个节点19 {
    public ListNode removeNthFromEnd2(ListNode head,int n){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy,fast=dummy;
        for (int i=0;i<n;i++){
            fast=fast.next;
        }
        while (fast.next!=null){
            fast= fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }
    public ListNode removeNthFromEnd(ListNode head,int n){
        //删除倒数第N个节点。
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        //先创建一个虚拟节点，使得删除头结点时也任然适用。
        //使用快慢指针，先让快指针先走n步
        ListNode slow=dummy,fast=dummy;
        //fast先走n步
        for (int i=1;i<=n;i++){
            fast=fast.next;
        }

        //slow再走,如果是fast!=null的条件，
        // 那当fast走到null时，slow正好在倒数第n个节点上。
        //因此我们使用fast.next!=null
        while (fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //此时slow处于倒数第n个节点前
        slow.next=slow.next.next;

        return dummy.next;
    }
}
