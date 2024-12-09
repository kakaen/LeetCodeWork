package Top100.链表;

import 代码随想录.链表.ListNode;
import java.util.*;
public class 相交链表160 {
    public static void main(String[] args) {

    }
}
class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        while (A!=B){
            A=(A==null?headB:A.next);
            B=(B==null?headA:B.next);
        }
        return A;
    }
}
