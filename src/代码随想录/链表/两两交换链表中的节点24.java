package 代码随想录.链表;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;

public class 两两交换链表中的节点24 {
    public static void main(String[] args) {
        //两两交换节点

    }
}
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head; //只有一个节点或无节点,两两交换节点
        for (ListNode p=head;p!=null;p=p.next.next){
            if (p.next==null) break;
            ListNode temp=p.next;
            p.next=temp.next;
            temp.next=p;
        }
        return head.next;
    }
    //两两交换链表中的节点
    public ListNode swapPairs2(ListNode head){
        if (head==null||head.next==null) return head; //链表的长度不足2.直接返回
        ListNode newHead=head.next; //第二个节点
        head.next=swapPairs2(newHead.next); //递归的调用第一个节点的next应该指向下一个已经反转的节点
        newHead.next=head;
        return newHead;
    }

}