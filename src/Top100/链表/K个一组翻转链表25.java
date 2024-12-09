package Top100.链表;

import 代码随想录.链表.ListNode;

public class K个一组翻转链表25 {
    public static void main(String[] args) {

    }
}
class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count=0;
        ListNode p=head;
        //统计共有多少个节点
        while (p!=null){
            count++;
            p=p.next;
        }
        count=count/k; //记录需要翻转多少组
        if (count<1) return head;
        ListNode newHead=null;
        ListNode dummmy=new ListNode(0,newHead);
        ListNode lastNode=null;
        ListNode last=newHead;
        int i=k;
        while (count>0){
            ListNode temp=p.next;
            if (newHead==null){
                newHead=p;
                last=p;
            }else{
                p.next=newHead;
                newHead=p;
            }
            p=temp;
            i--;
            if (i==0){
                count--;
                if (lastNode==null){
                    dummmy.next=newHead;
                    lastNode=last;
                }else{
                    lastNode.next=newHead;
                    lastNode=last;
                }
                i=k;
            }
        }
        return dummmy.next;
    }
}
