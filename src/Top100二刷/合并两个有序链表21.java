package Top100二刷;

import 代码随想录.链表.ListNode;

public class 合并两个有序链表21 {
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode();
        ListNode tail=dummy; //指向合并数组的尾节点
        while (list1!=null||list2!=null){
            ListNode temp;
            if (list1.val<list2.val){
                temp=list1.next;
                tail.next=list1;
                tail=list1;
                list1=temp;
            }else{
                temp=list2.next;
                tail.next=list2;
                tail=list2;
                list2=temp;
            }
        }
        if (list1!=null) tail.next=list1;
        if (list2!=null) tail.next=list2;
        return dummy.next;
    }
}
