package Top100.链表;

import 代码随想录.链表.ListNode;

public class 两数相加2 {
    public static void main(String[] args) {

    }
}
class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead=new ListNode(-1);
        ListNode pre=newHead;
        boolean isOne=false;//是否需要进一操作
        while (l1!=null&&l2!=null){
            if (isOne){
                if (l1.val+l2.val+1>=10){
                    isOne=true;
                }else{
                    isOne=false;
                }
                l1.val= (l1.val+l2.val+1)%10;
            }else{
                if (l1.val+l2.val>=10){
                    isOne=true;
                }else{
                    isOne=false;
                }
                l1.val=(l1.val+ l2.val)%10;
            }

            pre.next=l1;
            pre=pre.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            if (isOne){
                if (l1.val+1>=10){
                    isOne=true;
                }else{
                    isOne=false;
                }
                pre.next=l1;
                l1.val=(l1.val+1)%10;
            }else{
                pre.next=l1;
            }
            pre=pre.next;
            l1=l1.next;
        }
        while (l2!=null){
            if (isOne){
                if (l2.val+1>=10){
                    isOne=true;
                }else{
                    isOne=false;
                }
                pre.next=l2;
                l2.val=(l2.val+1)%10;
            }else{
                pre.next=l2;
            }
            pre=pre.next;
            l2=l2.next;
        }
        if (isOne){
            pre.next=new ListNode(1);
        }
        return newHead.next;
    }
    public ListNode addTwoNumbers2(ListNode l1,ListNode l2){
        ListNode newHead=new ListNode(0);
        ListNode pre=null;
        int flag=0;
        while (l1!=null||l2!=null){
            int x=l1==null?0:l1.val;
            int y=l2==null?0:l2.val;
            int sum=x+y+flag;

            flag=sum/10;
            sum=sum%10;
            pre.next=new ListNode(sum);
            pre=pre.next;
            if (l1!=null) l1=l1.next;
            if (l2!=null) l2=l2.next;
        }
        if (flag==1) pre.next=new ListNode(flag);
        return newHead;
    }
}
