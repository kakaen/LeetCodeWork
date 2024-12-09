package Top100.链表;

import 代码随想录.链表.ListNode;

public class 反转链表206 {
    public static void main(String[] args) {

    }
}
class Solution206 {
    public ListNode reverseList(ListNode head) {
        //原地转置
      ListNode cur=head,pre=null;
      while (cur!=null){
          ListNode temp=cur.next; //暂存下一个节点信息
          cur.next=pre;
          pre=cur;
          cur=temp;
      }
      return pre;
    }
    //迭代的方法
    public ListNode reverseList2(ListNode head){
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=reverseList2(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }
}