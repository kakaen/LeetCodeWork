package 美团面试手撕题;

import 代码随想录.链表.ListNode;

public class 合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
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
        tail.next=list1!=null?list1:list2;
        return dummy.next;
    }
    //使用递归的方式来实现
    public ListNode mergeTwoLists2(ListNode list1,ListNode list2){
        if(list1==null){
            return list2;
        } else if (list2==null) {
            return list1;
        } else if (list1.val<list2.val) {
            list1.next=mergeTwoLists(list1.next,list2);
            return list1;
        }else {
            list2.next=mergeTwoLists(list1,list2.next);
            return list2;
        }
    }
}
