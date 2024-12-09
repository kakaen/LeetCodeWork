package Top100.链表.前后指针;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 旋转链表61 {
    public static void main(String[] args) {

    }
}
class Solution61{
    public ListNode rotateRight(ListNode head,int k){
        if (head==null||k==0) return head;
        //将链表的每个节点向右移动k个位置
        ListNode p=head;
        ListNode tail=null;
        int length=1;
        while (p.next!=null){
            p=p.next;
            length++;
        }
        tail=p; //尾指针指向链表尾部
        tail.next=head;
        k=k%length;
        k=length-k;//移动k，就是头指针移动n-k.
        for (int i=0;i<k;i++){
            head=head.next;
            tail=tail.next;
        }
        tail.next=null; //断开首尾连接
        return head;
    }
}
