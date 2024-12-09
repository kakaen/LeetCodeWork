package Top100.链表;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 合并两个有序的数组II {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1,ListNode list2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        while (list1!=null&&list2!=null){
            ListNode temp;
            if (list1.val<list2.val){
                temp=list1.next;
                tail.next=list1;
                tail=list1;
                tail.next=null;
                list1=temp;
            }else{
               temp=list2.next;
               tail.next=list2;
               tail=list2;
               tail.next=null;
               list2=temp;
            }
        }
        if (list1!=null) tail.next=list1;
        if (list2!=null) tail.next=list2;
        return dummy.next;
    }
}
