package Top100.链表.反转链表;

import 代码随想录.链表.ListNode;

public class 反转链表II92 {
    public static void main(String[] args) {

    }
}
class Solution92{
    public ListNode reverseBetween(ListNode head,int left,int right){
        ListNode dummy=new ListNode(-1,head);
        //找到left之前的节点和right之后的节点
        ListNode preNode=dummy;
        ListNode cur=dummy.next;
        //当前节点指向left下标
        int i=0;
        for (i=0;i<left-1;i++){
            preNode=cur;
            cur=cur.next;
        }

        for (;i<right;i++){
            ListNode temp=cur.next;
            cur.next=temp.next;
            temp.next=preNode.next;
            preNode.next=temp;
        }
        return dummy.next;

    }
}
