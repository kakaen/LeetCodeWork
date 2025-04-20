package Top100二刷.链表;

import 代码随想录.链表.ListNode;

public class 两两交换链表中的节点24 {

    //使用迭代的方式来实现
    public ListNode swapPairs2(ListNode head){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode tail=dummy;
        while (head!=null&&head.next!=null){
            //下一个要交换的节点
            ListNode temp=head.next.next;
            //交换当前节点
            tail.next=head.next;
            head.next.next=head;
            tail=head;
            tail.next=null;
            head=temp;
        }
        return dummy.next;

    }
    public ListNode swapPairs(ListNode head){
        //方法一：使用递归的方式来实现
        if (head==null||head.next==null) return head;

        ListNode newHead=head.next;
        head.next=swap(newHead.next);
        newHead.next=head;
        //两两交换node节点
        //使用递归的方式
        return newHead;
    }
    public ListNode swap(ListNode node){
        //递归失败的边界条件
        if (node==null||node.next==null) return node;

        ListNode temp=node.next;
        node.next=swapPairs(temp.next); //递归到下一层
        temp.next=node;
        return temp;
    }
}
