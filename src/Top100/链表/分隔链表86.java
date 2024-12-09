package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 分隔链表86 {
    public ListNode partition(ListNode head,int x){
        ListNode leftHead=new ListNode(0);
        ListNode lefttail=leftHead;
        ListNode rightHead=new ListNode(0);
        ListNode righttail=rightHead;

        ListNode p=head;

        while (p!=null){
            ListNode node=new ListNode(p.val);
            if (p.val<x){
                lefttail.next=node;
                lefttail=node;
            } else if (p.val>=x) {
                righttail.next=node;
                righttail=node;
            }
            p=p.next;
        }
        lefttail.next=rightHead.next;
        return leftHead.next;
    }
    public ListNode partition2(ListNode head,int x){
        ListNode leftHead=new ListNode(0);
        ListNode leftTail=leftHead;
        ListNode rightHead=new ListNode(0);
        ListNode rightTail=rightHead;

        ListNode p=head;
        ListNode temp;
        while (p!=null){
            temp=p;
            temp.next=null;
            p=p.next;
            if (temp.val<x){
                leftTail.next=temp;
                leftTail=temp;
            }else{
                rightTail.next=temp;
                rightTail=temp;
            }
            p=p.next;
        }
        leftTail.next=rightHead.next;
        return leftHead.next;

    }
}
