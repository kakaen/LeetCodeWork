package 代码随想录.链表;

import java.util.List;

public class 翻倍以链表形式表示的数字2816 {
    public static void main(String[] args) {
        翻倍以链表形式表示的数字2816 fan = new 翻倍以链表形式表示的数字2816();
        ListNode node3=new ListNode(9);
        ListNode node2=new ListNode(8,node3);
        ListNode head=new ListNode(1,node2);
        ListNode node = fan.doubleIt(head);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
    public ListNode doubleIt(ListNode head){
        head=reverse(head);
        ListNode dummy=new ListNode(-1);
        int flag=0;
        ListNode temp;
        while (head!=null){
            temp=head.next;
            int count=head.val*2+flag;
            flag=count/10;
            count=count%10;
            head.val=count;
            head.next=dummy.next;
            dummy.next=head;
            head=temp;
        }
        if (flag!=0){
            ListNode node=new ListNode(flag);
            node.next=dummy.next;
            dummy.next=node;
        }
        return dummy.next;
    }
    //反转链表
    public ListNode reverse(ListNode head){
        ListNode dummy=new ListNode(0);
        ListNode temp;
        while (head!=null){
            temp=head.next;
            head.next=dummy.next;
            dummy.next=head;
            head=temp;
        }
        return dummy.next;
    }
}
