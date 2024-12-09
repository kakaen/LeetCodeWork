package Top100.链表;

import 代码随想录.链表.ListNode;

public class 链表中倒数最后k个节点BM8 {
    public static void main(String[] args) {

    }
    public static ListNode FindKthToTail(ListNode pHead,int k){
        if (pHead==null) return pHead;
        ListNode dummy=new ListNode(0);
        dummy.next=pHead;
        //返回倒数第k个节点
        ListNode fast=dummy;
        while (fast!=null&&k!=0){
            fast=fast.next;
            k--;
        }
        if (fast==null) return null; //不合法
        while (fast!=null){
            fast=fast.next;
            dummy=dummy.next;
        }
        return dummy;
    }
}

