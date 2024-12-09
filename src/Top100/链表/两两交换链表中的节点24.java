package Top100.链表;

import 代码随想录.链表.ListNode;

public class 两两交换链表中的节点24 {
    public static void main(String[] args) {

    }
}
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode newHead=new ListNode(0,head);
        ListNode pre=newHead; //最后的节点index；
        ListNode p=head;
        while (p!=null&&p.next!=null){

            ListNode temp=p.next.next; //保存下一个
            pre.next=p.next;
            p.next.next=p;
            p.next=temp;
            pre=p;
            p=temp;
        }
        return newHead.next;
    }
    public ListNode swaPairs2(ListNode head){
        ListNode dummy=new ListNode(0,head);
        ListNode temp=dummy;
        while (temp.next!=null&&temp.next.next!=null){
            ListNode node1=temp.next;
            ListNode node2=temp.next.next;
            temp.next=node2;
            node1.next=node2.next;
            node2.next=node1;
            temp=node1;
        }
        return dummy.next;
    }
}
