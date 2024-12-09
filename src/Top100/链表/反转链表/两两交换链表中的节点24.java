package Top100.链表.反转链表;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 两两交换链表中的节点24 {
    public static void main(String[] args) {

    }
}
class Solution24{
    //递归的方式实现两两链表的交换
    public ListNode swapPairs(ListNode head){
        //递归结束的边界条件
        if (head==null||head.next==null) return head;
        ListNode p=head.next;
        head.next=swapPairs(p.next);
        p.next=head;
        return p;
    }
    //迭代的方式实现两两链表的交换
    public ListNode swapPairs2(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(-1,head);
        ListNode preNode=dummy;
        ListNode cur=dummy.next;
        while (cur!=null&&cur.next!=null){
            ListNode temp=cur.next.next;//防止断链，下一个要交换的节点
            preNode.next=cur.next;
            cur.next.next=cur;
            cur.next=temp;
            preNode=cur;
            cur=temp;
        }
        return dummy.next;
    }
}
