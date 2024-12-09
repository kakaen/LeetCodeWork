package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 反转链表II92 {
    public static void main(String[] args) {

    }
    public ListNode reverseBetween(ListNode head,int left,int right){
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        //pre节点从dummy节点出发，走了left-1步。到达left下标的前一个节点
        for (int i=0;i<left-1;i++){
            pre=pre.next;
        }
        ListNode cur=pre.next; //cur指针指向当前要反转的节点的第一个节点
        ListNode temp;
        for (int i=0;i<right-left;i++){
            temp=cur.next; //当前要插入的节点
            cur.next=temp.next;
            temp.next=pre.next;
            pre.next=temp;
        }
        return dummy.next;
    }
}
