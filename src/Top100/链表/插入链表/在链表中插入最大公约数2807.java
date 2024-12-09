package Top100.链表.插入链表;

import 代码随想录.链表.ListNode;

public class 在链表中插入最大公约数2807 {
    public static void main(String[] args) {

    }
}
class Solution2807 {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy=new ListNode(0,head);
        ListNode cur=dummy;
        //当存在两个节点时才进行插入
        while (cur.next!=null&&cur.next.next!=null){

            //计算最大公约数
            int val=maxNumber(Math.max(cur.next.val,cur.next.next.val),
                    Math.min(cur.next.val,cur.next.next.val));
            ListNode addNode=new ListNode(val,cur.next.next);
            cur.next.next=addNode;
            cur=addNode;
        }
        return dummy.next;
    }
    //计算最大公约数,num1>num2
    public int maxNumber(int num1,int num2){
        while (num2!=0){
            int temp=num1%num2;
            num1=num2;
            num2=temp;
        }
        return num1;
    }
    public ListNode insertGreatestCommonDivisors2(ListNode head){
        ListNode cur=head;
        while (cur.next!=null){
            int val=maxNumber(Math.max(cur.val,cur.next.val),Math.min(cur.val,cur.next.val));
            ListNode addNode=new ListNode(val,cur.next);
            cur=addNode;
        }
        return head;
    }
}
