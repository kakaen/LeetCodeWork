package Top100二刷;

import 代码随想录.链表.ListNode;

public class 相交链表160 {
    public static void main(String[] args) {
        相交链表160 test = new 相交链表160();

    }
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
         //找出并返回两个链表相交的起始节点
        ListNode p=headA;
        ListNode q=headB;
        //
        while (p!=q){
            if (p==null){
                p=headB;
            }else{
                p=p.next;
            }
            if (q==null){
                q=headA;
            }else{
                q=q.next;
            }
        }
        //如果不存在相交的话，则返回的是null
        return p;

    }
}
