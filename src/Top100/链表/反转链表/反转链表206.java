package Top100.链表.反转链表;

import 代码随想录.链表.ListNode;

public class 反转链表206 {
    public static void main(String[] args) {

    }
}
class Solution206{

    public ListNode reverseList(ListNode head){
        if (head==null) return head;
        ListNode dummy=new ListNode();
        ListNode cur=head; //待移除的节点
        while (cur!=null){
            ListNode temp=cur.next; //防止断链
            cur.next=dummy.next;
            dummy.next=cur;
            cur=temp;
        }
        return dummy.next;
    }
    //方法二：递归的版本
    public ListNode reverseList2(ListNode head){
        ListNode dummy=new ListNode(0);
        ListNode temp;
        while (head!=null){
            temp=head.next;
            head.next=dummy.next;
            dummy.next=head;
            head=temp;
        }
        return dummy.next;
    }
    public ListNode reverseList3(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}
