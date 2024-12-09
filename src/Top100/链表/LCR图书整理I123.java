package Top100.链表;

import 代码随想录.链表.ListNode;

public class LCR图书整理I123 {
    public static void main(String[] args) {

    }
}
class Solution123{
    public int[] reverseBookList(ListNode head) {
       //双指针
        ListNode cur=head;
        ListNode pre=null;
        while (cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return new int[]{1,1};
    }
}
