package Top100.链表.灵神题单.遍历链表;

import 代码随想录.链表.ListNode;

import java.util.List;

public class 二进制列表转整数1290 {
    public static void main(String[] args) {
        二进制列表转整数1290 test = new 二进制列表转整数1290();
        ListNode head=new ListNode(1);
        ListNode h1=new ListNode(0);
        ListNode h2=new ListNode(1);
        head.next=h1;h1.next=h2;
        System.out.println(test.getDecimalValue(head));
    }
    public int getDecimalValue(ListNode head){
        int res=0;
        while (head!=null){
            res=res*2+head.val;
            head=head.next;
        }
        return res;
    }
}
