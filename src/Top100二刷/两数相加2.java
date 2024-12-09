package Top100二刷;

import 代码随想录.链表.ListNode;

public class 两数相加2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //每位数字都是按照逆序的方式进行存储的，
        int flag=0; //判断是否进位
        ListNode dummy=new ListNode();
        ListNode tail=dummy;
        ListNode temp;
        while (l1!=null&&l2!=null){
            int val=l1.val+l2.val+flag;
            flag=val/10; //除以10得到进位数
            val=val%10;
            temp=l1.next;
            l1.val=val;
            tail.next=l1;
            tail=l1;
            l1=temp;
            l2=l2.next;
        }
        while (l1!=null){
            int val=l1.val+flag;
            flag=val/10;
            val=val%10;
            temp=l1.next;
            l1.val=val;
            tail.next=l1;
            tail=l1;
            l1=temp;
        }
        while (l2!=null){
            int val=l2.val+flag;
            flag=val/10;
            val=val%10;
            temp=l2.next;
            l2.val=val;
            tail.next=l2;
            tail=l2;
            l2=temp;
        }
        if (flag==1){
            tail.next=new ListNode(flag);
        }
        return dummy.next;
    }
}
