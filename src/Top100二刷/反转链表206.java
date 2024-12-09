package Top100二刷;

import 代码随想录.链表.ListNode;

public class 反转链表206 {
    public ListNode reverseList(ListNode head){
        //使用头插法可以将链表反转
        //创建一个虚拟节点dummy
        ListNode dummy=new ListNode();
        while (head!=null){
            ListNode next=head.next;
            //将当前节点插入到dummy的链表中
            head.next=dummy.next;
            dummy.next=head;
            head=next;
        }
        return dummy.next;
    }
    //原地反转链表
    public ListNode reverseList2(ListNode head){
        //使用双指针来进行链表的反转
        ListNode pre=null,cur=head;
        while (cur!=null){
            ListNode temp=cur.next; //记录下一次需要移动的节点
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
