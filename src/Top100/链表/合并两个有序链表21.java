package Top100.链表;

import 代码随想录.链表.ListNode;

public class 合并两个有序链表21 {
    public static void main(String[] args) {
        String str="aa bb cc";
        String[] split = str.split(" ");
        for (String s : split) {
            System.out.println(s);
        }
    }
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
       //任意一个为null
        if(list1==null) return list2;
        if (list2==null) return list1;
        //新建一个头结点
        ListNode newHead=new ListNode(-1);
        ListNode last=newHead;
        while (list1!=null&&list2!=null){
            if (list1.val<list2.val){
                last=list1;
                list1=list1.next;
            }else{
                last=list2;
                list2=list2.next;
            }
            last=last.next;


        }
        if (list1!=null){
            last=list1;
        }
        if (list2!=null){
            last.next=list2;
        }
        return newHead.next;
    }
}
