package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.ArrayList;
import java.util.List;

public class 回文链表234 {
    public static void main(String[] args) {

    }
}
class Solution234 {
    public boolean isPalindrome(ListNode head) {
        //O(n)的
        List<Integer> list=new ArrayList<>();
        while (head!=null){
            list.add(head.val);
            head=head.next;
        }
        int left=0,right=list.size()-1;
        while (left<right){
            if (list.get(left)!=list.get(right)) return false;
        }
        return true;
    }
    //使用O(1)的空间进行判断
    public boolean isPalindrome2(ListNode head){
        //统计链表的节点个数，找到链表的后半部分
        ListNode endFirst=endOfFirstHalf(head);
        //反转链表的后半部分，
        ListNode revHead=reverseList(endFirst.next);
        while (revHead!=null){
            if (revHead.val!=head.val) return false;
            revHead=revHead.next;
            head=head.next;
        }
        return true;
    }
    //反转后半部分链表
    public ListNode reverseList(ListNode head){
        //
        ListNode cur=head,pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
    //找到链表的后半部尾部
    static ListNode endOfFirstHalf(ListNode head){
        ListNode low=head;
        ListNode high=head;
        while (low.next!=null&&high.next.next!=null){
            high=high.next.next;
            low=low.next;
        }
        return low;
    }
}