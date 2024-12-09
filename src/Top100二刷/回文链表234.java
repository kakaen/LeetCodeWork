package Top100二刷;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 回文链表234 {
    public boolean isPalindrome(ListNode head) {
        //方法一：将原链表反转，再进行判断
        //方法二：使用O(1)级别的空间复杂度
        //先找到中间节点，使用快慢指针,如果是奇数个节点的话，中间节点归为前一个链表
        ListNode low=head,high=head.next;
        while (high!=null&&high.next!=null){
            low=low.next;
            high=high.next.next;
        }
        //low指向第一个节点的尾节点
       //将后一个链表进行反转
        ListNode cur=low.next,pre=null;
        while (cur!=null){
            ListNode tem=cur.next;
            cur.next=pre;
            pre=cur;
            cur=tem;
        }
        //pre指向反转的链表
        while (pre!=null){
            if (pre.val!=head.val) return false;
            pre=pre.next;
            head=head.next;
        }
        return true;
    }
}
