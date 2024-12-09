package Top100二刷;

import 代码随想录.链表.ListNode;

public class 两两交换链表中的节点24 {
    public ListNode swapPairs(ListNode head) {
        //两两交换链表中的节点，并返回交换后链表的头结点，不能修改节点内部的值

        return reversNode(head);
    }
    public ListNode reversNode(ListNode node){
        if (node==null||node.next==null) return node;
        ListNode newHead=node.next;
        node.next=reversNode(node.next.next);
        newHead.next=node;
        return newHead;
    }
    //方法二，使用栈的方式，这个和递归一样呀,迭代方法
    public ListNode swapPairs2(ListNode head){
        ListNode dummy=new ListNode(); //创建头结点
        ListNode tail=dummy;
        //遍历
        while (head!=null&&head.next!=null){
            ListNode temp=head.next.next;
            tail.next=head.next;
            head.next.next=head;
            head.next=null;
            tail=head;
            head=temp;
        }
        if (head!=null){
            tail.next=head;
        }
        return dummy.next;
    }
}
