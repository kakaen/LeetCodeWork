package Top100.链表.快慢指针;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 重排链表143 {
    public static void main(String[] args) {
        Solution143 solution143 = new Solution143();
        ListNode node5=new ListNode(5);
        ListNode node4=new ListNode(4,node5);
        ListNode node3=new ListNode(3,node4);
        ListNode node2=new ListNode(2,node3);
        ListNode head=new ListNode(1,node2);
        solution143.reorderList(head);
    }
}
class Solution143 {
    public void reorderList(ListNode head) {
        //给定一个
        ListNode slow=head,fast=head;
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //
        ListNode newHead=slow.next;
        slow.next=null;
        //将第二个链表进行反转
        ListNode dummy=new ListNode(0);
        ListNode cur=newHead;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=dummy.next;
            dummy.next=cur;
            cur=temp;
        }
        //进行合并
        ListNode temp1,temp2;
        ListNode p=head,q=dummy.next;
        while (p!=null&&q!=null){
            temp1=p.next;
            temp2=q.next;
            p.next=q;
            p=temp1;
            q.next=p;
            q=temp2;
        }
    }
}
