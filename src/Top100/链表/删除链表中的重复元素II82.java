package Top100.链表;

import 代码随想录.链表.ListNode;

public class 删除链表中的重复元素II82 {
    public ListNode deletDuplicates(ListNode head){
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode cur=head;//指向待判断是否重复的节点，
        ListNode next=cur.next;
        ListNode pre=dummy; //指向前一个已经判断了不重复的节点
        while (cur!=null&&cur.next!=null){
            if (cur.val!=next.val){
                pre=cur;
                cur=next;
                next=next.next;
            }else {
                while (next!=null&&next.val== cur.val){
                    next=next.next;
                }
                pre.next=next;
                cur=next;
                if (next==null) break;
                next=next.next;
            }
        }
        return dummy.next;
    }
}
