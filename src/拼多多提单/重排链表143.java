package 拼多多提单;

import java.util.List;

public class 重排链表143 {
    public static void main(String[] args) {

    }
    public void function(ListNode head){
        if(head==null||head.next==null) return;
        ListNode fast=head;
        ListNode slow=head;
        while (fast.next!=null&&fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //此时slow指向中间节点
        ListNode newHead=reverseList(slow.next);
        ListNode p=head;
        slow.next=null;
        while (newHead!=null){
            ListNode temp1=p.next;
            ListNode temp2=newHead.next;
            p.next=newHead;
            newHead.next=temp1;
            p=temp1;
            newHead=temp2;
        }
    }
    public ListNode  reverseList(ListNode head){
        ListNode dummy=new ListNode(0);
        while (head!=null){
            ListNode temp=head.next;
            head.next=dummy.next;
            dummy.next=head;
            head=temp;
        }
        return dummy.next;
    }
    class ListNode{
        int val;
        ListNode next;
        ListNode(){}
        ListNode(int val){this.val=val;}
    }
}
