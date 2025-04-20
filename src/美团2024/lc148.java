package 美团2024;

import 代码随想录.链表.ListNode;

import java.util.List;

public class lc148 {
    public static void main(String[] args) {

    }
    public void recorderLister(ListNode head){
        ListNode slow=head,fast=head;
        //先找到中间节点
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //断开前和后
        ListNode newHead=slow.next;
        slow.next=null;
        ListNode dummy=new ListNode(0);
        //将后边的链表进行翻转
        while (newHead!=null){
            ListNode temp=newHead.next;
            newHead.next=dummy.next;
            dummy.next=newHead;
            newHead=temp;
        }
        //合并前和后的node节点
        ListNode p=head,q=dummy.next;
        while (p!=null&&q!=null){
            ListNode temp1=p.next;
            ListNode temp2=q.next;
            p.next=q;
            q.next=temp1;
            p=temp1;
            q=temp2;
        }
    }
}
