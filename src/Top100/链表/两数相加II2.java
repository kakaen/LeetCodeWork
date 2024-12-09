package Top100.链表;

import 代码随想录.链表.ListNode;

public class 两数相加II2 {
    public ListNode addTwoNumbers(ListNode l1,ListNode l2){
        ListNode dummy=new ListNode(0);
        ListNode tail=dummy;
        int flag=0;
        while (l1!=null||l2!=null||flag!=0){
            int count=flag;
            if (l1!=null){
                count+=l1.val;
                l1=l1.next;
            }
            if (l2!=null){
                count+=l2.val;
                l2=l2.next;
            }
            flag=count/10;
            count=count%10;
            ListNode node=new ListNode(count);
            tail.next=node;
            tail=node;
        }
        return dummy.next;
    }
}
