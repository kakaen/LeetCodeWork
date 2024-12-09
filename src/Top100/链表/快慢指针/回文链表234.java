package Top100.链表.快慢指针;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 回文链表234 {
    public static void main(String[] args) {
        Solution234 solution234 = new Solution234();
    }
}
class Solution234{
    public boolean isPalindrome(ListNode head){
        //进行反转链表
        ListNode fast=head,slow=head;
        //当链表为奇数指向中间，偶数指向第一个中间节点

        while (fast!=null&&fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //slow指向null进行断连
        ListNode newHead=slow.next;
        slow.next=null;
        //slow指向中间节点，当为偶数时指向第二个中间节点
        //将前半部分的链表进行反转。
        ListNode dummy=new ListNode(0,newHead);
        ListNode p=dummy.next;
        while (p!=null){
            ListNode temp=p.next;
            p.next=dummy.next;
            dummy.next=p;
            p=temp;
        }
        newHead=dummy.next;
        while (newHead!=null){
            if (newHead.val!=head.val) return false;
            newHead=newHead.next;
            head=head.next;
        }
        return true;
    }
    public boolean isPalindrome2(ListNode head){
        //先使用快慢指针指向中间，如果是奇数则指向中间，如果是偶数则指向第二个节点
        ListNode slow=head,fast=head;
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        //将slow指针指向的后半段链表进行反转
        ListNode dummy=new ListNode(0,slow);
        while (slow!=null){
            ListNode temp=slow.next;
            slow.next=dummy.next;
            dummy.next=slow;
            slow=temp;
        }
        ListNode nextHead=dummy.next;
        while (head!=null&&nextHead!=null){
            if (head.val!=nextHead.val) return false;
            head=head.next;
            nextHead=nextHead.next;
        }
        return true;
    }
}
