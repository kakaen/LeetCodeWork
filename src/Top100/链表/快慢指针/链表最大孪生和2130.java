package Top100.链表.快慢指针;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 链表最大孪生和2130 {
    public static void main(String[] args) {

    }
}
class Solution2130{
    //这题和判断是否为回文链表一样
    public int pairSum(ListNode head){
        //大小为n且n为偶数的链表中，0<=i<=(n/2)
        int n=0;
        ListNode p=head;
        ListNode fast=head,slow=head;
        //fast的
        while (fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;
        //将第二段链表反转
        ListNode dummy=new ListNode(0,newHead);
        while (newHead!=null){
            ListNode temp=newHead.next;
            newHead.next=dummy.next;
            dummy.next=newHead;
            newHead=temp;
        }
        newHead=dummy.next;
        int maxCount=Integer.MIN_VALUE;
        while (head!=null&&newHead!=null){
            int count=head.val+ newHead.val;
            maxCount=Math.max(maxCount,count);
        }
        return maxCount;
    }
}
