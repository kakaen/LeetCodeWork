package 代码随想录.链表;

import java.util.List;

public class 反转链表206 {
    public static void main(String[] args) {

    }
}
class Solution206{
    public ListNode reverseList(ListNode head){
       ListNode dummy=new ListNode(0,head);
       ListNode node0=dummy;
       ListNode node1=head;
       while (node1!=null&&node1.next!=null){
           ListNode node2=node1.next;
           ListNode node3=node2.next;

           node0.next=node2; //0->2
           node2.next=node1; //2->1
           node1.next=node3; //1->3

           node0=node1; //下一轮交换 0是1
           node1=node3; //

       }
       return dummy;
    }

    public ListNode reverseList2(ListNode head){
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=head;//记录要移动的当前node
        while (cur!=null){
            ListNode next=cur.next; //防止断链
            cur.next=dummyHead.next;
            dummyHead.next=cur;
            cur=next;
        }
        return dummyHead.next;
    }
}

