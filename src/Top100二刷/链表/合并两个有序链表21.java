package Top100二刷.链表;

import 代码随想录.链表.ListNode;

public class 合并两个有序链表21 {
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0); //虚节点
        ListNode cur=dummy;
        while (list1!=null&&list2!=null){
            if (list1.val<= list2.val){
                cur.next=list1;
                list1=list1.next;
            }else {
                cur.next=list2;
                list2=list2.next;
            }
            cur=cur.next;
        }
        cur.next=list1==null?list2:list1;
        return dummy.next;
    }
}
